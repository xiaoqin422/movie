package com.zbsx.dao.impl;

import com.zbsx.bean.OrderInfo;
import com.zbsx.dao.BookDao;
import com.zbsx.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    private boolean flag;

    @Override
    public boolean add(OrderInfo info) {
        conn = DBUtil.getConnection();
        String sql ="INSERT INTO orderinfo(order_id,user_id,schedule_id,order_position,order_state,order_price,order_time) VALUES (?,?,?,?,?,?,?)";
        try {
            assert conn != null;
            pst =conn.prepareStatement(sql);
            pst.setString(1,info.getOrder_id());
            pst.setInt(2,info.getUser_id());
            pst.setInt(3,info.getSchedule_id());
            pst.setString(4,info.getOrder_position());
            pst.setInt(5,info.getOrder_state());
            pst.setInt(6,info.getOrder_price());
            pst.setString(7,info.getOrder_time());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, pst);
        }
        return true;
    }
    @Override
    public boolean delete(String order_id) {
        conn = DBUtil.getConnection();
        String sql="DELETE FROM orderinfo WHERE order_id=?";
        try {
            assert conn != null;
            pst = conn.prepareStatement(sql);
            pst.setString(1,order_id);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(conn,pst);
        }
        return false;
    }

    @Override
    public OrderInfo findByOrderId(String order_id) {
        conn = DBUtil.getConnection();
        String sql="SELECT * FROM orderinfo WHERE order_id=?";
        try {
            assert conn != null;
            pst = conn.prepareStatement(sql);
            pst.setString(1,order_id);
            rs = pst.executeQuery();
            if (rs.next()){
                OrderInfo info = new OrderInfo();
                info.setOrder_id(rs.getString("order_id"));
                info.setSchedule_id(rs.getInt("schedule_id"));
                info.setUser_id(rs.getInt("user_id"));
                info.setOrder_position(rs.getString("order_position"));
                info.setOrder_price(Integer.parseInt(rs.getString("order_price")));
                info.setOrder_time(rs.getString("order_time"));
                info.setOrder_state(Integer.parseInt(rs.getString("order_state")));
                return info;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(conn,pst);
        }
        return null;
    }

    @Override
    public List<OrderInfo> findAll() {
        conn = DBUtil.getConnection();
        List<OrderInfo> list = new ArrayList<>();
        String sql="SELECT * FROM orderinfo";
        try {
            assert conn != null;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                OrderInfo info = new OrderInfo();
                info.setOrder_id(rs.getString("order_id"));
                info.setSchedule_id(rs.getInt("schedule_id"));
                info.setUser_id(rs.getInt("user_id"));
                info.setOrder_position(rs.getString("order_position"));
                info.setOrder_price(Integer.parseInt(rs.getString("order_price")));
                info.setOrder_time(rs.getString("order_time"));
                info.setOrder_state(Integer.parseInt(rs.getString("order_state")));
                list.add(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(conn,pst,rs);
        }
        return list;
    }
}
