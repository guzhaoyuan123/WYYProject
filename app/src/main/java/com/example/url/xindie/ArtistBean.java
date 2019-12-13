package com.example.url.xindie;

import java.util.List;

public class ArtistBean {
    /**
     * name : 李荣浩
     * id : 4292
     * picId : 109951164538801810
     * img1v1Id : 18686200114669624
     * briefDesc :
     * picUrl : http://p4.music.126.net/5a8JbNUEwmlzspiPYr8MDQ==/109951164538801813.jpg
     * img1v1Url : http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
     * albumSize : 24
     * alias : []
     * trans :
     * musicSize : 144
     * topicPerson : 0
     * picId_str : 109951164538801813
     * img1v1Id_str : 18686200114669622
     */

    private String name;
    private int id;
    private long picId;
    private long img1v1Id;
    private String briefDesc;
    private String picUrl;
    private String img1v1Url;
    private int albumSize;
    private String trans;
    private int musicSize;
    private int topicPerson;
    private String picId_str;
    private String img1v1Id_str;
    private List<?> alias;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAlbumSize() {
        return albumSize;
    }

    public void setAlbumSize(int albumSize) {
        this.albumSize = albumSize;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public int getMusicSize() {
        return musicSize;
    }

    public void setMusicSize(int musicSize) {
        this.musicSize = musicSize;
    }

    public int getTopicPerson() {
        return topicPerson;
    }

    public void setTopicPerson(int topicPerson) {
        this.topicPerson = topicPerson;
    }

    public String getPicId_str() {
        return picId_str;
    }

    public void setPicId_str(String picId_str) {
        this.picId_str = picId_str;
    }

    public String getImg1v1Id_str() {
        return img1v1Id_str;
    }

    public void setImg1v1Id_str(String img1v1Id_str) {
        this.img1v1Id_str = img1v1Id_str;
    }

    public List<?> getAlias() {
        return alias;
    }

    public void setAlias(List<?> alias) {
        this.alias = alias;
    }
}
