package com.anyikang.components.pay.weixinPay;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.anyikang.utils.StringUtil;



/**
 * @author tz <br>
 *  2017-9-13 12:29:41<br>
 *  
 * @category 原生支付逻辑业务层 <br>
 * 	
 *  Properties配置文件：一定要加载<br>
 *  public static String ali_private_key = LoadProperties.getPayProperty("ali_private_key");  商户私钥<br>
 *	public static String ali_public_key = LoadProperties.getPayProperty("ali_public_key"); 商户公钥<br>
 *	public static String ali_alipay_public_key = LoadProperties.getPayProperty("ali_alipay_public_key");支付宝公钥 <br>
 *	public static String ali_native_app_id = LoadProperties.getPayProperty("ali_native_app_id");  支付宝应用id<br>
 *	public static String wx_native_app_id = LoadProperties.getPayProperty("wx_app_id");  微信应用id<br>
 *	public static String wx_native_mch_id = LoadProperties.getPayProperty("wx_mch_id");  微信商户id<br>
 *	public static String wx_native_key = LoadProperties.getPayProperty("wx_key"); 微信秘钥<br>
 */

@Service
public class WeiXinPayService {
	
	
	/**
	 * 加载配置文件
	 */
	public static String ali_private_key = LoadProperties.getPayProperty("ali_private_key"); // 商户私钥
	public static String ali_public_key = LoadProperties.getPayProperty("ali_public_key"); // 商户公钥
	public static String ali_alipay_public_key = LoadProperties.getPayProperty("ali_alipay_public_key");// 支付宝公钥
	public static String ali_native_app_id = LoadProperties.getPayProperty("ali_native_app_id"); // 支付宝应用id
	public static String wx_native_app_id = LoadProperties.getPayProperty("wx_app_id"); // 微信应用id
	public static String wx_native_mch_id = LoadProperties.getPayProperty("wx_mch_id"); // 微信商户id
	public static String wx_native_key = LoadProperties.getPayProperty("wx_key"); // 微信秘钥
	public static String wxPayUrl = LoadProperties.getPayProperty("wxPayUrl"); // 微信预付单地址
	public static String wxQueryUrl = LoadProperties.getPayProperty("wxQueryUrl"); // 微信预付单地址

	


	/**
	 * 微信原生支付
	 * @param pay_title  支付标题
	 * @param out_trade_no  订单号
	 * @param total_fee  支付金额
	 * @param spbill_create_ip  生成订单的ip地址
	 * @param notify_url  回调地址  例：  https://tz.com/pay/notify/
	 * @return  Map 请看详细信息
	 */
	public static Map<String,String> weixinpay(Map<String,String> pa) {
		Map<String,String> result=new HashMap<String, String>();		
		//随机字符
		String nonce_str = StringUtil.getRandomNum(8);

		String body = pa.get("pay_title");
		
		String total_fee = pa.get("total_fee");
		String spbill_create_ip = pa.get("spbill_create_ip").split(",")[0];// "127.0.0.1";
		String notify_url=pa.get("notify_url");		
		System.out.println("notify_url是：" + notify_url);
		//支付类型
		String trade_type = "APP";

		float timestamp = System.currentTimeMillis() / 1000;
		// 参数：开始生成签名
		SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
		parameters.put("appid", wx_native_app_id);
		parameters.put("mch_id", wx_native_mch_id);
		parameters.put("nonce_str", nonce_str);
		parameters.put("body", body);
		parameters.put("out_trade_no", pa.get("out_trade_no"));
		parameters.put("total_fee", total_fee);
		parameters.put("notify_url", notify_url);
		parameters.put("trade_type", trade_type);
		parameters.put("spbill_create_ip", spbill_create_ip);
		String sign = WxSignUtils.createSign("UTF-8", parameters,wx_native_key);
		System.out.println("签名是：" + sign);
		parameters.put("sign", sign);		
		// 构造xml参数
		String xmlInfo = HttpXmlUtils.xmlInfo(parameters);
		String payNo = HttpXmlUtils.httpsRequest(wxPayUrl, xmlInfo);
		System.out.println("请求结果" + payNo);
		Map doXMLParse = null;
		String signStr = "";
		try {
			doXMLParse = HttpXmlUtils.doXMLParse(payNo);
			if("SUCCESS".equals(doXMLParse.get("return_code"))){
				SortedMap<Object, Object> againParameters = new TreeMap<Object, Object>();
				againParameters.put("appid", doXMLParse.get("appid"));
				againParameters.put("partnerid", wx_native_mch_id);
				againParameters.put("prepayid", doXMLParse.get("prepay_id"));
				againParameters.put("noncestr", StringUtil.getRandomNum(8));
				againParameters.put("timestamp", System.currentTimeMillis() / 1000);
				againParameters.put("package", "Sign=WXPay");
				String sign1 = WxSignUtils.createSign("UTF-8", againParameters,wx_native_key);
				againParameters.put("sign", sign1);				
				signStr = JSON.toJSONString(againParameters);
				System.out.println("再次签名结果" + signStr);
				result.put("code", "SUCCESS");
				result.put("msg", "签名成功");
				result.put("data", signStr);
				result.put("out_trade_no", pa.get("out_trade_no"));
			}else{
				result.put("code", "ERROR");
				result.put("msg", "签名失败");
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		result.put("service", "微信支付");
		System.out.println("=========================================================");		
		return result;

	}
	
	
	
	/**
	 * 微信订单查询
	 * @param out_trade_no  商户订单号
	 * @return
	 * @throws Exception
	 */
	public static Map<String,String> wxNativeQuery(String  out_trade_no) throws Exception{
		String code="";
		String msg="";
		String nonce_str=StringUtil.getRandomNum(8);		
		// 参数：开始生成签名
		SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
		parameters.put("appid", wx_native_app_id);
		parameters.put("mch_id", wx_native_mch_id);
		parameters.put("nonce_str", nonce_str);
		parameters.put("out_trade_no", out_trade_no);
		String sign = WxSignUtils.createSign("UTF-8", parameters,wx_native_key);
		System.out.println("签名是：" + sign);
		parameters.put("sign", sign);		
		
		// 构造xml参数
		String xmlInfo = HttpXmlUtils.xmlInfo(parameters);

		String payNo = HttpXmlUtils.httpsRequest(wxQueryUrl, xmlInfo);
		Map doXMLParse = HttpXmlUtils.doXMLParse(payNo);
		if("SUCCESS".equals(doXMLParse.get("return_code"))){
			if("SUCCESS".equals(doXMLParse.get("result_code"))){
				String trade_state=doXMLParse.get("trade_state")+"";
				if ("SUCCESS".equals(trade_state)) {
					code=trade_state;
					msg="支付成功";
				} else if ("REFUND".equals(trade_state)) {
					code=trade_state;
					msg="转入退款";
				} else if ("NOTPAY".equals(trade_state)) {
					code=trade_state;
					msg="未支付";
				} else if ("CLOSED".equals(trade_state)) {
					code=trade_state;
					msg="已关闭";
				} else if ("REVOKED".equals(trade_state)) {
					code=trade_state;
					msg="已撤销";
				}else if("USERPAYING".equals(trade_state)){					
					code=trade_state;
					msg="支付中";
				}else if("PAYERROR".equals(trade_state)){					
					code=trade_state;
					msg="支付失败(其他原因，如银行返回失败)";
				}
			}else{
				code="FAIL";
				msg=doXMLParse.get("err_code_des")+",确认后需重新查询";
			}
		}else{
			code="ERROE";
			msg="系统错误-查询失败";
		}
		doXMLParse.put("code", code);	
		doXMLParse.put("msg", msg);
		return doXMLParse;
	}
	/**
	 * 微信H5支付
	 * @param pay_title  支付标题
	 * @param out_trade_no  订单号
	 * @param total_fee  支付金额
	 * @param spbill_create_ip  生成订单的ip地址
	 * @param notify_url  回调地址  例：  https://tz.com/pay/notify/
	 * @return  Map 请看详细信息
	 */
	public static Map<String,String> weixinH5pay(Map<String,String> pa) {
		Map<String,String> result=new HashMap<String, String>();		
		//随机字符
		String nonce_str = StringUtil.getRandomNum(8);

		String body = pa.get("pay_title");
		
		String total_fee = pa.get("total_fee");
		String spbill_create_ip = pa.get("spbill_create_ip").split(",")[0];// "127.0.0.1";
		System.out.println("打印当前获取的ip地址:"+spbill_create_ip);
		String notify_url=pa.get("notify_url");		
		System.out.println("notify_url是：" + notify_url);
		//支付类型
		String trade_type = "MWEB";

		// 参数：开始生成签名
		SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
		parameters.put("appid", wx_native_app_id);
		parameters.put("mch_id", wx_native_mch_id);
		parameters.put("nonce_str", nonce_str);
		parameters.put("body", body);
		parameters.put("out_trade_no", pa.get("out_trade_no"));
		parameters.put("total_fee", total_fee);
		parameters.put("spbill_create_ip", spbill_create_ip);
		parameters.put("notify_url", notify_url);
		parameters.put("trade_type", trade_type);							
		parameters.put("scene_info", "{\"h5_info\": {\"type\":\"Wap\",\"wap_url\": \"https://tz.com\",\"wap_name\": \"tz支付\"}}");//域名需要在微信商户下配置
		String sign = WxSignUtils.createSign("UTF-8", parameters,wx_native_key);
		System.out.println("签名是：" + sign);
		parameters.put("sign", sign);		
		// 构造xml参数
		String xmlInfo = HttpXmlUtils.xmlInfo(parameters);
		System.out.println(xmlInfo);
		String payNo = HttpXmlUtils.httpsRequest(wxPayUrl, xmlInfo);
		System.out.println("请求结果" + payNo);
		Map doXMLParse = null;
		try {
			doXMLParse = HttpXmlUtils.doXMLParse(payNo);
			if("SUCCESS".equals(doXMLParse.get("return_code"))){
				if("SUCCESS".equals(doXMLParse.get("result_code"))){
					result.put("code", "SUCCESS");
					result.put("msg", "成功");
					result.put("data", JSON.toJSONString(doXMLParse));
					result.put("out_trade_no", pa.get("out_trade_no"));
				}else{
					result.put("code", "ERROR");
					result.put("msg", "失败");
				}
			}else{
				result.put("code", "ERROR");
				result.put("msg", "失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("service", "微信H5支付");
		System.out.println("=========================================================");		
		return result;

	}
	
	
}
