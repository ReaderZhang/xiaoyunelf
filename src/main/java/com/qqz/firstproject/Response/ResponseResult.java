package com.qqz.firstproject.Response;/*
@Author qqz
@create 2020-02-11  4:38
*/

import static com.qqz.firstproject.Constant.MsgConstant.MSG_DONE;
import static com.qqz.firstproject.Constant.MsgConstant.MSG_UNDONE;
import static com.qqz.firstproject.Constant.StatusConstant.CORRECT_STATUS;
import static com.qqz.firstproject.Constant.StatusConstant.WRONG_STATUS;

public class ResponseResult {
    private Object message;
    private Meta meta;
    public static ResponseResult Sucess(){
        return new ResponseResult ( new Meta ( MSG_DONE,CORRECT_STATUS ) );
    }
    public static ResponseResult Sucess(Object message){
        return new ResponseResult ( message,new Meta ( MSG_DONE,CORRECT_STATUS ) );
    }
    public static ResponseResult Fail(){
        return new ResponseResult ( new Meta ( MSG_UNDONE,WRONG_STATUS ) );
    }
    public static  ResponseResult Fail(Object message){
        return new ResponseResult ( message,new Meta ( MSG_UNDONE,WRONG_STATUS ) );
    }

    public ResponseResult(Meta meta) {
        this.message = message;
        this.meta = meta;
    }

    public ResponseResult(Object message , Meta meta) {
        this.message = message;
        this.meta = meta;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
