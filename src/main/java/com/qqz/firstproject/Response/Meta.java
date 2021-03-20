package com.qqz.firstproject.Response;/*
@Author qqz
@create 2020-02-11  4:03
*/

import static com.qqz.firstproject.Constant.MsgConstant.MSG_DONE;
import static com.qqz.firstproject.Constant.MsgConstant.MSG_UNDONE;
import static com.qqz.firstproject.Constant.StatusConstant.CORRECT_STATUS;
import static com.qqz.firstproject.Constant.StatusConstant.WRONG_STATUS;

public class Meta {
    private String msg;
    private int status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Meta(String msg , int status) {
        this.msg = msg;
        this.status = status;
    }
}
