package com.zbsx.dao.impl;

import com.zbsx.bean.Schedule;
import com.zbsx.dao.ScheduleDao;
import com.zbsx.dto.Schedule_movie_hall_cinema;
import com.zbsx.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Schedule.
 */
public class ScheduleImpl implements ScheduleDao {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    /**
     * The List.
     */
    List<Schedule_movie_hall_cinema> list = new ArrayList<>();

    @Override
    public boolean add(Schedule schedule) {
        conn = DBUtil.getConnection();
        String sql = "INSERT INTO schedule(hall_id,movie_id,schedule_startTime,schedule_price,schedule_remain,schedule_state) VALUES (?,?,?,?,?,?)";
        try {
            assert conn != null;
            pst = conn.prepareStatement(sql);
            pst.setInt(1, schedule.getHall_id());
            pst.setInt(2, schedule.getMovie_id());
            pst.setString(3, schedule.getSchedule_startTime());
            pst.setInt(4, schedule.getSchedule_price());
            pst.setInt(5, schedule.getSchedule_remain());
            pst.setInt(6, schedule.getSchedule_state());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pst, rs);
        }
        return true;
    }

    @Override
    public boolean update(Schedule schedule) {
        conn = DBUtil.getConnection();
        String sql = "UPDATE schedule SET hall_id=?,movie_id=?,schedule_startTime=?,schedule_price=?,schedule_remain=?,schedule_state=? WHERE schedule_id=?";
        try {
            assert conn != null;
            pst = conn.prepareStatement(sql);
            pst.setInt(1, schedule.getHall_id());
            pst.setInt(2, schedule.getMovie_id());
            pst.setString(3, schedule.getSchedule_startTime());
            pst.setInt(4, schedule.getSchedule_price());
            pst.setInt(5, schedule.getSchedule_remain());
            pst.setInt(6, schedule.getSchedule_state());
            pst.setInt(7, schedule.getSchedule_id());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pst, rs);
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        conn = DBUtil.getConnection();
        String sql = "DELETE FROM schedule WHERE schedule_id=?";
        try {
            assert conn != null;
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pst, rs);
        }
        return false;
    }

    @Override
    public boolean ban(int id ,int state) {
        conn = DBUtil.getConnection();
        String sql = "UPDATE schedule SET schedule_state=? WHERE schedule_id=?";
        try {
            assert conn != null;
            pst = conn.prepareStatement(sql);
            pst.setInt(1, state);
            pst.setInt(2, id);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pst, rs);
        }
        return false;
    }

    @Override
    public List<Schedule_movie_hall_cinema> findAll() {
        conn = DBUtil.getConnection();
        String sql = "SELECT * FROM schedule_movie_hall_cinema";
        try {
            assert conn != null;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Schedule_movie_hall_cinema schedule = new Schedule_movie_hall_cinema(
                        rs.getInt("schedule_id"), rs.getInt("hall_id"), rs.getInt("movie_id")
                        , rs.getString("schedule_startTime"), rs.getInt("schedule_price")
                        , rs.getInt("schedule_remain")
                        , rs.getInt("schedule_state")
                        , rs.getString("hall_name"),
                        rs.getString("movie_cn_name"), rs.getString("cinema_name"));
                list.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pst, rs);
        }
        return list;
    }

    @Override
    public List<Schedule_movie_hall_cinema> findSchedule(String movie_name) {
        conn = DBUtil.getConnection();
        String sql = "SELECT * FROM schedule_movie_hall_cinema WHERE movie_name = ?";
        try {
            assert conn != null;
            pst = conn.prepareStatement(sql);
            pst.setString(1,movie_name);
            rs = pst.executeQuery();
            while (rs.next()) {
                Schedule_movie_hall_cinema schedule = new Schedule_movie_hall_cinema(
                        rs.getInt("schedule_id"), rs.getInt("hall_id"), rs.getInt("movie_id")
                        , rs.getString("schedule_startTime"), rs.getInt("schedule_price")
                        , rs.getInt("schedule_remain")
                        , rs.getInt("schedule_state")
                        , rs.getString("hall_name"),
                        rs.getString("movie_cn_name"), rs.getString("cinema_name"));
                list.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pst, rs);
        }
        return list;
    }

    @Override
    public Schedule findByScheduleId(Integer id) {
        conn = DBUtil.getConnection();
        String sql = "SELECT * FROM schedule WHERE schedule_id=?";
        try {
            assert conn != null;
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setSchedule_id(rs.getInt("schedule_id"));
                schedule.setSchedule_price(rs.getInt("schedule_price"));
                schedule.setSchedule_remain(rs.getInt("schedule_remain"));
                schedule.setSchedule_state(rs.getInt("schedule_state"));
                schedule.setSchedule_startTime(rs.getString("schedule_startTime"));
                schedule.setHall_id(rs.getInt("hall_id"));
                schedule.setMovie_id(rs.getInt("movie_id"));
                return schedule;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pst);
        }
        return null;
    }

    @Override
    public List<Schedule_movie_hall_cinema> findScheduleForOrder(int movie_id, String data) {
        conn = DBUtil.getConnection();
        String sql = "SELECT * FROM schedule_movie_hall_cinema WHERE movie_id = ? and DATEDIFF(schedule_startTime, NOW()) = ?";
        try {
            assert conn != null;
            pst = conn.prepareStatement(sql);
            pst.setInt(1,movie_id);
            pst.setString(2,data);
            rs = pst.executeQuery();
            while (rs.next()) {
                Schedule_movie_hall_cinema schedule = new Schedule_movie_hall_cinema(
                        rs.getInt("schedule_id"), rs.getInt("hall_id"), rs.getInt("movie_id")
                        , rs.getString("schedule_startTime"), rs.getInt("schedule_price")
                        , rs.getInt("schedule_remain")
                        , rs.getInt("schedule_state")
                        , rs.getString("hall_name"),
                        rs.getString("movie_cn_name"), rs.getString("cinema_name"));
                list.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pst, rs);
        }
        return list;
    }
}
