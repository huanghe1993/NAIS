package com.anyikang.utils;

import java.io.*;

/**
 * 对象序列化和反序列化
 * @author wangwei
 * @date 2017年6月29日
 */
public class SerializeUtils {
	public static byte[] serialize(Object o) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream outo = null;
		try {
			outo = new ObjectOutputStream(out);
			outo.writeObject(o);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				outo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return out.toByteArray();
	}

	public static Object deserialize(byte[] b) {
		ObjectInputStream oin = null;
		try {
			
			if(b == null){
				return null;
			}
			oin = new ObjectInputStream(new ByteArrayInputStream(b));
			try {
				return oin.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				if(oin!=null){
					oin.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}