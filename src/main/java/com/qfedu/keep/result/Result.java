package com.qfedu.keep.result;

import java.util.List;

public class Result<T> {

    private int code;

    private String msg;

    private List<T> data;

    private Object outvalue;

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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Object getOutvalue() {
        return outvalue;
    }

    public void setOutvalue(Object outvalue) {
        this.outvalue = outvalue;
    }


}
