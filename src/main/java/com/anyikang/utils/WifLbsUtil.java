/**
 * 
 */
package com.anyikang.utils;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.shiro.util.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * wifi lbs数据转换工具
 * @author wangwei
 * @date 2017年7月24日
 */
public class WifLbsUtil {
	
	private static Logger logger = Logger.getLogger(WifLbsUtil.class);
	
	private static String LBS_URL="http://api.cellocation.com/cell/";
	private static String WIFI_URL="http://api.cellocation.com/wifi/";
	private static String MIXTURE_URL="http://api.cellocation.com/loc/jy14amht.php";
	
	/**
	 * LBS转换
	 * @return
	 */
	public static float[] lbs(){
		logger.debug("========lbs========");
		int mnc=1;//网络类型：0移动，1联通
		int lac=4301;
		int ci=20986;
		StringBuffer sb=new StringBuffer(LBS_URL);
		sb.append("?mcc=").append(460);
		sb.append("&mnc=").append(mnc);
		sb.append("&lac=").append(lac);
		sb.append("&ci=").append(ci);
		sb.append("&output=").append("json");
		sb.append("&coord=").append("wgs84");
		
		float gps[]=new float[2];
		try {
			String json = HttpUtil.get(sb.toString());
			Map<String, Object> maps = new ObjectMapper().readValue(json, Map.class);
			logger.info("---------errcode:"+maps.get("errcode")+"----------lat:"+maps.get("lat")+"-----------lon:"+maps.get("lon"));
			if((int)maps.get("errcode") != 0){
				gps[0]=0;
				gps[1]=0;
				logger.info(json.toString());
			}else {
//            gps[0]=Float.parseFloat((String)maps.get("lat"));
//            gps[1]=Float.parseFloat((String)maps.get("lon"));
				
				float[] newGPS=getSkewingCorrect((String)maps.get("lat"),(String)maps.get("lon"));
				gps[0]=newGPS[1];
				gps[1]=newGPS[0];
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return gps;
	}
	
	
	
	/**
	 * LBS转换
	 * @return
	 */
	public static float[] onceLbs(String onceLbs){
		logger.debug("========lbs========");
		
		StringBuffer sb=new StringBuffer(LBS_URL);
		sb.append(onceLbs);
		sb.append("&output=").append("json");
		sb.append("&coord=").append("wgs84");
		
		float gps[]=new float[2];
		try {
			String json = HttpUtil.get(sb.toString());
			Map<String, Object> maps = new ObjectMapper().readValue(json, Map.class);
			logger.info("---------errcode:"+maps.get("errcode")+"----------lat:"+maps.get("lat")+"-----------lon:"+maps.get("lon"));
			if((int)maps.get("errcode") != 0){
				gps[0]=0;
				gps[1]=0;
				logger.info(json.toString());
			}else {
            gps[0]=Float.parseFloat((String)maps.get("lat"));
            gps[1]=Float.parseFloat((String)maps.get("lon"));
				
	/*			float[] newGPS=getSkewingCorrect((String)maps.get("lat"),(String)maps.get("lon"));
				gps[0]=newGPS[1];
				gps[1]=newGPS[0];*/
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return gps;
	}
	
	
	
	/**
	 * WIFI转换
	 * @return
	 */
	public static float[] onceWifi(String onceWifi){
		logger.debug("========wifi========");
		StringBuffer sb=new StringBuffer(WIFI_URL);
		sb.append(onceWifi);
		sb.append("&coord=").append("wgs84");
		sb.append("&output=").append("json");
		
		float gps[]=new float[2];
		try {
			String json = HttpUtil.get(sb.toString());
			Map<String, Object> maps = new ObjectMapper().readValue(json, Map.class);
			logger.info("---------errcode:"+maps.get("errcode")+"----------lat:"+maps.get("lat")+"-----------lon:"+maps.get("lon"));
			if((int)maps.get("errcode") != 0){
				gps[0]=0;
				gps[1]=0;
				logger.info(json.toString());
			}else {
            gps[0]=Float.parseFloat((String)maps.get("lat"));
            gps[1]=Float.parseFloat((String)maps.get("lon"));
				
				/*float[] newGPS=getSkewingCorrect((String)maps.get("lat"),(String)maps.get("lon"));
				gps[0]=newGPS[1];
				gps[1]=newGPS[0];*/
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gps;
	}
	
	

	
	/**
	 * WIFI转换
	 * @return
	 */
	public static float[] wifi(String mac){
		logger.debug("========wifi========");
		StringBuffer sb=new StringBuffer(WIFI_URL);
		sb.append("?mac=").append(mac);
		sb.append("&coord=").append("wgs84");
		sb.append("&output=").append("json");
		
		float gps[]=new float[2];
		try {
			String json = HttpUtil.get(sb.toString());
			Map<String, Object> maps = new ObjectMapper().readValue(json, Map.class);
			logger.info("---------errcode:"+maps.get("errcode")+"----------lat:"+maps.get("lat")+"-----------lon:"+maps.get("lon"));
			if((int)maps.get("errcode") != 0){
				gps[0]=0;
				gps[1]=0;
				logger.info(json.toString());
			}else {
//            gps[0]=Float.parseFloat((String)maps.get("lat"));
//            gps[1]=Float.parseFloat((String)maps.get("lon"));
				
				float[] newGPS=getSkewingCorrect((String)maps.get("lat"),(String)maps.get("lon"));
				gps[0]=newGPS[1];
				gps[1]=newGPS[0];
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gps;
	}
	
	/**
	 * 基于临近基站和WIFI热点的高精度混合基站定位
	 * @param cl 临近基站列表{MCC,MNC,LAC,CI,信号强度}，例如 {"460,0,4173,33452,-15","460,0,4173,63939,-22"}
	 * @param wl 临近WIFI热点列表{MAC地址,信号强度}，例如 {"00:87:36:05:5d:eb,-23","00:19:e0:e7:5e:b4,-13"}
	 * @return
	 */
	public static float[] mixture(String[] cl,String[] wl){
		logger.debug("========mixture========");
		StringBuffer sb=new StringBuffer(MIXTURE_URL);
		sb.append("?cl=").append(StringUtils.toDelimitedString(cl, ";"));//临近基站列表
		sb.append("&wl=").append(StringUtils.toDelimitedString(wl, ";"));//临近WIFI热点列表
		sb.append("&output=").append("json");
		
		float gps[]=new float[2];
		try {
			String json = HttpUtil.get(sb.toString());
			Map<String, Object> maps = new ObjectMapper().readValue(json, Map.class);
			logger.info("---------errcode:"+maps.get("errcode")+"----------lat:"+maps.get("lat")+"-----------lon:"+maps.get("lon"));
			if((int)maps.get("errcode") != 0){
				gps[0]=0;
				gps[1]=0;
				logger.info(json.toString());
			}else {
//            gps[0]=Float.parseFloat((String)maps.get("lat"));
//            gps[1]=Float.parseFloat((String)maps.get("lon"));
				
				float[] newGPS=getSkewingCorrect((String)maps.get("lat"),(String)maps.get("lon"));
				gps[0]=newGPS[1];
				gps[1]=newGPS[0];
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gps;
	}
	
	/**
     * 经纬度偏移量矫正（目前只针对百度地图）
     * @param latitude 纬度
     * @param longitude 经度
     * @return 矫正后的经纬度(依次返回精度和纬度)
     */
    private static float[] getSkewingCorrect(String latitude,String longitude) {
    	float[] newGPS=new float[2];

    	int from=1;//原坐标类型（1：GPS设备获取的角度坐标）
    	int to=5;//目的坐标类型（5：bd09ll(百度经纬度坐标)）
    	String ak="eBC8yFfOqGcvBL0bXd5GU9kMzNAWU64w";//开发者秘钥
    	String mcode="CE:3E:81:41:70:B3:41:45:CB:5B:50:DF:6D:C1:7F:BD:64:4C:6A:0A;com.qianniu.tripcare";//安全码
    	String output="json";//返回结果格式

    	StringBuffer sb=new StringBuffer("http://api.map.baidu.com/geoconv/v1/");
    	sb.append("?coords=").append(longitude).append(",").append(latitude);
    	sb.append("&from="+from);
    	sb.append("&to="+to);
    	sb.append("&ak="+ak);
    	sb.append("&mcode="+mcode);
    	sb.append("&output="+output);

    	try{
    		String json=HttpUtil.get(sb.toString());
    		JSONObject jo=new JSONObject(json);
    		int status=jo.getInt("status");
    		JSONArray ja=jo.getJSONArray("result");
    		JSONObject obj=ja.getJSONObject(0);

    		if(status!=0){
    			newGPS[0]=0;
        		newGPS[1]=0;
        		logger.info(json.toString());
    		}else{
    			newGPS[0]=Float.parseFloat(String.valueOf(obj.get("x")));
    			newGPS[1]=Float.parseFloat(String.valueOf(obj.get("y")));
    		}
    	}catch(Exception e){
    		newGPS[0]=0;
    		newGPS[1]=0;
    	}

    	logger.info("转换前>>>>>(--------经度："+longitude+",纬度："+latitude+"--------)");
    	logger.info("转换后<<<<<(--------经度："+newGPS[0]+",纬度："+newGPS[1]+"--------)");

    	return newGPS;
    }
	
	public static void main(String[] args) {
//		lbs();
//		wifi("24:de:c6:76:4c:10");
//		String[] cl={"460,0,4173,33452,-15","460,0,4173,63939,-22"};
//		String wl="?mac=84:d9:31:4c:90:f0";
//		onceWifi(wl);
		String lb="?mcc=460&mnc=1&lac=8410&ci=12106";
		onceLbs(lb);
	}

}
