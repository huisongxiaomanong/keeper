package com.qfedu.keep.domain;

public class Goodstype {
    private Integer id;

    private String type;

    private String flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    @Override
    public String toString() {
        return "Goodstype{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}