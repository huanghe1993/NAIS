package com.anyikang.service.impl;

import com.anyikang.dao.LocationMapper;
import com.anyikang.model.Location;
import com.anyikang.model.LocationCustom;
import com.anyikang.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huanghe on 2017/3/30.
 */
@Service
public class LocationServicelmp implements LocationService {

    @Autowired
    private LocationMapper locationMapper;
    @Override
    public List<Location> findLocationInfoByDeviceId(Integer deviceId) {
        return locationMapper.findLocationInfoByDeviceId(deviceId);
    }

    @Override
    public List<Location> findLocationByDeviceAndDateSection(LocationCustom locationCustom) {
        return locationMapper.findLocationByDeviceAndDateSection(locationCustom);
    }
}
