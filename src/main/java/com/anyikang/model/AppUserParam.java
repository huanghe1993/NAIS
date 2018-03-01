package com.anyikang.model;

/**
 * Created by GalaIO on 2017/4/17.
 */
public class AppUserParam {

    /**
     * mobile : 13318215152
     * name : 张三丰
     * password : 123456
     * email : sanfengzhang@126.com
     * avatar : 12345678901234567890
     */

    private String mobile;
    private String name;
    private String password;
    private String email;
    private String avatar;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
