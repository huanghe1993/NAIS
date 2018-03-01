package com.anyikang.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.anyikang.components.jpush.PushExample;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.ServiceHelper;
import cn.jiguang.common.connection.NettyHttpClient;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jiguang.common.resp.ResponseWrapper;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.notification.IosAlert;
import io.netty.handler.codec.http.HttpMethod;

/**
 * 极光推送工具类
 * 
 * @author wangwei
 * @date 2017年7月21日
 */
public class JPushUtil {
	
	private static Logger logger = Logger.getLogger(JPushUtil.class);
	
	private static final String APP_KEY ="470c64f4eb2b1562f6e5d542";
	private static final String MASTER_SECRET = "b606676a3f912b67af66edc1";
	private static NettyHttpClient client=null;
	private static JPushClient jpushClient = null;
	private static URI uri=null;
	
	
	static {
		try {
			client=new NettyHttpClient(ServiceHelper.getBasicAuthorization(APP_KEY, MASTER_SECRET),null, ClientConfig.getInstance());
			jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
			uri = new URI((String) ClientConfig.getInstance().get(ClientConfig.PUSH_HOST_NAME) + ClientConfig.getInstance().get(ClientConfig.PUSH_PATH));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 推送通知
	 */
	public static void pushNotification(String[] alias,String msg) {
		PushPayload payload = PushExample.buildPushObject_all_alias_alert(alias,msg);
		client.sendRequest(HttpMethod.POST, payload.toString(), uri, new NettyHttpClient.BaseCallback() {
			@Override
			public void onSucceed(ResponseWrapper responseWrapper) {
				logger.info("Got result: " + responseWrapper.responseContent);
			}
		});
	}
	
	
	/**
	 * 推送通知
	 */
	public static void newPushNotification(String[] alias,Map<String,String> map,String alert) {
		PushPayload payload = PushExample.buildPushObject_android_and_ios(alias, alert, map);
		client.sendRequest(HttpMethod.POST, payload.toString(), uri, new NettyHttpClient.BaseCallback() {
			@Override
			public void onSucceed(ResponseWrapper responseWrapper) {
				logger.info("Got result: " + responseWrapper.responseContent);
			}
		});
	}
	
	
	
	
	
	/**
	 * 推送Android通知
	 */
	public static void pushAndroidNotification(String title,String alert,String[] alias) {
		try {
			PushResult result = jpushClient.sendAndroidNotificationWithAlias(title, alert, null, alias);
		} catch (APIConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	/**
	 * 推送IOS通知
	 */
	public static void pushIosNotification(String[] alias,String msg) {
		IosAlert alert = IosAlert.newBuilder().setTitleAndBody("test alert", "subtitle", msg).setActionLocKey("PLAY").build();
        try {
            PushResult result = jpushClient.sendIosNotificationWithAlias(alert, new HashMap<String, String>(), alias);
        } catch (APIConnectionException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        } catch (APIRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	/**
	 * 推送消息
	 */
    public static void pushMSG(String[] alias,String msg) {
        PushPayload payload = PushExample.buildPushObject_ios_audienceMore_messageWithExtras(alias,msg);
        client.sendRequest(HttpMethod.POST, payload.toString(), uri, new NettyHttpClient.BaseCallback() {
            @Override
            public void onSucceed(ResponseWrapper responseWrapper) {
            	logger.info("Got result: " + responseWrapper.responseContent);
            }
        });
    }
    
    
    

	public static void main(String[] args) {
		String[] alias={"13072925248"};
//		pushNotification(alias,"Test from API Example - alert");
		pushMSG(alias,"Test from API Example - msgContent");
//		pushAndroidNotification("来自xx的求助信息","地址西安电子科技大学",alias);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
