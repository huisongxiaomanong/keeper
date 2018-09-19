package com.qfedu.keep.vo;

public class V<T> {
    private int code;
    private String msg;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T date) {
        this.data = date;
    }
    public static V setError(int code, String msg) {
       V v =  new V();
       v.setCode(code);
       v.setMsg(msg);
      return v;
    }
    public static V setOk(int code, String msg){
        V v =  new V();
        v.setCode(code);
        v.setMsg(msg);
        return v;
    }
}
