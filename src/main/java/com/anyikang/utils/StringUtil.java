package com.anyikang.utils;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 字符串判断
 * 
 * @author tz
 *
 */
public class StringUtil {

	public static String INTERNET_IP = getInternetIp(); // 外网IP

	/**
	 * 判断是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0 ? true : false;
	}

	/**
	 * 判断是否不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * 生成随机数
	 * 
	 * @param num
	 *            生成位数以固定8位
	 * @return
	 */
	public static String getRandomNum(int num) {
		int maxNum = 36;
		int i;
		int count = 0;
		char[] str = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < num) {
			i = Math.abs(r.nextInt(maxNum));
			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}

	/**
	 * 获取当前内网ip地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 获取外网IP地址
	 * 
	 * @return
	 */
	public static String getInternetIp() {
		try {
			Enumeration<NetworkInterface> networks = NetworkInterface
					.getNetworkInterfaces();
			InetAddress ip = null;
			Enumeration<InetAddress> addrs;
			while (networks.hasMoreElements()) {
				addrs = networks.nextElement().getInetAddresses();
				while (addrs.hasMoreElements()) {
					ip = addrs.nextElement();
					if (ip != null && ip instanceof Inet4Address
							&& ip.isSiteLocalAddress()
							&& !ip.getHostAddress().equals(INTERNET_IP)) {
						return ip.getHostAddress();
					}
				}
			}
			// 如果没有外网IP，就返回内网IP
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return INTERNET_IP;
	}
	
	
	/**
	 * 获取外网IP地址
	 * 
	 * @return
	 */
	public static String GetIpByUrl() {
			// 实例化httpclient
			CloseableHttpClient httpclient = HttpClients.createDefault();
			// 实例化get方法
			HttpGet httpget = new HttpGet("https://api.ip.sb/ip");		
			//DefaultHttpClient client = new DefaultHttpClient(new PoolingClientConnectionManager());
		
			// 请求结果
			CloseableHttpResponse response = null;
			String content = "";
			try {
				// 执行get方法
				response = httpclient.execute(httpget);
				if (response.getStatusLine().getStatusCode() == 200) {
					content = EntityUtils.toString(response.getEntity(), "utf-8");
					System.out.println(content);
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return content;
		
	}
	
	
}
