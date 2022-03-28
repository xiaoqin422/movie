package com.zbsx.bean;

public class OrderInfo {
    private String order_id;
    private Integer user_id;
    private Integer schedule_id;
    private String order_position;
    private Integer order_state;
    private Integer order_price;
    private String order_time;

    public OrderInfo() {
    }

    public OrderInfo(String order_id, Integer user_id, Integer schedule_id, String order_position, Integer order_state, Integer order_price, String order_time) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.schedule_id = schedule_id;
        this.order_position = order_position;
        this.order_state = order_state;
        this.order_price = order_price;
        this.order_time = order_time;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", schedule_id=" + schedule_id +
                ", order_position='" + order_position + '\'' +
                ", order_state=" + order_state +
                ", order_price=" + order_price +
                ", order_time='" + order_time + '\'' +
                '}';
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(Integer schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getOrder_position() {
        return order_position;
    }

    public void setOrder_position(String order_position) {
        this.order_position = order_position;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public Integer getOrder_state() {
        return order_state;
    }

    public void setOrder_state(Integer order_state) {
        this.order_state = order_state;
    }

    public Integer getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Integer order_price) {
        this.order_price = order_price;
    }
}


