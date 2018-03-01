package com.anyikang.utils;

import io.netty.buffer.ByteBuf;

public class BCDUtils {

	public static byte[] DecimalToBCD(long num) {
		int digits = 0;
		long temp = num;
		while (temp != 0) {
			digits++;
			temp /= 10;
		}

		int byteLen = digits % 2 == 0 ? digits / 2 : (digits + 1) / 2;
		byte bcd[] = new byte[byteLen];
		for (int i = 0; i < digits; i++) {
			byte tmp = (byte) (num % 10);
			if (i % 2 == 0) {
				bcd[i / 2] = tmp;
			} else {
				bcd[i / 2] |= (byte) (tmp << 4);
			}
			num /= 10;
		}

		for (int i = 0; i < byteLen / 2; i++) {
			byte tmp = bcd[i];
			bcd[i] = bcd[byteLen - i - 1];
			bcd[byteLen - i - 1] = tmp;
		}
		return bcd;
	}

	/**
	 * bcd码转换成十进制字符串
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bcd2Str(byte[] bytes) {
		StringBuffer temp = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
			temp.append((byte) (bytes[i] & 0x0f));
		}
		return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp
				.toString().substring(1) : temp.toString();
	}

	/**
	 * 十进制转换成bcd码
	 * 
	 * @param asc
	 * @return
	 */
	public static byte[] str2Bcd(String asc) {
		int len = asc.length();
		int mod = len % 2;
		if (mod != 0) {
			asc = "0" + asc;
			len = asc.length();
		}
		byte abt[] = new byte[len];
		if (len >= 2) {
			len = len / 2;
		}
		byte bbt[] = new byte[len];
		abt = asc.getBytes();
		int j, k;
		for (int p = 0; p < asc.length() / 2; p++) {
			if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
				j = abt[2 * p] - '0';
			} else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
				j = abt[2 * p] - 'a' + 0x0a;
			} else {
				j = abt[2 * p] - 'A' + 0x0a;
			}
			if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
				k = abt[2 * p + 1] - '0';
			} else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
				k = abt[2 * p + 1] - 'a' + 0x0a;
			} else {
				k = abt[2 * p + 1] - 'A' + 0x0a;
			}
			int a = (j << 4) + k;
			byte b = (byte) a;
			bbt[p] = b;
		}
		return bbt;
	}

	/**
     * bytes转换成十六进制字符串
     *
     * @param b byte数组
     * @return String 每个Byte值之间空格分隔
     */
    public static String byteToHexString(byte[] b) {
        String stmp = "";
        StringBuilder sb = new StringBuilder("");
        for (byte c : b) {
            stmp = Integer.toHexString(c & 0xFF);// 与预算，去掉byte转int带来的补位
            sb.append((stmp.length() == 1) ? "0" + stmp : stmp);// 是一位的话填充零
            sb.append(" ");// 每位数据用空格分隔
        }
        return sb.toString().toUpperCase().trim();// 变换大写，并去除首尾空格
    }
    
    /**
     * 转码
     * @param bs
     * @param in
     * @return
     */
    public static String byteToHexString(byte[] bs,ByteBuf in) {
    	in.readBytes(bs);
    	
    	String stmp = "";
        StringBuilder sb = new StringBuilder("");
        for (byte c : bs) {
            stmp = Integer.toHexString(c & 0xFF);// 与预算，去掉byte转int带来的补位
            sb.append((stmp.length() == 1) ? "0" + stmp : stmp);// 是一位的话填充零
//            sb.append(" ");// 每位数据用空格分隔
        }
        return sb.toString().toUpperCase().trim();// 变换大写，并去除首尾空格
    }
    
    /**
     * byte转换成int数据
     * @param b
     * @return
     */
    public static int byteToInt(byte b){
    	return Integer.parseInt(Integer.toHexString(b & 0xFF));
    }
    
    
    /**
     * 将设备状态码进行解析处理
     * @param deviceStatus
     * @return
     */
    public static StringBuffer stringToBuffer(String deviceStatus){
        
    	StringBuffer sb = new StringBuffer();
		char [] strs =deviceStatus.toCharArray();
		if(strs[10]=='1'){
			sb.append("监护人报警,");
		}
		if(strs[12]=='1'){
			sb.append("进围栏报警,");
		}
		if(strs[13]=='1'){
			sb.append("出围栏报警,");
		}
		if(strs[31]=='1'){
			sb.append("低电状态,");
		}
		if(strs[15]=='1'){
			sb.append("SOS报警,");
		}
		
		if(sb.length()==0){
			sb.append("正常");
		}else if(sb.length()>0&&sb.charAt(sb.length()-1)==','){
			sb.replace(sb.length()-1, sb.length(), "。");
		}
		return sb;
    	
    }

}
