/**
 * 
 */
package com.anyikang.components.pay.alipay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/**
 * @author wangwei
 * @date 2018年3月13日
 */
@Configuration
public class AlipayConfig {

	@Value("${alipay.url}")
	private String url;
	@Value("${alipay.app-id}")
	private String app_id;
	@Value("${alipay.format}")
	private String format;
	@Value("${alipay.charset}")
	private String charset;
	@Value("${alipay.sign-type}")
	private String sign_type;
	@Value("${alipay.private-key}")
	private String private_key;
	@Value("${alipay.public-key}")
	private String alipay_public_key;

	@Bean
	public AlipayClient alipayClient() {
		return new DefaultAlipayClient(url, app_id, private_key, format, charset, alipay_public_key, sign_type);
	}

}
