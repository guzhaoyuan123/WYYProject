package com.example.url.guanfangbandan;

import java.util.List;

public class SongsBean {
    /**
     * name : 断开的感情线
     * id : 1331658472
     * position : 1
     * alias : []
     * status : 0
     * fee : 8
     * copyrightId : 0
     * disc : 01
     * no : 1
     * artists : [{"name":"张沁乐","id":30959600,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0}]
     * album : {"name":"记录年华","id":74788781,"type":"专辑","size":1,"picId":109951163714185700,"blurPicUrl":"http://p2.music.126.net/ivTc8cUy6T_YAuONcQEsBw==/109951163714185693.jpg","companyId":0,"pic":109951163714185700,"picUrl":"http://p2.music.126.net/ivTc8cUy6T_YAuONcQEsBw==/109951163714185693.jpg","publishTime":1544106682016,"description":"","tags":"","company":null,"briefDesc":"","artist":{"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0},"songs":[],"alias":[],"status":0,"copyrightId":0,"commentThreadId":"R_AL_3_74788781","artists":[{"name":"张沁乐","id":30959600,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0}],"subType":"混音版","transName":null,"mark":0,"picId_str":"109951163714185693"}
     * starred : false
     * popularity : 90
     * score : 90
     * starredNum : 0
     * duration : 289636
     * playedNum : 0
     * dayPlays : 0
     * hearTime : 0
     * ringtone : null
     * crbt : null
     * audition : null
     * copyFrom :
     * commentThreadId : R_SO_4_1331658472
     * rtUrl : null
     * ftype : 0
     * rtUrls : []
     * copyright : 0
     * transName : null
     * sign : null
     * mark : 0
     * hMusic : {"name":null,"id":3524740629,"size":11587962,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":320000,"playTime":289636,"volumeDelta":0}
     * mMusic : {"name":null,"id":3524740630,"size":6952795,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":192000,"playTime":289636,"volumeDelta":1526}
     * lMusic : {"name":null,"id":3524740631,"size":4635211,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":128000,"playTime":289636,"volumeDelta":1900}
     * bMusic : {"name":null,"id":3524740631,"size":4635211,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":128000,"playTime":289636,"volumeDelta":1900}
     * mp3Url : null
     * mvid : 0
     * rtype : 0
     * rurl : null
     */

    private String name;
    private long id;
    private long position;
    private long status;
    private long fee;
    private long copyrightId;
    private String disc;
    private long no;
    private AlbumBean album;
    private boolean starred;
    private long popularity;
    private long score;
    private long starredNum;
    private long duration;
    private long playedNum;
    private long dayPlays;
    private long hearTime;
    private Object ringtone;
    private Object crbt;
    private Object audition;
    private String copyFrom;
    private String commentThreadId;
    private Object rtUrl;
    private long ftype;
    private long copyright;
    private Object transName;
    private Object sign;
    private long mark;
    private HMusicBean hMusic;
    private MMusicBean mMusic;
    private LMusicBean lMusic;
    private BMusicBean bMusic;
    private Object mp3Url;
    private long mvid;
    private long rtype;
    private Object rurl;
    private List<?> alias;
    private List<ArtistsBeanXX> artists;
    private List<?> rtUrls;

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

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public long getCopyrightId() {
        return copyrightId;
    }

    public void setCopyrightId(long copyrightId) {
        this.copyrightId = copyrightId;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public AlbumBean getAlbum() {
        return album;
    }

    public void setAlbum(AlbumBean album) {
        this.album = album;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public long getPopularity() {
        return popularity;
    }

    public void setPopularity(long popularity) {
        this.popularity = popularity;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getStarredNum() {
        return starredNum;
    }

    public void setStarredNum(long starredNum) {
        this.starredNum = starredNum;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getPlayedNum() {
        return playedNum;
    }

    public void setPlayedNum(long playedNum) {
        this.playedNum = playedNum;
    }

    public long getDayPlays() {
        return dayPlays;
    }

    public void setDayPlays(long dayPlays) {
        this.dayPlays = dayPlays;
    }

    public long getHearTime() {
        return hearTime;
    }

    public void setHearTime(long hearTime) {
        this.hearTime = hearTime;
    }

    public Object getRingtone() {
        return ringtone;
    }

    public void setRingtone(Object ringtone) {
        this.ringtone = ringtone;
    }

    public Object getCrbt() {
        return crbt;
    }

    public void setCrbt(Object crbt) {
        this.crbt = crbt;
    }

    public Object getAudition() {
        return audition;
    }

    public void setAudition(Object audition) {
        this.audition = audition;
    }

    public String getCopyFrom() {
        return copyFrom;
    }

    public void setCopyFrom(String copyFrom) {
        this.copyFrom = copyFrom;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public Object getRtUrl() {
        return rtUrl;
    }

    public void setRtUrl(Object rtUrl) {
        this.rtUrl = rtUrl;
    }

    public long getFtype() {
        return ftype;
    }

    public void setFtype(long ftype) {
        this.ftype = ftype;
    }

    public long getCopyright() {
        return copyright;
    }

    public void setCopyright(long copyright) {
        this.copyright = copyright;
    }

    public Object getTransName() {
        return transName;
    }

    public void setTransName(Object transName) {
        this.transName = transName;
    }

    public Object getSign() {
        return sign;
    }

    public void setSign(Object sign) {
        this.sign = sign;
    }

    public long getMark() {
        return mark;
    }

    public void setMark(long mark) {
        this.mark = mark;
    }

    public HMusicBean getHMusic() {
        return hMusic;
    }

    public void setHMusic(HMusicBean hMusic) {
        this.hMusic = hMusic;
    }

    public MMusicBean getMMusic() {
        return mMusic;
    }

    public void setMMusic(MMusicBean mMusic) {
        this.mMusic = mMusic;
    }

    public LMusicBean getLMusic() {
        return lMusic;
    }

    public void setLMusic(LMusicBean lMusic) {
        this.lMusic = lMusic;
    }

    public BMusicBean getBMusic() {
        return bMusic;
    }

    public void setBMusic(BMusicBean bMusic) {
        this.bMusic = bMusic;
    }

    public Object getMp3Url() {
        return mp3Url;
    }

    public void setMp3Url(Object mp3Url) {
        this.mp3Url = mp3Url;
    }

    public long getMvid() {
        return mvid;
    }

    public void setMvid(long mvid) {
        this.mvid = mvid;
    }

    public long getRtype() {
        return rtype;
    }

    public void setRtype(long rtype) {
        this.rtype = rtype;
    }

    public Object getRurl() {
        return rurl;
    }

    public void setRurl(Object rurl) {
        this.rurl = rurl;
    }

    public List<?> getAlias() {
        return alias;
    }

    public void setAlias(List<?> alias) {
        this.alias = alias;
    }

    public List<ArtistsBeanXX> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistsBeanXX> artists) {
        this.artists = artists;
    }

    public List<?> getRtUrls() {
        return rtUrls;
    }

    public void setRtUrls(List<?> rtUrls) {
        this.rtUrls = rtUrls;
    }
}
