package com.example.url.tuijiangedan;

public class ResultBean {
    /**
     * id : 3112654749
     * type : 0
     * name : 岁月万花筒 | 歌声中重温即将逝去的10年代
     * copywriter : 编辑推荐：过去的10年代，哪首歌是你的最爱呢~
     * picUrl : https://p2.music.126.net/V9D5mC-EgLxzV-k-jugmyA==/109951164541181281.jpg
     * canDislike : false
     * trackNumberUpdateTime : 1575987842624
     * playCount : 1133532
     * trackCount : 55
     * highQuality : false
     * alg : featured
     */

    private long id;
    private int type;
    private String name;
    private String copywriter;
    private String picUrl;
    private boolean canDislike;
    private long trackNumberUpdateTime;
    private int playCount;
    private int trackCount;
    private boolean highQuality;
    private String alg;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCopywriter() {
        return copywriter;
    }

    public void setCopywriter(String copywriter) {
        this.copywriter = copywriter;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public boolean isCanDislike() {
        return canDislike;
    }

    public void setCanDislike(boolean canDislike) {
        this.canDislike = canDislike;
    }

    public long getTrackNumberUpdateTime() {
        return trackNumberUpdateTime;
    }

    public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
        this.trackNumberUpdateTime = trackNumberUpdateTime;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public boolean isHighQuality() {
        return highQuality;
    }

    public void setHighQuality(boolean highQuality) {
        this.highQuality = highQuality;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }
}
