package com.zbsx.util;

import com.alibaba.fastjson.JSONArray;

/**
 * 包名: com.zbsx.control
 * 类名: JsonMessage
 * 创建用户: Administrator
 * 创建日期: 2021年07月14日 11:02
 * 项目名: movie
 **/
public class JsonMessage {
    private int code;//编号
    private int count;
    private String msg;//消息
    private JSONArray data ;//业务数据
    private String location;//跳转路径

    /**
     * 方法名称：JsonMessage <br/>
     * 功能描述: JsonMessage的无参构造函数 <br/>
     * 方法参数：[] <br/>
     * 结果返回： <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/14 11:28 <br/>
     */
    public JsonMessage() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JSONArray getData() {
        return data;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}