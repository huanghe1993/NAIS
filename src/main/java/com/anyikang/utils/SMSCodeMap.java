package com.anyikang.utils;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by GalaIO on 2016/10/28.
 */

class SMSCode{
    public static int MAX_TIMES_PER_DAY = 10;

    public SMSCode(){
        setTimestamp(System.currentTimeMillis());
        times = 0;
    }
    //时间戳
    private long timestamp;

    private long getTimestamp() {
        return timestamp;
    }

    private void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    //每一天请求的次数
    private int times;

    private int getTimes() {
        return times;
    }

    private void tickTimes() throws Exception{
        if(System.currentTimeMillis() - getTimestamp() > 24*60*60*1000){
            setTimestamp(System.currentTimeMillis());
            times = 0;
        }
        if(times + 1 > MAX_TIMES_PER_DAY) throw new Exception("获取验证码超过次数！");
        this.times++;
    }
    //保存验证码
    private String code;

    public String getCode() {
        return code;
    }

    public String getNewCode() throws Exception {
        tickTimes();
        setCode(Integer.toString(new Random(System.currentTimeMillis()).nextInt(8999)+1000));
        return getCode();
    }
    private void setCode(String code) {
        this.code = code;
    }
}

public class SMSCodeMap {

    private HashMap<String, SMSCode> map = new HashMap<String, SMSCode>();

    private SMSCodeMap(){

    }

    private static SMSCodeMap Instance = new SMSCodeMap();

    public synchronized String getCode(String key) throws Exception{
        SMSCode sms = map.get(key);
        if(sms == null){
            sms = new SMSCode();
            map.put(key, sms);
        }
        //获取新的验证码
        return sms.getNewCode();
    }

    public synchronized String query(String key){
        return map.get(key).getCode();
    }

    public synchronized void delete(String key){
        map.remove(key);
    }

    public static SMSCodeMap getInstance() {
        return Instance;
    }

}
