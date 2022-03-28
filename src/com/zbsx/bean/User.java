package com.zbsx.bean;

/**
 * 包名: com.zbsx.bean
 * 类名: User
 * 创建用户: Administrator
 * 创建日期: 2021年07月13日 14:06
 * 项目名: movie
 **/
public class User {
    private int user_id;
    private String user_name;
    private String user_pwd;
    private String user_tel;
    private String user_email;
    private int user_role;
    private String user_headimg;
    private int user_state;

    /**
     * 方法名称：User <br/>
     * 功能描述: 用户实体类的无参构造函数 <br/>
     * 方法参数：[] <br/>
     * 结果返回： <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 14:08 <br/>
     */
    public User() {
    }
    /**
     * 方法名称： User<br/>
     * 功能描述: 用户实体类的有参构造函数 <br/>
     * 方法参数：[user_id, user_name, user_pwd, user_tel, user_email, user_role, user_headimg, user_state] <br/>
     * 结果返回： <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:32 <br/>
     */
    public User(int user_id, String user_name, String user_pwd, String user_tel, String user_email, int user_role, String user_headimg, int user_state) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
        this.user_tel = user_tel;
        this.user_email = user_email;
        this.user_role = user_role;
        this.user_headimg = user_headimg;
        this.user_state = user_state;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_tel='" + user_tel + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_role=" + user_role +
                ", user_headimg='" + user_headimg + '\'' +
                ", user_state=" + user_state +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getUser_role() {
        return user_role;
    }

    public void setUser_role(int user_role) {
        this.user_role = user_role;
    }

    public String getUser_headimg() {
        return user_headimg;
    }

    public void setUser_headimg(String user_headimg) {
        this.user_headimg = user_headimg;
    }

    public int getUser_state() {
        return user_state;
    }

    public void setUser_state(int user_state) {
        this.user_state = user_state;
    }
}