package com.qfedu.keep.domain;

public class Goods {
    private Integer id;

    private String goodsname;

    private String goodstype;

    private String goodsdes;

    private Integer goodsoldprice;

    private Integer goodsprice;

    private String flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype == null ? null : goodstype.trim();
    }

    public String getGoodsdes() {
        return goodsdes;
    }

    public void setGoodsdes(String goodsdes) {
        this.goodsdes = goodsdes == null ? null : goodsdes.trim();
    }

    public Integer getGoodsoldprice() {
        return goodsoldprice;
    }

    public void setGoodsoldprice(Integer goodsoldprice) {
        this.goodsoldprice = goodsoldprice;
    }

    public Integer getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Integer goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsname='" + goodsname + '\'' +
                ", goodstype='" + goodstype + '\'' +
                ", goodsdes='" + goodsdes + '\'' +
                ", goodsoldprice=" + goodsoldprice +
                ", goodsprice=" + goodsprice +
                ", flag='" + flag + '\'' +
                '}';
    }
}