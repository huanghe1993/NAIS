package com.anyikang.components.emchat.comm;

import java.util.List;

/**
 * Created by GalaIO on 2017/5/18.
 */
public class ResponseBodyUtil {

    /**
     * action : put
     * application : 4d7e4ba0-dc4a-11e3-90d5-e1ffbaacdaf5
     * uri : https://a1.easemob.com/easemob-demo/chatdemoui
     * entities : []
     * data : {"maxusers":true,"groupname":true,"description":true}
     * timestamp : 1419565633183
     * duration : 30
     * organization : easemob-demo
     * applicationName : chatdemoui
     */

    private String action;
    private String application;
    private String uri;
    private Object data;
    private long timestamp;
    private int duration;
    private String organization;
    private String applicationName;
    private List<Object> entities;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public List<Object> getEntities() {
        return entities;
    }

    public void setEntities(List<Object> entities) {
        this.entities = entities;
    }

}
