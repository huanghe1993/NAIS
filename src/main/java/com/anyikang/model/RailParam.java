package com.anyikang.model;

/**
 * Created by GalaIO on 2017/4/17.
 */
public class RailParam {

    /**
     * railName : test1
     * railType : 0
     * railLatitude : 100
     * railLongitude : 1000
     * parameter1 : 10
     * parameter2 : 10
     * status : true
     * startTime : 14:00
     * endTime : 18:00
     */

    private String railName;
    private byte railType;
    private float railLatitude;
    private float railLongitude;
    private float parameter1;
    private float parameter2;
    private boolean status;
    private String startTime;
    private String endTime;

    public String getRailName() {
        return railName;
    }

    public void setRailName(String railName) {
        this.railName = railName;
    }

    public byte getRailType() {
        return railType;
    }

    public void setRailType(byte railType) {
        this.railType = railType;
    }

    public float getRailLatitude() {
        return railLatitude;
    }

    public void setRailLatitude(float railLatitude) {
        this.railLatitude = railLatitude;
    }

    public float getRailLongitude() {
        return railLongitude;
    }

    public void setRailLongitude(float railLongitude) {
        this.railLongitude = railLongitude;
    }

    public float getParameter1() {
        return parameter1;
    }

    public void setParameter1(float parameter1) {
        this.parameter1 = parameter1;
    }

    public float getParameter2() {
        return parameter2;
    }

    public void setParameter2(float parameter2) {
        this.parameter2 = parameter2;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
