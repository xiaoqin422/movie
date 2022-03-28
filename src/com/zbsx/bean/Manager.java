package com.zbsx.bean;

/**
 * 包名: com.zbsx.bean
 * 类名: Manager
 * 创建用户: Administrator
 * 创建日期: 2021年07月13日 12:52
 * 项目名: movie
 **/
public class Manager {
    private String name;
    private String password;
    private String tel;
    private String email;
    private String role;
    private int state;
    private String memo;

    /**
     * 方法名称：Manager <br/>
     * 功能描述: 系统管理员实体类的无参构造函数 <br/>
     * 方法参数：[] <br/>
     * 结果返回： <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 12:59 <br/>
     */
    public Manager(){

    }

    /**
     * 方法名称： Manager<br/>
     * 功能描述: 系统管理员实体类的构造函数 <br/>
     * 方法参数：[name, password, tel, email, role, state, memo] <br/>
     * 结果返回： <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/15 18:47 <br/>
     */
    public Manager(String name, String password, String tel, String email, String role, int state, String memo) {
        this.name = name;
        this.password = password;
        this.tel = tel;
        this.email = email;
        this.role = role;
        this.state = state;
        this.memo = memo;
    }


    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", state=" + state +
                ", memo='" + memo + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}