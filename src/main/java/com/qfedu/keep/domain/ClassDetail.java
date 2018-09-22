package com.qfedu.keep.domain;

import java.util.List;

public class ClassDetail {
    private Integer id;

    private String name;

    private Integer sid;

    private String classimg;

    private String content;

    private String breath;
    private String feeling;
    private String classDetailImgLit;

    @Override
    public String toString() {
        return "ClassDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sid=" + sid +
                ", classimg='" + classimg + '\'' +
                ", content='" + content + '\'' +
                ", breath='" + breath + '\'' +
                ", feeling='" + feeling + '\'' +
                ", classDetailImgLit='" + classDetailImgLit + '\'' +
                ", classDetailImgdes='" + classDetailImgdes + '\'' +
                ", csteps=" + csteps +
                ", questions=" + questions +
                '}';
    }

    public String getBreath() {
        return breath;
    }

    public void setBreath(String breath) {
        this.breath = breath;
    }

    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    public String getClassDetailImgLit() {
        return classDetailImgLit;
    }

    public void setClassDetailImgLit(String classDetailImgLit) {
        this.classDetailImgLit = classDetailImgLit;
    }

    public String getClassDetailImgdes() {
        return classDetailImgdes;
    }

    public void setClassDetailImgdes(String classDetailImgdes) {
        this.classDetailImgdes = classDetailImgdes;
    }

    public List<Cstep> getCsteps() {
        return csteps;
    }

    public void setCsteps(List<Cstep> csteps) {
        this.csteps = csteps;
    }


    private String classDetailImgdes;
    private List<Cstep> csteps;
    private Question questions;

    public Question getQuestions() {
        return questions;
    }

    public void setQuestions(Question questions) {
        this.questions = questions;
    }

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

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getClassimg() {
        return classimg;
    }

    public void setClassimg(String classimg) {
        this.classimg = classimg == null ? null : classimg.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}