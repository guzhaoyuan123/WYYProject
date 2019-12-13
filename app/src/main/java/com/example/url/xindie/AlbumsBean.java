package com.example.url.xindie;

import java.util.List;

public class AlbumsBean {
    /**
     * name : 麻雀
     * id : 83878976
     * type : EP/Single
     * size : 1
     * picId : 109951164527590800
     * blurPicUrl : http://p3.music.126.net/TzlSVBiNtpRD2b7MT2Hi-w==/109951164527590793.jpg
     * companyId : 0
     * pic : 109951164527590800
     * picUrl : http://p4.music.126.net/TzlSVBiNtpRD2b7MT2Hi-w==/109951164527590793.jpg
     * publishTime : 1575475200000
     * description :
     * tags :
     * company : 一样音乐
     * briefDesc :
     * artist : {"name":"李荣浩","id":4292,"picId":109951164538801810,"img1v1Id":18686200114669624,"briefDesc":"","picUrl":"http://p4.music.126.net/5a8JbNUEwmlzspiPYr8MDQ==/109951164538801813.jpg","img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":24,"alias":[],"trans":"","musicSize":144,"topicPerson":0,"picId_str":"109951164538801813","img1v1Id_str":"18686200114669622"}
     * songs : null
     * alias : []
     * status : 0
     * copyrightId : 1416577
     * commentThreadId : R_AL_3_83878976
     * artists : [{"name":"李荣浩","id":4292,"picId":0,"img1v1Id":18686200114669624,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0,"img1v1Id_str":"18686200114669622"}]
     * paid : false
     * onSale : false
     * picId_str : 109951164527590793
     * transNames : ["YAHO"]
     */

    private String name;
    private int id;
    private String type;
    private int size;
    private long picId;
    private String blurPicUrl;
    private int companyId;
    private long pic;
    private String picUrl;
    private long publishTime;
    private String description;
    private String tags;
    private String company;
    private String briefDesc;
    private ArtistBean artist;
    private Object songs;
    private int status;
    private int copyrightId;
    private String commentThreadId;
    private boolean paid;
    private boolean onSale;
    private String picId_str;
    private List<?> alias;
    private List<ArtistsBean> artists;
    private List<String> transNames;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getPicId() {
        return picId;
    }

    public void setPicId(long picId) {
        this.picId = picId;
    }

    public String getBlurPicUrl() {
        return blurPicUrl;
    }

    public void setBlurPicUrl(String blurPicUrl) {
        this.blurPicUrl = blurPicUrl;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public long getPic() {
        return pic;
    }

    public void setPic(long pic) {
        this.pic = pic;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public ArtistBean getArtist() {
        return artist;
    }

    public void setArtist(ArtistBean artist) {
        this.artist = artist;
    }

    public Object getSongs() {
        return songs;
    }

    public void setSongs(Object songs) {
        this.songs = songs;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCopyrightId() {
        return copyrightId;
    }

    public void setCopyrightId(int copyrightId) {
        this.copyrightId = copyrightId;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public String getPicId_str() {
        return picId_str;
    }

    public void setPicId_str(String picId_str) {
        this.picId_str = picId_str;
    }

    public List<?> getAlias() {
        return alias;
    }

    public void setAlias(List<?> alias) {
        this.alias = alias;
    }

    public List<ArtistsBean> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistsBean> artists) {
        this.artists = artists;
    }

    public List<String> getTransNames() {
        return transNames;
    }

    public void setTransNames(List<String> transNames) {
        this.transNames = transNames;
    }
}
