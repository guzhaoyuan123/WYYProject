package com.example.url.paihangbang2;

import java.util.List;

public class AlBean {
    /**
     * id : 507265
     * name : Bewitched **** 1
     * picUrl : null
     * tns : []
     * pic : 0
     */

    private long id;
    private String name;
    private Object picUrl;
    private long pic;
    private List<?> tns;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(Object picUrl) {
        this.picUrl = picUrl;
    }

    public long getPic() {
        return pic;
    }

    public void setPic(long pic) {
        this.pic = pic;
    }

    public List<?> getTns() {
        return tns;
    }

    public void setTns(List<?> tns) {
        this.tns = tns;
    }
}
