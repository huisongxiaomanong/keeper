package com.qfedu.keep.domain;

public class SecondClass {
    private Integer id;

    private String name;

    private Integer fid;

    private String seconddesc;

    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getSeconddesc() {
        return seconddesc;
    }

    public void setSeconddesc(String seconddesc) {
        this.seconddesc = seconddesc == null ? null : seconddesc.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}