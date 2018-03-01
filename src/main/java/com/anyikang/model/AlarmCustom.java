package com.anyikang.model;

import java.util.Date;

/**
 * Created by huanghe on 2017/3/30.
 */
public class AlarmCustom extends Alarm {
    public Date startDate;
    public Date endDate;




    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
