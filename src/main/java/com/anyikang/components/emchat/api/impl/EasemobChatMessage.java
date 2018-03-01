package com.anyikang.components.emchat.api.impl;

import com.anyikang.components.emchat.api.ChatMessageAPI;
import com.anyikang.components.emchat.comm.EasemobAPI;
import com.anyikang.components.emchat.comm.OrgInfo;
import com.anyikang.components.emchat.comm.ResponseHandler;
import com.anyikang.components.emchat.comm.TokenUtil;

import io.swagger.client.ApiException;
import io.swagger.client.api.ChatHistoryApi;


public class EasemobChatMessage  implements ChatMessageAPI {

    private ResponseHandler responseHandler = new ResponseHandler();
    private ChatHistoryApi api = new ChatHistoryApi();

    @Override
    public Object exportChatMessages(final Long limit,final String cursor,final String query){
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatmessagesGet(OrgInfo.ORG_NAME,OrgInfo.APP_NAME,TokenUtil.getAccessToken(),query,limit+"",cursor);
            }
        });
    }
}
