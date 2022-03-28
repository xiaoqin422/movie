package com.zbsx.bean;

public class Hall {
    private int hall_id;
    private String hall_name;
    private int hall_capacity;
    private int cinema_id;
	 /**
	  * 方法名称：Hall <br/>
	  * 功能描述: 影厅的无参构造函数 <br/>
	  * 方法参数：[] <br/>
	  * 结果返回： <br/>
	  * 创建作者：1913040630崔晓康 <br/>
	  * 创建时间: 2021/7/18 0:25 <br/>
	  */
    public Hall() {
        super();
    }
	/**
	 * 方法名称： Hall<br/>
	 * 功能描述: 影厅的有参构造函数 <br/>
	 * 方法参数：[hall_id, hall_name, hall_capacity, cinema_id] <br/>
	 * 结果返回： <br/>
	 * 创建作者：1913040630崔晓康 <br/>
	 * 创建时间: 2021/7/18 0:26 <br/>
	 */
    public Hall(int hall_id, String hall_name, int hall_capacity, int cinema_id) {
        super();
        this.hall_id = hall_id;
        this.hall_name = hall_name;
        this.hall_capacity = hall_capacity;
        this.cinema_id = cinema_id;
    }

    public int getHall_id() {
        return hall_id;
    }

    public void setHall_id(int hall_id) {
        this.hall_id = hall_id;
    }

    public String getHall_name() {
        return hall_name;
    }

    public void setHall_name(String hall_name) {
        this.hall_name = hall_name;
    }

    public int getHall_capacity() {
        return hall_capacity;
    }

    public void setHall_capacity(int hall_capacity) {
        this.hall_capacity = hall_capacity;
    }

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    @Override
    public String toString() {
        return "Hall [hall_id=" + hall_id + ", hall_name=" + hall_name + ", hall_capacity=" + hall_capacity
                + ", cinema_id=" + cinema_id + "]";
    }


}
