package com.zbsx.dao.impl;

import com.zbsx.bean.Cinema;
import com.zbsx.dao.CinemaDao;
import com.zbsx.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 包名: com.zbsx.dao.impl
 * 类名: CinemaDaoImpl
 * 创建用户: Administrator
 * 创建日期: 2021年07月17日 22:30
 * 项目名: movie
 **/
public class CinemaDaoImpl implements CinemaDao {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    boolean flag;
    /**
     * 方法名称： findAll<br/>
     * 功能描述: 遍历电影院信息 <br/>
     * 方法参数：[] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Cinema> <br/>
     * 创建作者：1913040630崔晓康 <br/>
     * 创建时间: 2021/7/17 22:26 <br/>
     */
    @Override
    public List<Cinema> findAll() {
        conn = DBUtil.getConnection();
        List<Cinema> list = new ArrayList<>();
        String sql ="select * from cinema";
        try {
            pst =conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()) {
                Cinema cinema = new Cinema();
                cinema.setCinema_id(rs.getInt("cinema_id"));
                cinema.setCinema_name(rs.getString("cinema_name"));
                cinema.setCinema_address(rs.getString("cinema_address"));
                list.add(cinema);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, pst,rs );
        }
        return list;
    }
    /**
     * 方法名称：add <br/>
     * 功能描述: 电影院添加 <br/>
     * 方法参数：[cinema] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040630崔晓康 <br/>
     * 创建时间: 2021/7/17 22:27 <br/>
     */
    @Override
    public boolean add(Cinema cinema) {
        conn = DBUtil.getConnection();
        String sql ="insert into cinema values(null,?,?)";
        try {
            pst =conn.prepareStatement(sql);
            pst.setString(1,cinema.getCinema_name());
            pst.setString(2,cinema.getCinema_address());
            int row = pst.executeUpdate();
            if(row>0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, pst, rs);
        }
        return false;
    }
    /**
     * 方法名称：delete <br/>
     * 功能描述: 电影院删除 <br/>
     * 方法参数：[cinema_id] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040630崔晓康 <br/>
     * 创建时间: 2021/7/17 22:27 <br/>
     */
    @Override
    public boolean delete(int cinema_id) {
        conn = DBUtil.getConnection();
        String sql ="delete from cinema where cinema_id = ?";
        try {
            pst =conn.prepareStatement(sql);
            pst.setInt(1,cinema_id);
            int row = pst.executeUpdate();
            if(row>0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, pst,rs );
        }
        return false;
    }
    /**
     * 方法名称：update <br/>
     * 功能描述: 电影院修改 <br/>
     * 方法参数：[cinema] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040630崔晓康 <br/>
     * 创建时间: 2021/7/17 22:27 <br/>
     */
    @Override
    public boolean update(Cinema cinema) {
        conn = DBUtil.getConnection();
        String sql ="update cinema set cinema_name=?,cinema_address=?where cinema_id=?";
        try {
            pst =conn.prepareStatement(sql);
            pst.setString(1,cinema.getCinema_name());
            pst.setString(2,cinema.getCinema_address());
            pst.setInt(3,cinema.getCinema_id());
            int row = pst.executeUpdate();
            if(row>0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, pst,rs );
        }
        return false;
    }

    /**
     * 方法名称： <br/>
     * 功能描述: 电影院查询--name <br/>
     * 方法参数：[cinema_name] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040630崔晓康 <br/>
     * 创建时间: 2021/7/20 22:51 <br/>
     *
     * @param cinema_name
     */
    @Override
    public boolean findByName(String cinema_name) {
        conn = DBUtil.getConnection();
        String sql ="select * from cinema where cinema_name = ?";
        try {
            pst =conn.prepareStatement(sql);
            pst.setString(1,cinema_name);
            rs = pst.executeQuery();
            if(rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, pst,rs );
        }
        return flag;
    }

    /**
     * 方法名称：findCinema <br/>
     * 功能描述: 电影院查询--name <br/>
     * 方法参数：[cinema_name] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Cinema> <br/>
     * 创建作者：1913040630崔晓康 <br/>
     * 创建时间: 2021/7/17 22:28 <br/>
     */
    @Override
    public List<Cinema> findCinema(String cinema_name) {
        conn = DBUtil.getConnection();
        List<Cinema> list = new ArrayList<>();
        String sql ="select * from cinema where cinema_name = ?";
        try {
            pst =conn.prepareStatement(sql);
            pst.setString(1,cinema_name);
            rs = pst.executeQuery();
            while(rs.next()) {
                Cinema cinema = new Cinema();
                cinema.setCinema_id(rs.getInt("cinema_id"));
                cinema.setCinema_name(rs.getString("cinema_name"));
                cinema.setCinema_address(rs.getString("cinema_address"));
                list.add(cinema);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, pst, rs);
        }
        return list;
    }

}
