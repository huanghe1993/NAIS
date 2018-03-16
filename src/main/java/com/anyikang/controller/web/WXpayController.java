package com.anyikang.controller.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anyikang.components.pay.weixinPay.WeiXinPayService;
import com.anyikang.service.PayService;
import com.anyikang.service.UserOrderService;
import com.anyikang.utils.StringUtil;

/**
 * 微信支付
 * @author LvXiaoxiong
 * @date 2018-03-14
 *
 */
@RestController
@RequestMapping("/web/wxpay")
public class WXpayController {

private Logger logger = LoggerFactory.getLogger(WXpayController.class);
	
	@Autowired
    private WeiXinPayService weixinPayService;
	@Autowired
	private UserOrderService userOrdersService;
	@Autowired
    private PayService payService;
	
	
	

	@RequestMapping(value = "/pay")
	public Map<String, String> weixinPay(HttpServletRequest request) {
		Map<String, String> putMap = new HashMap<String, String>();
		String payTitle = request.getParameter("payTitle");
		String  totalAmount = request.getParameter("totalAmount");
		putMap.put("pay_title", payTitle);// 支付标题
		// 控制器调用的时候填入，jar里面会自动填入微信
		putMap.put("total_fee", totalAmount);// 金额 都是以分单位，支付宝传入的时候会自动变成分单位
		String outTradeNo = "10001" + System.currentTimeMillis()+ (long) (Math.random() * 1000000000L);
		putMap.put("out_trade_no", outTradeNo);
		putMap.put("spbill_create_ip", StringUtil.getInternetIp()); // 终端ip 微信支付需要 支付宝不需要
		Map<String, String>	nativePay = WeiXinPayService.weixinH5pay(putMap);

		if ("ERROE".equals(nativePay.get("code"))) {
			return nativePay;
		}

		return nativePay;
	}
}
