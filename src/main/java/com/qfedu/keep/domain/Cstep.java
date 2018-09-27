package com.qfedu.keep.domain;

public class Cstep {
    private Integer id;

    private Integer cstepdid;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCstepdid() {
        return cstepdid;
    }

    public void setCstepdid(Integer cstepdid) {
        this.cstepdid = cstepdid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}