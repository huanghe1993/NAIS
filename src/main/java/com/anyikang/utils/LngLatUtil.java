package com.anyikang.utils;

import java.math.BigDecimal;

/** 百度地图坐标和火星坐标转换 
 * Created by 明明如月 on 2017-03-22. 
 */  
public class LngLatUtil {  
  
  
    private static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;  
    public static final String BAIDU_LBS_TYPE = "bd09ll";
	public static double pi = 3.1415926535897932384626;
	public static double a = 6378245.0;
	public static double ee = 0.00669342162296594323;
	
	
	
	public static LngLat gps84_To_Gcj02(double lat, double lon) {
		  if (outOfChina(lat, lon)) {
		     return null;
		  }
		  double dLat = transformLat(lon - 105.0, lat - 35.0);
		  double dLon = transformLon(lon - 105.0, lat - 35.0);
		  double radLat = lat / 180.0 * pi;
		  double magic = Math.sin(radLat);
		  magic = 1 - ee * magic * magic;
		  double sqrtMagic = Math.sqrt(magic);
		  dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		  dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		  double mgLat = lat + dLat;
		  double mgLon = lon + dLon;
		  return new LngLat(mgLat, mgLon);
	}
	public static LngLat gcj_To_Gps84(double lat, double lon) {
		LngLat gps = transform(lat, lon);
		double lontitude = lon * 2 - gps.getLongitude();
		double latitude = lat * 2 - gps.getLantitude();
		return new LngLat(latitude, lontitude);
	
	}
	
	public static LngLat gcj02_To_Bd09(double gg_lat, double gg_lon) {
		double x = gg_lon, y = gg_lat;
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * pi);
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * pi);
		double bd_lon = z * Math.cos(theta) + 0.0065;
		double bd_lat = z * Math.sin(theta) + 0.006;
		return new LngLat(dataDigit(6,bd_lat), dataDigit(6,bd_lon));
	}
	
	public static LngLat bd09_To_Gcj02(double bd_lat, double bd_lon) {
		double x = bd_lon - 0.0065, y = bd_lat - 0.006;
		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * pi);
		double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * pi);
		double gg_lon = z * Math.cos(theta);
		double gg_lat = z * Math.sin(theta);
		return new LngLat(gg_lat, gg_lon);
	
	}
	
	public static LngLat bd09_To_Gps84(double bd_lat, double bd_lon) {
		LngLat gcj02 = bd09_To_Gcj02(bd_lat, bd_lon);
		LngLat map84 = gcj_To_Gps84(gcj02.getLantitude(),gcj02.getLongitude());
		return map84;
	}
	
    
	public static LngLat Gps84_To_bd09(double bd_lat, double bd_lon) {
		LngLat gcj02 = gps84_To_Gcj02(bd_lat, bd_lon);
		LngLat map84 = gcj02_To_Bd09(gcj02.getLantitude(), gcj02.getLongitude());
		return map84;
	}
	public static boolean outOfChina(double lat, double lon) {
		if (lon < 72.004 || lon > 137.8347)
		return true;
		if (lat < 0.8293 || lat > 55.8271)
		return true;
		return false;
	
	}
	
	public static LngLat transform(double lat, double lon) {
		if (outOfChina(lat, lon)) {
		   return new LngLat(lat, lon);
		}
		double dLat = transformLat(lon - 105.0, lat - 35.0);
		double dLon = transformLon(lon - 105.0, lat - 35.0);
		double radLat = lat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		double mgLat = lat + dLat;
		double mgLon = lon + dLon;
		return new LngLat(mgLat, mgLon);
	
	}
	
	public static double transformLat(double x, double y) {
		double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y+ 0.2 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
		ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
		return ret;
	
	}
	
	public static double transformLon(double x, double y) {
		double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1* Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;		
		ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;		
		ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0* pi)) * 2.0 / 3.0;
		return ret;
	
	}
    /** 
     * 对double类型数据保留小数点后多少位 
     *  高德地图转码返回的就是 小数点后6位，为了统一封装一下 
     * @param digit 位数 
     * @param in 输入 
     * @return 保留小数位后的数 
     */  
     static double dataDigit(int digit,double in){  
        return new   BigDecimal(in).setScale(6,   BigDecimal.ROUND_HALF_UP).doubleValue();  
  
    }  
  
    /** 
     * 将火星坐标转变成百度坐标 
     * @param lngLat_gd 火星坐标（高德、腾讯地图坐标等） 
     * @return 百度坐标 
     */  
      
 public static LngLat bd_encrypt(LngLat lngLat_gd)  
    {  
        double x = lngLat_gd.getLongitude(), y = lngLat_gd.getLantitude();  
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);  
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x *  x_pi);  
        return new LngLat(dataDigit(6,z * Math.cos(theta) + 0.0065),dataDigit(6,z * Math.sin(theta) + 0.006));  
  
    }  
    /** 
     * 将百度坐标转变成火星坐标 
     * @param lngLat_bd 百度坐标（百度地图坐标） 
     * @return 火星坐标(高德、腾讯地图等) 
     */  
    static LngLat bd_decrypt(LngLat lngLat_bd)  
    {  
        double x = lngLat_bd.getLongitude() - 0.0065, y = lngLat_bd.getLantitude() - 0.006;  
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);  
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);  
        return new LngLat( dataDigit(6,z * Math.cos(theta)),dataDigit(6,z * Math.sin(theta)));  
  
    }  
  
//测试代码  
    public static void main(String[] args) {  
        LngLat lngLat_bd = new LngLat(108.91303,34.231693);  
        System.out.println(Gps84_To_bd09(lngLat_bd.getLantitude(),lngLat_bd.getLongitude()));  
    }  
}  
