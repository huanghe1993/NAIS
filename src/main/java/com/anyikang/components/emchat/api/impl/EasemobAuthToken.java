package com.anyikang.components.emchat.api.impl;

import com.anyikang.components.emchat.api.AuthTokenAPI;
import com.anyikang.components.emchat.comm.TokenUtil;


public class EasemobAuthToken implements AuthTokenAPI{

	@Override
	public Object getAuthToken(){
		return TokenUtil.getAccessToken();
	}
}
