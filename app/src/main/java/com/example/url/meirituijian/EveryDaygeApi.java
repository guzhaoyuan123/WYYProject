package com.example.url.meirituijian;

import java.util.List;

public class EveryDaygeApi {


    private String code;
    private Object relatedVideos;
    private PlaylistBean playlist;
    private Object urls;
    private List<PrivilegesBean> privileges;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getRelatedVideos() {
        return relatedVideos;
    }

    public void setRelatedVideos(Object relatedVideos) {
        this.relatedVideos = relatedVideos;
    }

    public PlaylistBean getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlaylistBean playlist) {
        this.playlist = playlist;
    }

    public Object getUrls() {
        return urls;
    }

    public void setUrls(Object urls) {
        this.urls = urls;
    }

    public List<PrivilegesBean> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegesBean> privileges) {
        this.privileges = privileges;
    }
}
