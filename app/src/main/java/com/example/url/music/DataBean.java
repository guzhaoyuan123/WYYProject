package com.example.url.music;

public class DataBean {
    /**
     * id : 1363948882
     * url : http://m8.music.126.net/20191219104124/0a6e8a7fadbebd67ed3ef15efe288876/ymusic/0459/045c/520c/330c359473365e50a368ef0d43bc612f.mp3
     * br : 128000
     * size : 3072462
     * md5 : 330c359473365e50a368ef0d43bc612f
     * code : 200
     * expi : 1200
     * type : mp3
     * gain : 0
     * fee : 8
     * uf : null
     * payed : 0
     * flag : 64
     * canExtend : false
     * freeTrialInfo : null
     * level : standard
     * encodeType : mp3
     */

    private long id;
    private String url;
    private long br;
    private long size;
    private String md5;
    private long code;
    private long expi;
    private String type;
    private long gain;
    private long fee;
    private Object uf;
    private long payed;
    private long flag;
    private boolean canExtend;
    private Object freeTrialInfo;
    private String level;
    private String encodeType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getBr() {
        return br;
    }

    public void setBr(long br) {
        this.br = br;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getExpi() {
        return expi;
    }

    public void setExpi(long expi) {
        this.expi = expi;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getGain() {
        return gain;
    }

    public void setGain(long gain) {
        this.gain = gain;
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public Object getUf() {
        return uf;
    }

    public void setUf(Object uf) {
        this.uf = uf;
    }

    public long getPayed() {
        return payed;
    }

    public void setPayed(long payed) {
        this.payed = payed;
    }

    public long getFlag() {
        return flag;
    }

    public void setFlag(long flag) {
        this.flag = flag;
    }

    public boolean isCanExtend() {
        return canExtend;
    }

    public void setCanExtend(boolean canExtend) {
        this.canExtend = canExtend;
    }

    public Object getFreeTrialInfo() {
        return freeTrialInfo;
    }

    public void setFreeTrialInfo(Object freeTrialInfo) {
        this.freeTrialInfo = freeTrialInfo;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEncodeType() {
        return encodeType;
    }

    public void setEncodeType(String encodeType) {
        this.encodeType = encodeType;
    }
}
