package com.anyikang.config;

import com.anyikang.components.emchat.api.ChatGroupAPI;
import com.anyikang.components.emchat.api.IMUserAPI;
import com.anyikang.components.emchat.api.impl.EasemobChatGroup;
import com.anyikang.components.emchat.api.impl.EasemobIMUsers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangwei
 * @date 2017年6月29日
 */
@Configuration
public class EmchatConfig {
    @Bean
    public IMUserAPI imUserAPI(){
        return new EasemobIMUsers();
    }
    @Bean
    public ChatGroupAPI chatGroupAPI(){
        return new EasemobChatGroup();
    }
}
