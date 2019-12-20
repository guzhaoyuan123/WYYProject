package com.example.url.guanfang;

import java.util.List;

public class PlaylistsBean {
    /**
     * name : 拒绝当咸鱼：百首励志华语为梦护航
     * id : 2967801365
     * trackNumberUpdateTime : 1576593670809
     * status : 0
     * userId : 1548006936
     * createTime : 1567421697430
     * updateTime : 1576593670809
     * subscribedCount : 16
     * trackCount : 102
     * cloudTrackCount : 0
     * coverImgUrl : http://p2.music.126.net/byCnAfBvNVDWnFqhhQrJdA==/109951164545305276.jpg
     * coverImgId : 109951164545305280
     * description : 人生的梦想之路
     请你坚持走下去
     挺胸抬头向前进
     尽管路上会孤独
     会感觉劳累心酸
     但别轻易就放弃

     愿我们跨过泥潭
     越过一座座山丘
     游出无边际大海
     爬上高峰的山巅
     仰望着浩瀚星空

     愿我们努力拼搏后，得到自己想要的一切！我们都还年轻，别当佛系玩家！别当没有梦想咸鱼！
     人生只有一次，别辜负自己！
     * tags : ["华语","学习","治愈"]
     * playCount : 2014
     * trackUpdateTime : 1576593704593
     * specialType : 0
     * totalDuration : 0
     * creator : {"defaultAvatar":false,"province":1000000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/RwnvDOZdn81dysWYa_CWXQ==/109951164488268681.jpg","accountStatus":0,"gender":1,"city":1005300,"birthday":938218908604,"userId":1548006936,"userType":200,"nickname":"真咸鱼饼干","signature":"做自己喜欢的事情，听自己喜欢的歌，不用在乎别人说什么，我就是我自己。","description":"","detailDescription":"","avatarImgId":109951164488268690,"backgroundImgId":109951164491509780,"backgroundUrl":"http://p1.music.126.net/tMS5OeVKGlgNzm0v0wdtWw==/109951164491509774.jpg","authority":0,"mutual":false,"expertTags":["欧美"],"experts":null,"djStatus":0,"vipType":11,"remarkName":null,"avatarImgIdStr":"109951164488268681","backgroundImgIdStr":"109951164491509774","avatarImgId_str":"109951164488268681"}
     * tracks : null
     * subscribers : []
     * subscribed : false
     * commentThreadId : A_PL_0_2967801365
     * newImported : false
     * adType : 0
     * highQuality : false
     * privacy : 0
     * ordered : true
     * anonimous : false
     * coverStatus : 3
     * recommendInfo : null
     * shareCount : 1
     * coverImgId_str : 109951164545305276
     * commentCount : 0
     * alg : alg_sq_featured
     */

    private String name;
    private long id;
    private long trackNumberUpdateTime;
    private int status;
    private int userId;
    private long createTime;
    private long updateTime;
    private int subscribedCount;
    private int trackCount;
    private int cloudTrackCount;
    private String coverImgUrl;
    private long coverImgId;
    private String description;
    private int playCount;
    private long trackUpdateTime;
    private int specialType;
    private int totalDuration;
    private CreatorBean creator;
    private Object tracks;
    private boolean subscribed;
    private String commentThreadId;
    private boolean newImported;
    private int adType;
    private boolean highQuality;
    private int privacy;
    private boolean ordered;
    private boolean anonimous;
    private int coverStatus;
    private Object recommendInfo;
    private int shareCount;
    private String coverImgId_str;
    private int commentCount;
    private String alg;
    private List<String> tags;
    private List<?> subscribers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTrackNumberUpdateTime() {
        return trackNumberUpdateTime;
    }

    public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
        this.trackNumberUpdateTime = trackNumberUpdateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getSubscribedCount() {
        return subscribedCount;
    }

    public void setSubscribedCount(int subscribedCount) {
        this.subscribedCount = subscribedCount;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public int getCloudTrackCount() {
        return cloudTrackCount;
    }

    public void setCloudTrackCount(int cloudTrackCount) {
        this.cloudTrackCount = cloudTrackCount;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public long getCoverImgId() {
        return coverImgId;
    }

    public void setCoverImgId(long coverImgId) {
        this.coverImgId = coverImgId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public long getTrackUpdateTime() {
        return trackUpdateTime;
    }

    public void setTrackUpdateTime(long trackUpdateTime) {
        this.trackUpdateTime = trackUpdateTime;
    }

    public int getSpecialType() {
        return specialType;
    }

    public void setSpecialType(int specialType) {
        this.specialType = specialType;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public CreatorBean getCreator() {
        return creator;
    }

    public void setCreator(CreatorBean creator) {
        this.creator = creator;
    }

    public Object getTracks() {
        return tracks;
    }

    public void setTracks(Object tracks) {
        this.tracks = tracks;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public boolean isNewImported() {
        return newImported;
    }

    public void setNewImported(boolean newImported) {
        this.newImported = newImported;
    }

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public boolean isHighQuality() {
        return highQuality;
    }

    public void setHighQuality(boolean highQuality) {
        this.highQuality = highQuality;
    }

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public boolean isAnonimous() {
        return anonimous;
    }

    public void setAnonimous(boolean anonimous) {
        this.anonimous = anonimous;
    }

    public int getCoverStatus() {
        return coverStatus;
    }

    public void setCoverStatus(int coverStatus) {
        this.coverStatus = coverStatus;
    }

    public Object getRecommendInfo() {
        return recommendInfo;
    }

    public void setRecommendInfo(Object recommendInfo) {
        this.recommendInfo = recommendInfo;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public String getCoverImgId_str() {
        return coverImgId_str;
    }

    public void setCoverImgId_str(String coverImgId_str) {
        this.coverImgId_str = coverImgId_str;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<?> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<?> subscribers) {
        this.subscribers = subscribers;
    }
}
