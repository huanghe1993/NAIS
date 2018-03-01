/**
 * 
 */
package com.anyikang.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wangwei
 * @date 2017年4月20日
 */
public class IEEE754Utils {

	public static String floatToIEEE754(float value) {  
        //符号位  
        String sflag = value > 0 ? "0" : "1";  
          
        //整数部分  
        int fz = (int) Math.floor(value);  
        //整数部分二进制  
        String fzb = Integer.toBinaryString(fz);  
        //小数部分，格式： 0.02  
        String valueStr = String.valueOf(value);  
        String fxStr = "0" + valueStr.substring(valueStr.indexOf("."));  
        float fx = Float.parseFloat(fxStr);  
        //小数部分二进制  
        String fxb = toBin(fx);  
          
        //指数位  
        String e = Integer.toBinaryString(127 + fzb.length() - 1);  
        //尾数位  
        String m = fzb.substring(1) + fxb;  
  
        String result = sflag + e + m;  
  
        while (result.length() < 32) {  
            result += "0";  
        }  
        if (result.length() > 32) {  
            result = result.substring(0, 32);  
        }
        
        //result 是个二进制结果，需要再次转换
//        return result;  
        
        return Long.toHexString(Long.parseLong(result,2)).toUpperCase();
    }  
	
	private static String toBin(float f) {  
        List<Integer> list = new ArrayList<Integer>();  
        Set<Float> set = new HashSet<Float>();  
        int MAX = 24; // 最多8位  
  
        int bits = 0;  
        while (true) {  
            f = calc(f, set, list);  
            bits++;  
            if (f == -1 || bits >= MAX)  
                break;  
        }  
        String result = "";  
        for (Integer i : list) {  
            result += i;  
        }  
        return result;  
    }  
	
	private static float calc(float f, Set<Float> set, List<Integer> list) {  
        if (f == 0 || set.contains(f))  
            return -1;  
        float t = f * 2;  
        if (t >= 1) {  
            list.add(1);  
            return t - 1;  
        } else {  
            list.add(0);  
            return t;  
        }  
    }  
	
	public static float stringTofloat(float f){
	/*	String result = String .format("%.6f",f);
		float height =Float.valueOf(result);
	    System.err.println(height);
		return height;*/
		DecimalFormat decimalFormat=new DecimalFormat(".000000");//构造方法的字符格式这里如果小数不足2位,会以0补足.
		String p=decimalFormat.format(f);//format 返回的是字符串
		return Float.valueOf(p);
	}
}
