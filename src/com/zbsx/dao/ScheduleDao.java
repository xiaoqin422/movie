package com.zbsx.dao;

import com.zbsx.bean.Schedule;
import com.zbsx.dto.Schedule_movie_hall_cinema;

import java.util.List;

public interface ScheduleDao {
    boolean add(Schedule schedule);
    boolean update(Schedule schedule);
    boolean delete(Integer id);
    boolean ban(int id ,int state);
    List<Schedule_movie_hall_cinema> findAll();
    List<Schedule_movie_hall_cinema> findSchedule(String movie_name);
    Schedule findByScheduleId(Integer id);
    List<Schedule_movie_hall_cinema> findScheduleForOrder(int movie_id,String data);
}
