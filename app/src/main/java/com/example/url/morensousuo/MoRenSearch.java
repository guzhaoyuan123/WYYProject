package com.example.url.morensousuo;

public class MoRenSearch {

    /**
     * code : 200
     * data : {"showKeyword":"飞 - 王恩信Est","action":0,"realkeyword":"飞","searchType":1018,"alg":"alg_i2q_song_dnn","gap":0}
     */

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }
}
