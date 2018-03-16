/**
 * 
 */
package com.anyikang.controller.web;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.anyikang.base.BaseResponse;
import com.anyikang.components.pay.alipay.AlipayService;
import com.anyikang.model.UserOrder;
import com.anyikang.model.Pay;
import com.anyikang.service.UserOrderService;
import com.anyikang.service.PayService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * 
 * @author wangwei
 * @date 2018年3月13日
 */
@RestController
@RequestMapping("/web/alipay")
public class AlipayController{
	
	private Logger logger = LoggerFactory.getLogger(AlipayController.class);
	
	@Autowired
    private AlipayService alipayService;
	@Autowired
	private UserOrderService ordersService;
	@Autowired
    private PayService payService;
	
	@PostMapping("/pay")
	  public BaseResponse<?> pay(String orderId) {
		BaseResponse<String> responseMessage = new BaseResponse<>();
		
		UserOrder userOrder=ordersService.selectById(orderId);
	    
	 // 封装请求支付信息
	    AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
	    model.setOutTradeNo(userOrder.getOrderCode());
	    model.setSubject(userOrder.getOrderName());
	    model.setTotalAmount(Double.toString(userOrder.getTotalAmount()));
	    model.setBody(userOrder.getDescription());
	    
		responseMessage.setStatus(1);
		responseMessage.setMsg("查询成功");
		responseMessage.setData(alipayService.alipay_trade_wap_pay(model));
		return responseMessage;
	  }
	
	@PostMapping("/payNotify")
	public String payNotify(HttpServletRequest request) {
		System.out.println("================进入支付通知==================");
			Map<String,String> params = new HashMap<String,String>();
			Map<String,String[]> requestParams = request.getParameterMap();
			for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				System.out.println("==================valueStr:"+valueStr);
				params.put(name, valueStr);
			}
			
			boolean signVerified = alipayService.rsaCheck(params); 

			if(signVerified) {//验证成功
				try {
					//商户订单号
					String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
					//支付宝交易号
					String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
					//交易状态
					String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
					System.out.println("--------------------------"+trade_status);
					
					
					EntityWrapper<UserOrder> entityWrapper=new EntityWrapper();
					entityWrapper.setEntity(new UserOrder());
			        entityWrapper.where("orders_code={0}", out_trade_no);
			        UserOrder userOrder=ordersService.selectOne(entityWrapper);
			        
			        Pay pay=new Pay();
		        	pay.setOrderId(userOrder.getId());
		        	pay.setPayTime(new Date());
		        	pay.setPayMethod(0);
		        	pay.setTradeCode(trade_no);
					
					if(trade_status.equals("WAIT_BUYER_PAY")){
						logger.warn("==========交易创建，等待买家付款");
						pay.setIsPay(0);
						payService.insert(pay);
					}else if(trade_status.equals("TRADE_CLOSED")){
						logger.warn("==========未付款交易超时关闭，或支付完成后全额退款");
					}else if(trade_status.equals("TRADE_SUCCESS")){
						logger.warn("==========交易支付成功");
						
				        if(userOrder!=null){
				        	EntityWrapper<Pay> payWrapper=new EntityWrapper();
							payWrapper.setEntity(new Pay());
							payWrapper.where("order_id={0}", userOrder.getId());
							Pay notPay=payService.selectOne(payWrapper);
							
							if(notPay!=null){
								notPay.setIsPay(1);
								payService.updateById(notPay);
								
							}else{
								pay.setIsPay(1);
								payService.insert(pay);
							}
				        }
					}else if (trade_status.equals("TRADE_FINISHED")){
						logger.warn("==========交易结束，不可退款");
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				return "success";
			}else {//验证失败
				return "fail";
			}
	}
	
}
