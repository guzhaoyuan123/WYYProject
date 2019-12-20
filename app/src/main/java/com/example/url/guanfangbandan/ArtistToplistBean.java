package com.example.url.guanfangbandan;

import java.util.List;

public class ArtistToplistBean {
    /**
     * coverUrl : https://p2.music.126.net/MJdmNzZwTCz0b4IpHJV6Wg==/109951162865487429.jpg
     * artists : [{"first":"隔壁老樊","second":"","third":63246911},{"first":"薛之谦","second":"","third":61622222},{"first":"G.E.M.邓紫棋","second":"","third":61467171}]
     * name : 云音乐歌手榜
     * upateFrequency : 每天更新
     * position : 5
     * updateFrequency : 每天更新
     */

    private String coverUrl;
    private String name;
    private String upateFrequency;
    private long position;
    private String updateFrequency;
    private List<ArtistsBean> artists;

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpateFrequency() {
        return upateFrequency;
    }

    public void setUpateFrequency(String upateFrequency) {
        this.upateFrequency = upateFrequency;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public String getUpdateFrequency() {
        return updateFrequency;
    }

    public void setUpdateFrequency(String updateFrequency) {
        this.updateFrequency = updateFrequency;
    }

    public List<ArtistsBean> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistsBean> artists) {
        this.artists = artists;
    }
}
