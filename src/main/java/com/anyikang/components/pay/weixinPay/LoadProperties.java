package com.anyikang.components.pay.weixinPay;

import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author tz
 *  加载配置文件  目前配置文件名字固定为 nativepay.properties
 */
public class LoadProperties {

	/**
	 * 加载原生支付的配置信息
	 */
	private static Properties nativeinfo = new Properties();

	static {
		try {
			InputStream is = LoadProperties.class.getClassLoader().getResourceAsStream("nativepay.properties");
			nativeinfo.load(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 取属性值
	 * 
	 * @param key
	 * @return
	 */
	public static String getPayProperty(String key) {
		return nativeinfo.getProperty(key);
	}

}
