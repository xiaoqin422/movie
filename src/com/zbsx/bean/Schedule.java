package com.zbsx.bean;

public class Schedule {
    private Integer schedule_id;
    private Integer hall_id;
    private Integer movie_id;
    private String schedule_startTime;
    private Integer schedule_price;
    private Integer schedule_remain;
    private Integer schedule_state;

    @Override
    public String toString() {
        return "Schedule{" +
                "schedule_id=" + schedule_id +
                ", hall_id=" + hall_id +
                ", movie_id=" + movie_id +
                ", schedule_startTime='" + schedule_startTime + '\'' +
                ", schedule_price=" + schedule_price +
                ", schedule_remain=" + schedule_remain +
                ", schedule_state=" + schedule_state +
                '}';
    }

    public Integer getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(Integer schedule_id) {
        this.schedule_id = schedule_id;
    }

    public Integer getHall_id() {
        return hall_id;
    }

    public void setHall_id(Integer hall_id) {
        this.hall_id = hall_id;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public String getSchedule_startTime() {
        return schedule_startTime;
    }

    public void setSchedule_startTime(String schedule_startTime) {
        this.schedule_startTime = schedule_startTime;
    }

    public Integer getSchedule_price() {
        return schedule_price;
    }

    public void setSchedule_price(Integer schedule_price) {
        this.schedule_price = schedule_price;
    }

    public Integer getSchedule_remain() {
        return schedule_remain;
    }

    public void setSchedule_remain(Integer schedule_remain) {
        this.schedule_remain = schedule_remain;
    }

    public Integer getSchedule_state() {
        return schedule_state;
    }

    public void setSchedule_state(Integer schedule_state) {
        this.schedule_state = schedule_state;
    }
}
