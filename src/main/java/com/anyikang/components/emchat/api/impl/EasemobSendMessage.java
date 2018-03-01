package com.anyikang.components.emchat.api.impl;

import com.anyikang.components.emchat.api.SendMessageAPI;
import com.anyikang.components.emchat.comm.EasemobAPI;
import com.anyikang.components.emchat.comm.OrgInfo;
import com.anyikang.components.emchat.comm.ResponseHandler;
import com.anyikang.components.emchat.comm.TokenUtil;

import io.swagger.client.ApiException;
import io.swagger.client.api.MessagesApi;
import io.swagger.client.model.Msg;

public class EasemobSendMessage implements SendMessageAPI {
    private ResponseHandler responseHandler = new ResponseHandler();
    private MessagesApi api = new MessagesApi();
    @Override
    public Object sendMessage(final Object payload) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameMessagesPost(OrgInfo.ORG_NAME,OrgInfo.APP_NAME,TokenUtil.getAccessToken(), (Msg) payload);
            }
        });
    }
}
