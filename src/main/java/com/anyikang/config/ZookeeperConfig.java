/**
 * 
 */
package com.anyikang.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wangwei
 * @date 2017年4月6日
 */
@Component
@ConfigurationProperties(prefix = "spring.zookeeper")
public class ZookeeperConfig {

	private String connectString;
	private int sessionTimeout;

	public String getConnectString() {
		return connectString;
	}

	public void setConnectString(String connectString) {
		this.connectString = connectString;
	}

	public int getSessionTimeout() {
		return sessionTimeout;
	}

	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

}
