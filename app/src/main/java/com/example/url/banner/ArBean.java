package com.example.url.banner;

import java.util.List;

public class ArBean {
    /**
     * id : 5781
     * name : 薛之谦
     * tns : []
     * alias : []
     */

    private long id;
    private String name;
    private List<?> tns;
    private List<?> alias;

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

    public List<?> getTns() {
        return tns;
    }

    public void setTns(List<?> tns) {
        this.tns = tns;
    }

    public List<?> getAlias() {
        return alias;
    }

    public void setAlias(List<?> alias) {
        this.alias = alias;
    }
}

