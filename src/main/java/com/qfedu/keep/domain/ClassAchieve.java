package com.qfedu.keep.domain;

public class ClassAchieve {
    private Integer id;

    private Integer uid;

    private String name;

    private Integer cid;

    private String achieveimg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getAchieveimg() {
        return achieveimg;
    }

    public void setAchieveimg(String achieveimg) {
        this.achieveimg = achieveimg == null ? null : achieveimg.trim();
    }
}