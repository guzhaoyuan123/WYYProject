package com.example.url.music;

import java.util.List;

//音乐的请求类结果
public class Music {

    /**
     * data : [{"id":1363948882,"url":"http://m8.music.126.net/20191219104124/0a6e8a7fadbebd67ed3ef15efe288876/ymusic/0459/045c/520c/330c359473365e50a368ef0d43bc612f.mp3","br":128000,"size":3072462,"md5":"330c359473365e50a368ef0d43bc612f","code":200,"expi":1200,"type":"mp3","gain":0,"fee":8,"uf":null,"payed":0,"flag":64,"canExtend":false,"freeTrialInfo":null,"level":"standard","encodeType":"mp3"}]
     * code : 200
     */

//    /song/url?id=1363948882

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }
}
