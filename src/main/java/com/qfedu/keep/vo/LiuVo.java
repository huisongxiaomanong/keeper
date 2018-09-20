package com.qfedu.keep.vo;

import java.util.List;

/**
 * @project:keeper
 * @description:自定义的VO
 * @author:刘飞跃
 * @create:2018年09月19日22点37
 */
public class LiuVo <T>{
    private int code;
    private String msg;
    private long count;
    private List<T> datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
    public static LiuVo setError(int code,String msg,int count){
        LiuVo<Object> objectLiuVo = new LiuVo<>();
        objectLiuVo.setCount(count);
        objectLiuVo.setMsg(msg);
        objectLiuVo.setCode(code);
        return objectLiuVo;
    }
}
