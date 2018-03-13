/**
 * 
 */
package com.anyikang.components.pay.alipay;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;

/**
 * @author wangwei
 * @date 2018年3月13日
 */
@Service
public class AlipayService {
	
	protected static Logger logger = LoggerFactory.getLogger(AlipayService.class);
	
	@Value("${alipay.charset}")
	private String charset;
	@Value("${alipay.sign-type}")
	private String sign_type;
	@Value("${alipay.private-key}")
	private String private_key;
	@Value("${alipay.public-key}")
	private String alipay_public_key;
	@Value("${alipay.notify-url}")
	private String notify_url;
	@Value("${alipay.return-url}")
	private String return_url;
	
	@Autowired
	private AlipayClient alipayClient;
	
	
	/**
	 * 统一收单下单并支付wap页面接口
	 */
	public String alipay_trade_wap_pay(AlipayTradeWapPayModel model){
		AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
		
//		model.setTimeoutExpress(timeout_express);
	    model.setProductCode("QUICK_WAP_WAY");
		alipayRequest.setBizModel(model);//填充业务参数
	    alipayRequest.setNotifyUrl(notify_url);//服务器通知 post方式
	    alipayRequest.setReturnUrl(return_url);//网页重定向通知 get方式
	    String form="";
	    try {
	        form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
	    } catch (AlipayApiException e) {
	        e.printStackTrace();
	    }
	    System.out.println(form);
		return form;
	}
	
	/**
	 * 统一收单交易退款接口
	 */
	public void alipay_trade_refund(){
		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
		
		JSONObject bizContent=new JSONObject();
	    bizContent.put("out_trade_no", "20150320010101001");
	    bizContent.put("trade_no", "2014112611001004680073956707");
	    bizContent.put("refund_amount", 2.88);
	    bizContent.put("refund_reason", "正常退款");
	    bizContent.put("out_request_no", "HZ01RF001");
	    bizContent.put("operator_id", "OP001");
	    bizContent.put("store_id", "NJ_S_001");
	    bizContent.put("terminal_id", "NJ_T_001");
		
		request.setBizContent(bizContent.toString());
		try {
			AlipayTradeRefundResponse response = alipayClient.execute(request);
			if(response.isSuccess()){
				System.out.println("调用成功");
			} else {
				System.out.println("调用失败");
			}
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 统一收单交易退款查询接口
	 */
	public void alipay_trade_fastpay_refund_query(){
		AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
		
		JSONObject bizContent=new JSONObject();
	    bizContent.put("trade_no", "20150320010101001");
	    bizContent.put("out_trade_no", "2014112611001004680073956707");
	    bizContent.put("out_request_no", "2014112611001004680073956707");
		
		request.setBizContent(bizContent.toString());
		try {
			AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(request);
			if(response.isSuccess()){
				System.out.println("调用成功");
			} else {
				System.out.println("调用失败");
			}
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 *  统一收单线下交易查询接口
	 */
	public void alipay_trade_query(){
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
		
		JSONObject bizContent=new JSONObject();
		bizContent.put("out_trade_no", "20150320010101001");
	    bizContent.put("trade_no", "2014112611001004680 073956707");
		
		request.setBizContent(bizContent.toString());
		try {
			AlipayTradeQueryResponse response = alipayClient.execute(request);
			if(response.isSuccess()){
				System.out.println("调用成功");
				} else {
				System.out.println("调用失败");
				}
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 *  统一收单交易关闭接口
	 */
	public void alipay_trade_close(){
		AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
		
		JSONObject bizContent=new JSONObject();
		bizContent.put("trade_no", "2013112611001004680073956707");
		bizContent.put("out_trade_no", "HZ0120131127001");
		bizContent.put("operator_id", "YX01");
		
		request.setBizContent(bizContent.toString());
		try {
			AlipayTradeCloseResponse response = alipayClient.execute(request);
			if (response.isSuccess()) {
				System.out.println("调用成功");
			} else {
				System.out.println("调用失败");
			}
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 *  查询对账单下载地址接口
	 */
	public void alipay_data_dataservice_bill_downloadurl_query(){
		AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();//创建API对应的request类
		
		JSONObject bizContent=new JSONObject();
		bizContent.put("bill_type", "trade");
		bizContent.put("bill_date", "2016-04-05");
		
		request.setBizContent(bizContent.toString());//设置业务参数
		try {
			AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);
			System.out.print(response.getBody());
			//根据response中的结果继续业务逻辑处理
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 *  调用SDK验证签名
	 */
	public boolean rsaCheck(Map<String,String> params){
		boolean signVerified=true;
		try {
			signVerified= AlipaySignature.rsaCheckV1(params, alipay_public_key, charset, sign_type); //调用SDK验证签名
		} catch (AlipayApiException e) {
			logger.error("==========SDK验证签名失败");
			signVerified=false;
		}
		return signVerified;
	}
	
	

}
