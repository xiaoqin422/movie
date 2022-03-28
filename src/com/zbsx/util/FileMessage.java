package com.zbsx.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 包名: com.zbsx.util
 * 类名: FileMessage
 * 创建用户: Administrator
 * 创建日期: 2021年07月19日 16:00
 * 项目名: movie
 **/
public class FileMessage {
    private boolean success;
    private String msg;//消息
    private JSONObject data;

    public FileMessage() {
    }

    public FileMessage(boolean success, String msg, JSONObject data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FileMessage{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}