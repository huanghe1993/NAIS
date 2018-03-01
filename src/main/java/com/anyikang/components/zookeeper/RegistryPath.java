/**
 * 
 */
package com.anyikang.components.zookeeper;

/**
 * @author wangwei
 * @date 2017年4月6日
 */
public enum RegistryPath {

//	ZK_REPORT("/report", "/provider"), 
//	ZK_SEND_CONFIGURATION("/send_configuration", "/provider"), 
//	ZK_MESSAGE_QUERY("/message_query", "/provider");
	ZK_DEVICE("/device", "/provider");

	private String rootPath;
	private String childPath;

	/**
	 * @param rootPath
	 * @param childPath
	 */
	private RegistryPath(String rootPath, String childPath) {
		this.rootPath = rootPath;
		this.childPath = childPath;
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public String getChildPath() {
		return childPath;
	}

	public void setChildPath(String childPath) {
		this.childPath = childPath;
	}
	
	

}
