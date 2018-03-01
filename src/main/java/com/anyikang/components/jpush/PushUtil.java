package com.anyikang.components.jpush;

import java.util.HashSet;

import org.json.JSONObject;

import cn.jiguang.common.resp.DefaultResult;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;

import com.google.gson.Gson;

/**
 * Created by GalaIO on 2016/11/23.
 */
public class PushUtil {
	private String masterSecret="afd8625406fd790a22269a7b";
	private String appKey="507ac618e4f7a976551cf1e0";

    private static final PushUtil instance = new PushUtil();

    private JPushClient jpushClient = null;
    private PushUtil(){
        jpushClient = new JPushClient(masterSecret, appKey);
    }

//    public long addUSerTag(String registrationId, HashSet<String> tagSet, String alias) throws Exception{
//        DefaultResult result = null;
//        try {
//            result = jpushClient.updateDeviceTagAlias(registrationId, alias, tagSet, null);
//        }catch (Exception e) {
//            JSONObject jsonObject = new JSONObject(e.getMessage());
//            throw new Exception(jsonObject.getJSONObject("error").getString("message"));
//        }
//        return result.getResponseCode();
//    }

    public long addUSerTag(String registrationId, HashSet<String> tagSet) throws Exception{
        DefaultResult result = null;
        try {
            result = jpushClient.updateDeviceTagAlias(registrationId, null, tagSet, null);
        }catch (Exception e) {
            JSONObject jsonObject = new JSONObject(e.getMessage());
            throw new Exception(jsonObject.getJSONObject("error").getString("message"));
        }
        return result.getResponseCode();
    }

//    public long setUSerTag(String registrationId, HashSet<String> tagSet, String alias) throws Exception{
//        DefaultResult result = null;
//        try {
//            jpushClient.updateDeviceTagAlias(registrationId, true, true);
//            result = jpushClient.updateDeviceTagAlias(registrationId, alias, tagSet, null);
//        }catch (Exception e) {
//            JSONObject jsonObject = new JSONObject(e.getMessage());
//            throw new Exception(jsonObject.getJSONObject("error").getString("message"));
//        }
//        return result.getResponseCode();
//    }

//    public long setUSerTag(String registrationId, HashSet<String> tagSet) throws Exception{
//        DefaultResult result = null;
//        try {
//            jpushClient.updateDeviceTagAlias(registrationId, false, true);
//            result = jpushClient.updateDeviceTagAlias(registrationId, null, tagSet, null);
//        }catch (Exception e) {
//            JSONObject jsonObject = new JSONObject(e.getMessage());
//            throw new Exception(jsonObject.getJSONObject("error").getString("message"));
//        }
//        return result.getResponseCode();
//    }

//    public long sendNormalMSG(String tag, Object messageObj) throws Exception{
//        PushResult result = null;
//        PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.all())
//                .setAudience(Audience.tag(tag))
//                .setMessage(Message.newBuilder().setMsgContent(new Gson().toJson(messageObj)).build())
//                .setOptions(Options.newBuilder().setApnsProduction(true).build())
//                .build();
//        try {
//            result = jpushClient.sendPush(payload);
//        }catch (Exception e) {
//            JSONObject jsonObject = new JSONObject(e.getMessage());
//            throw new Exception(jsonObject.getJSONObject("error").getString("message"));
//        }
//        return result.getResponseCode();
//    }
    
//    public long sendNormalMSG(Set<String> tagList, Object messageObj) throws Exception{
//        PushResult result = null;
//        PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.all())
//                .setAudience(Audience.tag(tagList))
//                .setMessage(Message.newBuilder().setMsgContent(new Gson().toJson(messageObj)).build())
//                .setOptions(Options.newBuilder().setApnsProduction(true).build())
//                .build();
//        try {
//            result = jpushClient.sendPush(payload);
//        }catch (Exception e) {
//            JSONObject jsonObject = new JSONObject(e.getMessage());
//            throw new Exception(jsonObject.getJSONObject("error").getString("message"));
//        }
//        return result.getResponseCode();
//    }
    
    public long sendNormalMSG2ALL(Object messageObj) throws Exception{
        PushResult result = null;
        PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setMessage(Message.newBuilder().setMsgContent(new Gson().toJson(messageObj)).build())
                .setOptions(Options.newBuilder().setApnsProduction(true).build())
                .build();
        try {
            result = jpushClient.sendPush(payload);
        }catch (Exception e) {
            JSONObject jsonObject = new JSONObject(e.getMessage());
            throw new Exception(jsonObject.getJSONObject("error").getString("message"));
        }
        return result.getResponseCode();
    }

    public static PushUtil getInstance() {
        return instance;
    }
    
    
   public static void main(String[] args) {
	 //绑定TAG
//	   HashSet<String> tagSet = new HashSet<String>();
//       for(APPHomeRelation appHomeRelation : appHomeRelations){
//           tagSet.add("Home_" + appHomeRelation.getHome().getId());
//       }
//       tagSet.add("User_" + appUser.getId());
//       try {
//           PushUtil.getInstance().addUSerTag(userRegister.clientID, tagSet);
//       }catch (Exception ex){
//           //绑定出错
//           return new RestRespone(ex.getMessage(), null);
//       }
	   
	   
	   
	   //报警 推送
//       logger.info("设备:" +  device1.getDeviceNumber() + ">电子围栏:" + "报警推送！");
//       PushUtil.getInstance().sendNormalMSG2ALL(TripInfo.buildAlarmInfo(TripInfo.NotifyType_fence, device1.getDeviceNumber(), la.getLongitude(), la.getLatitude(), null));
	   
}
    
    
}
