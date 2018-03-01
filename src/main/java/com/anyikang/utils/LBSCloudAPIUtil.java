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
public class LBSCloudAPIUtil {
	
	private static Logger logger = LoggerFactory.getLogger(LBSCloudAPIUtil.class);
	
	private static final String AK = "nsOyvRLrIMthoLm9M4OUK0nv8aNObxTv";// 开发者秘钥
	
	private static final String DELETE_URL = "http://api.map.baidu.com/geodata/v3/poi/delete";
	private static final String CREATE_URL = "http://api.map.baidu.com/geodata/v3/poi/create";
	

	
	/**
	 * 删除数据（poi）接口
	 * @return
	 */
	public static String delete(){
		Map<String,String> map=new HashMap<>();
		map.put("ak", AK);
		map.put("geotable_id", "172905");
		map.put("is_total_del", "1");
		
		try{
			return HttpUtil.post(DELETE_URL, map);
		}catch(Exception e){
			System.out.println("百度地图LBS云服务器异常！！！");
		}
		return null;
	}
	
	/**
	 * 创建数据（create poi）接口
	 * @param lat
	 * @param lng
	 * @param coord_type
	 * @param tags
	 * @return
	 */
	public static String create(float lat,float lng,int coord_type,String tags){
		Map<String,String> map=new HashMap<>();
		map.put("ak", AK);
		map.put("geotable_id", "172905");
		map.put("coord_type", Integer.toString(coord_type));
		map.put("longitude", Float.toString(lng));
		map.put("latitude", Float.toString(lat));
		map.put("tags", tags);
		
		try{
			return HttpUtil.post(CREATE_URL, map);
		}catch(Exception e){
			System.out.println("百度地图LBS云服务器异常！！！");
		}
		return null;
	}
	
	public static void main(String[] args) {
//			System.out.println(delete());
			System.out.println(create(34.135939f,108.214295f,3,"13898966666"));
			
	}
	
}
