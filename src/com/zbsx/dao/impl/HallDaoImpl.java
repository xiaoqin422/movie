package com.zbsx.dao.impl;

import com.zbsx.bean.Hall;
import com.zbsx.dao.HallDao;
import com.zbsx.dto.Hall_Cinema_DTO;
import com.zbsx.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 包名: com.zbsx.dao.impl
 * 类名: HallDaoImpl
 * 创建用户: Administrator
 * 创建日期: 2021年07月17日 20:48
 * 项目名: movie
 **/
public class HallDaoImpl implements HallDao {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private boolean flag;

    /**
     * 方法名称： findAll<br/>
     * 功能描述: 影厅信息遍历 <br/>
     * 方法参数：[] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Hall> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 20:46 <br/>
     */
    @Override
    public List<Hall_Cinema_DTO> findAll() {
        con = DBUtil.getConnection();
        List<Hall_Cinema_DTO> list = new ArrayList<>();
        try {
            if (con != null) {
                pstm = con.prepareStatement("select * from hall_cinema");
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Hall_Cinema_DTO hall = new Hall_Cinema_DTO(rs.getInt("hall_id"),
                            rs.getString("hall_name"), rs.getInt("hall_capacity"),
                            rs.getInt("cid"), rs.getString("cinema_name"),
                            rs.getString("cinema_address"));
                    list.add(hall);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, pstm, rs);
        }
        return list;
    }

    /**
     * 方法名称： findById<br/>
     * 功能描述: 影厅查找-id <br/>
     * 方法参数：[hall_id] <br/>
     * 结果返回：com.zbsx.bean.Hall <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 20:46 <br/>
     *
     * @param hall_id
     */
    @Override
    public Hall findById(int hall_id) {
        con = DBUtil.getConnection();
        Hall hall = new Hall();
        try {
            if (con != null) {
                pstm = con.prepareStatement("select * from hall where hall_id = ?");
                pstm.setInt(1, hall_id);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    hall.setHall_id(rs.getInt("hall_id"));
                    hall.setHall_name(rs.getString("hall_name"));
                    hall.setCinema_id(rs.getInt("cinema_id"));
                    hall.setHall_capacity(rs.getInt("hall_capacity"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, pstm, rs);
        }
        return hall;
    }

    /**
     * 方法名称： findHall<br/>
     * 功能描述: 影厅查找-多条件 <br/>
     * 方法参数：[hall_name, cinema_name] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Hall> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 20:46 <br/>
     *
     * @param hall_name
     * @param cinema_name
     */
    @Override
    public List<Hall_Cinema_DTO> findHall(String hall_name, String cinema_name) {
        con = DBUtil.getConnection();
        List<Hall_Cinema_DTO> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from hall_cinema where 1 = 1 ");
        if (!"".equals(hall_name)) {
            sql.append("and hall_name = '" + hall_name + "'");
        }
        if (!"".equals(cinema_name)) {
            sql.append("and cinema_name = '" + cinema_name + "'");
        }
        //System.out.println(sql.toString());
        try {
            if (con != null) {
                pstm = con.prepareStatement(sql.toString());
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Hall_Cinema_DTO hall = new Hall_Cinema_DTO(rs.getInt("hall_id"),
                            rs.getString("hall_name"), rs.getInt("hall_capacity"),
                            rs.getInt("cid"), rs.getString("cinema_name"),
                            rs.getString("cinema_address"));
                    list.add(hall);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, pstm, rs);
        }
        return list;
    }

    /**
     * 方法名称：findHallByCinema_ID <br/>
     * 功能描述: 影厅添加查重 <br/>
     * 方法参数：[hall_name, cinema_id] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/21 14:38 <br/>
     *
     * @param hall_name
     * @param cinema_id
     */
    @Override
    public boolean findHallByCinema_ID(String hall_name, int cinema_id) {
        con = DBUtil.getConnection();
        try {
            if (con != null) {
                pstm = con.prepareStatement("select * from hall_cinema where hall_name = ? and cid = ?");
                pstm.setString(1, hall_name);
                pstm.setInt(2, cinema_id);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, pstm, rs);
        }
        return flag;
    }

    /**
     * 方法名称： delete<br/>
     * 功能描述: 影厅删除 <br/>
     * 方法参数：[hall_id] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 20:46 <br/>
     *
     * @param hall_id
     */
    @Override
    public boolean delete(int hall_id) {
        con = DBUtil.getConnection();
        try {
            if (con != null) {
                pstm = con.prepareStatement("delete from hall where hall_id = ?");
                pstm.setInt(1, hall_id);
                int rs = pstm.executeUpdate();
                if (rs > 0) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, pstm);
        }
        return flag;
    }

    /**
     * 方法名称： update<br/>
     * 功能描述: 影厅修改 <br/>
     * 方法参数：[hall] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 20:46 <br/>
     *
     * @param hall
     */
    @Override
    public boolean update(Hall hall) {
        con = DBUtil.getConnection();
        try {
            if (con != null) {
                pstm = con.prepareStatement("update hall set hall_name = ? , hall_capacity = ?,cinema_id = ? where hall_id = ?");
                pstm.setString(1, hall.getHall_name());
                pstm.setInt(2, hall.getHall_capacity());
                pstm.setInt(3, hall.getCinema_id());
                pstm.setInt(4, hall.getHall_id());
                int rs = pstm.executeUpdate();
                if (rs > 0) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, pstm);
        }
        return flag;
    }

    /**
     * 方法名称： add<br/>
     * 功能描述: 影厅增加 <br/>
     * 方法参数：[hall] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 20:46 <br/>
     *
     * @param hall
     */
    @Override
    public boolean add(Hall hall) {
        con = DBUtil.getConnection();
        try {
            if (con != null) {
                pstm = con.prepareStatement("insert into hall ( hall_name, hall_capacity, cinema_id) values (?,?,?)");
                pstm.setString(1, hall.getHall_name());
                pstm.setInt(2, hall.getHall_capacity());
                pstm.setInt(3, hall.getCinema_id());
                int rs = pstm.executeUpdate();
                if (rs > 0) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, pstm);
        }
        return flag;
    }

    /**
     * 方法名称：findByCinema_id <br/>
     * 功能描述: 通过影院id查影厅信息 <br/>
     * 方法参数：[cinema_id] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Hall> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/21 20:34 <br/>
     *
     * @param cinema_id
     */
    @Override
    public List<Hall> findByCinema_id(int cinema_id) {
        con = DBUtil.getConnection();
        List<Hall> list = new ArrayList<>();
        try {
            if (con != null) {
                pstm = con.prepareStatement("select * from hall where cinema_id = ?");
                pstm.setInt(1, cinema_id);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    Hall hall = new Hall(rs.getInt("hall_id"),
                            rs.getString("hall_name"), rs.getInt("hall_capacity"),
                            rs.getInt("cinema_id"));
                    list.add(hall);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, pstm, rs);
        }
        return list;
    }
}