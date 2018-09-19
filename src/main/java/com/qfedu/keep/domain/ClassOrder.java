package com.qfedu.keep.domain;

public class ClassOrder {
    private Integer id;

    private Integer sid;

    private String name;

    private Integer allprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAllprice() {
        return allprice;
    }

    public void setAllprice(Integer allprice) {
        this.allprice = allprice;
    }
}