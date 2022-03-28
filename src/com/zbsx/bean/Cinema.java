package com.zbsx.bean;

public class Cinema {
    private Integer cinema_id;
    private String cinema_name;
    private String cinema_address;

    /**
     * 方法名称：Cinema <br/>
     * 功能描述: 电影类的无参构造函数 <br/>
     * 方法参数：[] <br/>
     * 结果返回： <br/>
     * 创建作者：1913040630崔晓康 <br/>
     * 创建时间: 2021/7/17 22:25 <br/>
     */
    public Cinema() {

    }

    /**
     * 方法名称： Cinema<br/>
     * 功能描述: 电影类的构造函数 <br/>
     * 方法参数：[cinema_id, cinema_name, cinema_address] <br/>
     * 结果返回： <br/>
     * 创建作者：1913040630崔晓康 <br/>
     * 创建时间: 2021/7/17 22:25 <br/>
     */
    public Cinema(Integer cinema_id, String cinema_name, String cinema_address) {
        super();
        this.cinema_id = cinema_id;
        this.cinema_name = cinema_name;
        this.cinema_address = cinema_address;
    }

    public Integer getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(Integer cinema_id) {
        this.cinema_id = cinema_id;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }

    public String getCinema_address() {
        return cinema_address;
    }

    public void setCinema_address(String cinema_address) {
        this.cinema_address = cinema_address;
    }

    @Override
    public String toString() {
        return "Cinema [cinema_id=" + cinema_id + ", cinema_name=" + cinema_name + ", cinema_address=" + cinema_address
                + "]";
    }

}
