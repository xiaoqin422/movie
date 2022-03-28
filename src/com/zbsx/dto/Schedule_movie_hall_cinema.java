package com.zbsx.dto;


public class Schedule_movie_hall_cinema {
    private int schedule_id;
    private int hall_id;
    private int movie_id;
    private String schedule_startTime;
    private int schedule_price;
    private int schedule_remain;
    private int schedule_state;
    private String hall_name;
    private String movie_cn_name;
    private String cinema_name;


    public Schedule_movie_hall_cinema() {

    }

    public Schedule_movie_hall_cinema(int schedule_id, int hall_id, int movie_id, String schedule_startTime, int schedule_price, int schedule_remain, int schedule_state, String hall_name, String movie_cn_name, String cinema_name) {
        this.schedule_id = schedule_id;
        this.hall_id = hall_id;
        this.movie_id = movie_id;
        this.schedule_startTime = schedule_startTime;
        this.schedule_price = schedule_price;
        this.schedule_remain = schedule_remain;
        this.schedule_state = schedule_state;
        this.hall_name = hall_name;
        this.movie_cn_name = movie_cn_name;
        this.cinema_name = cinema_name;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public int getHall_id() {
        return hall_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public String getSchedule_startTime() {
        return schedule_startTime;
    }

    public int getSchedule_price() {
        return schedule_price;
    }

    public int getSchedule_remain() {
        return schedule_remain;
    }

    public int getSchedule_state() {
        return schedule_state;
    }

    public String getHall_name() {
        return hall_name;
    }

    public String getMovie_cn_name() {
        return movie_cn_name;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    @Override
    public String toString() {
        return "Schedule_movie_hall_cinema{" +
                "schedule_id=" + schedule_id +
                ", hall_id=" + hall_id +
                ", movie_id=" + movie_id +
                ", schedule_startTime='" + schedule_startTime + '\'' +
                ", schedule_price=" + schedule_price +
                ", schedule_remain=" + schedule_remain +
                ", schedule_state=" + schedule_state +
                ", hall_name='" + hall_name + '\'' +
                ", movie_cn_name='" + movie_cn_name + '\'' +
                ", cinema_name='" + cinema_name + '\'' +
                '}';
    }
}