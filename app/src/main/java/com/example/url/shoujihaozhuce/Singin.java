package com.example.url.shoujihaozhuce;

//判断手机号码是否注册过的请求类结果
public class Singin {

    /**
     * exist : 1
     * nickname : 大大怪_JmVp
     * hasPassword : true
     * code : 200
     */

    private int exist;
    private String nickname;
    private boolean hasPassword;
    private int code;

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isHasPassword() {
        return hasPassword;
    }

    public void setHasPassword(boolean hasPassword) {
        this.hasPassword = hasPassword;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
