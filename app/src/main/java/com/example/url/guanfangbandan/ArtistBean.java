package com.example.url.guanfangbandan;

import java.util.List;

public class ArtistBean {
    /**
     * name :
     * id : 0
     * picId : 0
     * img1v1Id : 0
     * briefDesc :
     * picUrl : http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
     * img1v1Url : http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
     * albumSize : 0
     * alias : []
     * trans :
     * musicSize : 0
     * topicPerson : 0
     */

    private String name;
    private long id;
    private long picId;
    private long img1v1Id;
    private String briefDesc;
    private String picUrl;
    private String img1v1Url;
    private long albumSize;
    private String trans;
    private long musicSize;
    private long topicPerson;
    private List<?> alias;

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

    public long getPicId() {
        return picId;
    }

    public void setPicId(long picId) {
        this.picId = picId;
    }

    public long getImg1v1Id() {
        return img1v1Id;
    }

    public void setImg1v1Id(long img1v1Id) {
        this.img1v1Id = img1v1Id;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getImg1v1Url() {
        return img1v1Url;
    }

    public void setImg1v1Url(String img1v1Url) {
        this.img1v1Url = img1v1Url;
    }

    public long getAlbumSize() {
        return albumSize;
    }

    public void setAlbumSize(long albumSize) {
        this.albumSize = albumSize;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public long getMusicSize() {
        return musicSize;
    }

    public void setMusicSize(long musicSize) {
        this.musicSize = musicSize;
    }

    public long getTopicPerson() {
        return topicPerson;
    }

    public void setTopicPerson(long topicPerson) {
        this.topicPerson = topicPerson;
    }

    public List<?> getAlias() {
        return alias;
    }

    public void setAlias(List<?> alias) {
        this.alias = alias;
    }
}
