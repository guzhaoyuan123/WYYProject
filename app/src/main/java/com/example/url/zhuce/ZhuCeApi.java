package com.example.url.zhuce;

//注册的请求类结果
public class ZhuCeApi {

    /**
     * msg : 该昵称已被占用
     * code : 505
     * message : 该昵称已被占用
     */

    private String msg;
    private int code;
    private String message;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
