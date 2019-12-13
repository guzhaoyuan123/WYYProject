package com.example.url.yuncunjingxuanshiping;

import java.util.List;

public class DataBean {
    /**
     * id : 10904989
     * name : 麻雀
     * artistId : 4292
     * artistName : 李荣浩
     * briefDesc :
     * desc : 我们和生活在城市中的麻雀一样
     虽然渺小 但是五脏俱全
     感情 思想 理想
     令我们成为 人群中的一只只麻雀
     《麻雀》MV由李荣浩自编自导自演，拍摄耗时9分钟，拍了3遍，后期制作2个月之久。通过一镜到底的拍摄手法将我们的视线和情绪聚焦到某个点上，或许你会觉得镜中人物像你，亦或镜中之人就是你，像只麻雀，没有终点，为了梦想拼命在飞，证明着自己的存在。
     * cover : http://p1.music.126.net/-LkI0yoGquAWFl2W3kEXIg==/109951164536308330.jpg
     * coverId : 109951164536308340
     * playCount : 602192
     * subCount : 3576
     * shareCount : 2093
     * likeCount : 14623
     * commentCount : 2301
     * duration : 267000
     * nType : 0
     * publishTime : 2019-12-09
     * brs : {"240":"http://vodkgeyttp8.vod.126.net/cloudmusic/obj/core/632873387/6932ce4f583c09e086554ebc2b54a664.mp4?wsSecret=d39ccc6d7b9f0c1486399b0f29c1ec1b&wsTime=1576151286","480":"http://vodkgeyttp8.vod.126.net/cloudmusic/obj/core/632873387/5cffcf4f2e36259c20bdd36ff256a697.mp4?wsSecret=e3377feb501336aace71980c4f6517f3&wsTime=1576151286","720":"http://vodkgeyttp8.vod.126.net/cloudmusic/obj/core/632873387/14845ceb9062d95272bd27abdf78312e.mp4?wsSecret=8838cce196d8f33006f65b13c4841b3b&wsTime=1576151286","1080":"http://vodkgeyttp8.vod.126.net/cloudmusic/obj/core/632873387/4db28fdf08f3f1e6aee1c3a19575316e.mp4?wsSecret=8571b8f1f949e45a576e69fc3e6ae127&wsTime=1576151286"}
     * artists : [{"id":4292,"name":"李荣浩"}]
     * isReward : false
     * commentThreadId : R_MV_5_10904989
     */

    private int id;
    private String name;
    private int artistId;
    private String artistName;
    private String briefDesc;
    private String desc;
    private String cover;
    private long coverId;
    private int playCount;
    private int subCount;
    private int shareCount;
    private int likeCount;
    private int commentCount;
    private int duration;
    private int nType;
    private String publishTime;
    private BrsBean brs;
    private boolean isReward;
    private String commentThreadId;
    private List<ArtistsBean> artists;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public long getCoverId() {
        return coverId;
    }

    public void setCoverId(long coverId) {
        this.coverId = coverId;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getSubCount() {
        return subCount;
    }

    public void setSubCount(int subCount) {
        this.subCount = subCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getNType() {
        return nType;
    }

    public void setNType(int nType) {
        this.nType = nType;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public BrsBean getBrs() {
        return brs;
    }

    public void setBrs(BrsBean brs) {
        this.brs = brs;
    }

    public boolean isIsReward() {
        return isReward;
    }

    public void setIsReward(boolean isReward) {
        this.isReward = isReward;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public List<ArtistsBean> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistsBean> artists) {
        this.artists = artists;
    }
}
