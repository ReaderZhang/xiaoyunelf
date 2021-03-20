package com.qqz.firstproject.pojo;/*
@Author qqz
@create 2020-02-18  22:54
*/

public class Exercise {
    private Integer eid;
    private String ename;
    private Integer isChoice;
    private String answer;
    private Integer status;
    public Exercise() {
    }

    public Exercise(Integer eid , String ename , Integer isChoice , String answer , Integer status) {
        this.eid = eid;
        this.ename = ename;
        this.isChoice = isChoice;
        this.answer = answer;
        this.status = status;
    }

    public Exercise(String ename , Integer isChoice , String answer , Integer status) {
        this.ename = ename;
        this.isChoice = isChoice;
        this.answer = answer;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getIsChoice() {
        return isChoice;
    }

    public void setIsChoice(Integer isChoice) {
        this.isChoice = isChoice;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", isChoice=" + isChoice +
                ", answer='" + answer + '\'' +
                ", status=" + status +
                '}';
    }
}
