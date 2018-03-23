/**
 * 
 */
package com.anyikang.utils;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;






/**
 * @author wangwei
 * @date 2017年1月18日
 */
public class MapAPIUtil {
	
	private static Logger logger = LoggerFactory.getLogger(MapAPIUtil.class);
	
	private static final String AK = "gMtXC5ktlFpOFpRrrevVVKhjbeUloFcb";// 开发者秘钥
//	private static final String MCODE = "18:1A:E7:83:7C:36:CF:CA:83:A8:C5:F6:6F:CA:CB:5C:5A:65:5C:DF;com.anyikang.fallalarm";// 安全码
	private static final String MCODE = "87:5A:8B:D6:58:1A:E4:0A:46:AC:1F:8B:03:C5:FB:6B:2F:33:35:2A;com.anyikang.fallalarm";// 安全码
	private static final String SERVICE_ID = "142120";//鹰眼轨迹服务
	
	private static final String CREATECIRCLEFENCE_URL = "http://yingyan.baidu.com/api/v3/fence/createcirclefence";
	private static final String ADDPOINT_URL = "http://yingyan.baidu.com/api/v3/track/addpoint";
	private static final String UPDATECIRCLEFENCE_URL = "http://yingyan.baidu.com/api/v3/fence/updatecirclefence";
	private static final String DELETECIRCLEFENCE_URL = "http://yingyan.baidu.com/api/v3/fence/delete";
	private static final String FINDCIRCLEFENCE_URL = "http://yingyan.baidu.com/api/v3/fence/list";
	
	private static final String GEOCODER_URL = "http://api.map.baidu.com/geocoder/v2/";
	

	/**
	 * 添加实体
	 * 
	 * @param latitude
	 * @param longitude
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	public static int addEntity(String entity_name) throws Exception {
		String parame1 = "test11111";
		String URL = "http://api.map.baidu.com/trace/v2/entity/add";
		Map<String, String> params = new HashMap<>();
		params.put("ak", AK);
		params.put("mcode", MCODE);
		params.put("service_id", SERVICE_ID);
		params.put("entity_name", entity_name);
		params.put("name1", parame1);
		String json = HttpUtil.post(URL, params);
		JSONObject jo = new JSONObject(json);
		logger.info("---------addEntity:------------"+jo.getString("message")+"------------------");
		return jo.getInt("status");
	}
	
	/**
	 * 删除
	 */
	private static void deleteEntity() {
		String entity_name = "xxxx2";
		String URL = "http://api.map.baidu.com/trace/v2/entity/delete";
		Map<String, String> params = new HashMap<>();
		params.put("ak", AK);
		params.put("mcode", MCODE);
		params.put("service_id", SERVICE_ID);
		params.put("entity_name", entity_name);
		try {
			String json = HttpUtil.post(URL, params);
			JSONObject jo = new JSONObject(json);
			System.out.println(jo.toString());
			// int status=jo.getInt("status");
			// String message=jo.getString("message");
			// System.out.println("--------status:"+status+"---------------message:"+message+"--------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新
	 */
	private static void updateEntity() {
		String entity_name = "xxxx3";
		String parame1 = "test";
		String URL = "http://api.map.baidu.com/trace/v2/entity/update";
		Map<String, String> params = new HashMap<>();
		params.put("ak", AK);
		params.put("mcode", MCODE);
		params.put("service_id", SERVICE_ID);
		params.put("entity_name", entity_name);
		params.put("parame1", parame1);
		try {
			String json = HttpUtil.post(URL, params);
			JSONObject jo = new JSONObject(json);
			System.out.println(jo.toString());
			// int status=jo.getInt("status");
			// String message=jo.getString("message");
			// System.out.println("--------status:"+status+"---------------message:"+message+"--------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询
	 * @throws Exception 
	 */
	public static int getEntitys(String entityName) throws Exception {
		String parame1 = "test";
		String URL = "http://api.map.baidu.com/trace/v2/entity/list?";
		Map<String, String> params = new HashMap<>();
		params.put("entity_name", entityName);
		params.put("parame1", parame1);
		
		StringBuffer sb=new StringBuffer(URL);
		sb.append("ak="+AK).append("&");
		sb.append("mcode="+MCODE).append("&");
    	sb.append("service_id="+SERVICE_ID);
		
		String json = HttpUtil.get(sb.toString());
		JSONObject jo = new JSONObject(json);
		logger.info("---------getEntitys:------------"+jo.getString("message")+"------------------");
		return jo.getInt("status");
	}
	
	/**
	 * 添加自定义属性字段
	 */
	private static void addcolumn() {
		String column_key = "name1";
		String column_desc = "属性测试1";
		String is_search = "1";
		String URL = "http://api.map.baidu.com/trace/v2/entity/addcolumn";
		Map<String, String> params = new HashMap<>();
		params.put("ak", AK);
		params.put("mcode", MCODE);
		params.put("service_id", SERVICE_ID);
		params.put("column_key", column_key);
		params.put("column_desc", column_desc);
		params.put("is_search", is_search);
		try {
			String json = HttpUtil.post(URL, params);
			JSONObject jo = new JSONObject(json);
			System.out.println(jo.toString());
			// int status=jo.getInt("status");
			// String message=jo.getString("message");
			// System.out.println("--------status:"+status+"---------------message:"+message+"--------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除自定义属性字段
	 */
	private static void deletecolumn() {
		String column_key = "name1";
		String URL = "http://api.map.baidu.com/trace/v2/entity/deletecolumn";
		Map<String, String> params = new HashMap<>();
		params.put("ak", AK);
		params.put("mcode", MCODE);
		params.put("service_id", SERVICE_ID);
		params.put("column_key", column_key);
		try {
			String json = HttpUtil.post(URL, params);
			JSONObject jo = new JSONObject(json);
			System.out.println(jo.toString());
			// int status=jo.getInt("status");
			// String message=jo.getString("message");
			// System.out.println("--------status:"+status+"---------------message:"+message+"--------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    /**
     * 获取历史轨迹（24小时之内的）
     */
	public static void gethistory() {
		String entity_name = "xxxx6";
		String start_time = DateUtil.Date2TimeStamp("2017-01-18","yyyy-MM-dd");
		String end_time = DateUtil.Date2TimeStamp("2017-01-19","yyyy-MM-dd");
		String URL = "http://api.map.baidu.com/trace/v2/track/gethistory?";
		
		StringBuffer sb=new StringBuffer(URL);
		sb.append("ak="+AK).append("&");
		sb.append("mcode="+MCODE).append("&");
		sb.append("service_id="+SERVICE_ID).append("&");
//		sb.append("start_time="+start_time).append("&");
		sb.append("start_time=1473091200").append("&");
//		sb.append("end_time="+end_time).append("&");
		sb.append("end_time=1473091225").append("&");
		sb.append("entity_name="+entity_name);
		
		try {
			String json = HttpUtil.get(sb.toString());
			JSONObject jo = new JSONObject(json);
			System.out.println(jo.toString());
			// int status=jo.getInt("status");
			// String message=jo.getString("message");
			// System.out.println("--------status:"+status+"---------------message:"+message+"--------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 单个上传轨迹点
	 * @param entityName
	 * @param latitude
	 * @param longitude
	 * @param locTime
	 * @param coordTypeInput
	 * @return
	 * @throws Exception
	 */
	public static int addpoint(String entityName,double latitude,double longitude,String locTime,String coordTypeInput) {
//		String URL = "http://yingyan.baidu.com/api/v3/track/addpoint";
		Map<String, String> params = new HashMap<>();
		params.put("ak", AK);
		params.put("service_id", SERVICE_ID);
		params.put("mcode", MCODE);
		params.put("entity_name", entityName);
		params.put("latitude", Double.toString(latitude));
		params.put("longitude", Double.toString(longitude));
		params.put("loc_time", locTime);
		params.put("coord_type_input", coordTypeInput);
		
		int status=-1;
		try{
			String json = HttpUtil.post(ADDPOINT_URL, params);
			JSONObject jo = new JSONObject(json);
			status=jo.getInt("status");
			logger.info("---------addpoints:------------"+jo.toString()+"------------------");
		}catch(Exception e){
			System.out.println("百度地图服务器异常！！！");
		}
		return status;
	}
	
	/**
	 * 创建圆形围栏
	 * @param fenceName
	 * @param monitoredPerson
	 * @param longitude
	 * @param latitude
	 * @param radius
	 * @param coordType
	 * @param denoise
	 * @return
	 */
	public static int createCircleFence(String fenceName,String monitoredPerson,double longitude,double latitude,double radius,String coordType,int denoise) {
//		String URL = "http://yingyan.baidu.com/api/v3/fence/createcirclefence";
		Map<String, String> params = new HashMap<>();
		params.put("ak", AK);
		params.put("service_id", SERVICE_ID);
		params.put("mcode", MCODE);
		params.put("fence_name", fenceName);
		params.put("monitored_person", monitoredPerson);
		params.put("longitude", Double.toString(longitude));
		params.put("latitude", Double.toString(latitude));
		params.put("radius", Double.toString(radius));
		params.put("coord_type", coordType);
		if(denoise>0){
			params.put("denoise", String.valueOf(denoise));
		}
		
		int status=-1;
		try{
			String json = HttpUtil.post(CREATECIRCLEFENCE_URL, params);
			JSONObject jo = new JSONObject(json);
			status=jo.getInt("status");
			logger.info("---------createcirclefence:------------"+jo.toString()+"------------------");
		}catch(Exception e){
			System.out.println("百度地图服务器异常！！！");
		}
		return status;
	}
	
	/**
	 * 更新圆形围栏
	 * @param fenceId
	 * @param fenceName
	 * @param monitoredPerson
	 * @param longitude
	 * @param latitude
	 * @param radius
	 * @param coordType
	 * @param denoise
	 * @return
	 */
	public static int updateCircleFence(String fenceId,String fenceName,String monitoredPerson,double longitude,double latitude,double radius,String coordType,int denoise) {
//		String URL = "http://yingyan.baidu.com/api/v3/fence/updatecirclefence";
		Map<String, String> params = new HashMap<>();
		params.put("ak", AK);
		params.put("service_id", SERVICE_ID);
		params.put("mcode", MCODE);
		params.put("fence_id", fenceId);
		if(null!=fenceName&&!"".equals(fenceName)){
			params.put("fence_name", fenceName);
		}
		params.put("monitored_person", monitoredPerson);
		if(longitude>0){
			params.put("longitude", Double.toString(longitude));
		}
		if(latitude>0){
			params.put("latitude", Double.toString(latitude));
		}
		if(radius>0){
			params.put("radius", Double.toString(radius));
		}
		params.put("coord_type", coordType);
		if(denoise>0){
			params.put("denoise", String.valueOf(denoise));
		}
		
		int status=-1;
		try{
			String json = HttpUtil.post(UPDATECIRCLEFENCE_URL, params);
			JSONObject jo = new JSONObject(json);
			status=jo.getInt("status");
			logger.info("---------updateCircleFence:------------"+jo.toString()+"------------------");
		}catch(Exception e){
			System.out.println("百度地图服务器异常！！！");
		}
		return status;
	}
	
	/**
	 * 删除围栏
	 * @param fenceIds
	 * @param fenceName
	 * @param monitoredPerson
	 * @return
	 */
	public static int deleteCircleFence(int[] fenceIds,String monitoredPerson) {
//		String URL = "http://yingyan.baidu.com/api/v3/fence/delete";
		Map<String, String> params = new HashMap<>();
		params.put("ak", AK);
		params.put("service_id", SERVICE_ID);
		params.put("mcode", MCODE);
		params.put("monitored_person", monitoredPerson);
		
		if(fenceIds!=null&&fenceIds.length>0){
			StringBuffer sb=new StringBuffer();
			for(int fenceid:fenceIds){
				sb.append(fenceid);
				sb.append(",");
			}
			params.put("fence_ids", sb.toString().substring(0, sb.length()-1));
		}
		
		int status=-1;
		try{
			String json = HttpUtil.post(DELETECIRCLEFENCE_URL, params);
			JSONObject jo = new JSONObject(json);
			status=jo.getInt("status");
			logger.info("---------deleteCircleFence:------------"+jo.toString()+"------------------");
		}catch(Exception e){
			System.out.println("百度地图服务器异常！！！");
		}
		return status;
	}
	
	/**
	 * 查询围栏
	 * @param fenceIds
	 * @param fenceName
	 * @param monitoredPerson
	 * @param coordTypeOutput
	 * @return
	 */
	public static int findCircleFence(int[] fenceIds,String monitoredPerson,String coordTypeOutput) {
//		String URL = "http://yingyan.baidu.com/api/v3/fence/list";
		StringBuffer params=new StringBuffer("?");
		params.append("ak=").append(AK).append("&");
		params.append("service_id=").append(SERVICE_ID).append("&");
		params.append("mcode=").append(MCODE).append("&");
		params.append("monitored_person=").append(monitoredPerson);
		
		if(fenceIds!=null&&fenceIds.length>0){
			StringBuffer sb=new StringBuffer();
			for(int fenceid:fenceIds){
				sb.append(fenceid);
				sb.append(",");
			}
			params.append("&fence_ids=").append(sb.toString().substring(0, sb.length()-1));
		}
		if(null!=coordTypeOutput&&!"".equals(coordTypeOutput)){
			params.append("&coord_type_output=").append(coordTypeOutput);
		}
		
		int status=-1;
		try{
			String json = HttpUtil.get(FINDCIRCLEFENCE_URL+params.toString());
			JSONObject jo = new JSONObject(json);
			status=jo.getInt("status");
			logger.info("---------findCircleFence:------------"+jo.toString()+"------------------");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("百度地图服务器异常！！！");
		}
		return status;
	}
	
	/**
	 * 根据经纬度坐标查询对应的地理地址信息
	 * @param lat
	 * @param lng
	 * @return formatted_address:地址；district：所在区
	 */
	public static Map<String,String> toAddr(double lat,double lng){
		StringBuffer sb=new StringBuffer(GEOCODER_URL);
		sb.append("?ak=").append(AK);
		sb.append("&mcode=").append(MCODE);
		sb.append("&coordtype=").append("bd09ll");//bd09ll（百度经纬度坐标）、bd09mc（百度米制坐标）、gcj02ll（国测局经纬度坐标）、wgs84ll（ GPS经纬度）
		sb.append("&location=").append(lat).append(",").append(lng);
		sb.append("&output=").append("json");
		
		Map<String,String> map=new HashMap<>();
		try{
			String json = HttpUtil.get(sb.toString());
			JSONObject jo = new JSONObject(json);
			System.out.println(jo.toString());
			if(jo.getInt("status") == 0){
				JSONObject result=jo.getJSONObject("result");
				String formatted_address=result.getString("formatted_address");
				JSONObject addressComponent=result.getJSONObject("addressComponent");
				String district=addressComponent.getString("district");
				String city = addressComponent.getString("city");
				String adcode = addressComponent.getString("adcode");
				map.put("formatted_address", formatted_address);
				map.put("district", district);
				map.put("city", city);
				map.put("adcode", adcode);
			}else{
				logger.info(jo.toString());
			}
		}catch(Exception e){
			System.out.println("百度地图服务器异常！！！");
		}
	
		return map;
	}
	
	public static void main(String[] args) {
		try {
			//单个上传轨迹点测试
//			String dddss=DateUtil.Date2TimeStamp(DateUtil.getCurrentTimeByString(),"yyyy-MM-dd HH:mm:ss");
//			int ddd=addpoint("222888999",34.2369265986,109.0007179000,dddss,"bd09ll");
			
			//创建圆形围栏测试
//			int ccc=createCircleFence("测试围栏", "222", 108.923893, 34.231162, 1000, "bd09ll", 5);
			
			//更新圆形围栏测试
//			int ccc=updateCircleFence("2","测试围栏", "222888", 108.923893, 34.231162, 1000, "bd09ll", 5);
			
			//删除围栏
//			int[] fenceIds={2};
//			deleteCircleFence(fenceIds, "222888");
			
			//查询围栏
			findCircleFence(null, "4700572735", null);
			
//			String addr=toAddr(34.235217f,108.924253f);
//			Map<String,String> map=toAddr(22.570512f,113.8623267f);
//			for(Map.Entry<String, String> param:map.entrySet()){
//				System.err.println(param.getKey()+":"+param.getValue());
//			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
