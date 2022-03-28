package com.zbsx.dao.impl;

import com.zbsx.bean.Manager;
import com.zbsx.dao.ManagerDao;
import com.zbsx.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 包名: com.zbsx.dao.impl
 * 类名: ManagerDaoImpl
 * 创建用户: Administrator
 * 创建日期: 2021年07月13日 13:11
 * 项目名: movie
 **/
public class ManagerDaoImpl implements ManagerDao {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private boolean flag;

    /**
     * 方法名称： login<br/>
     * 功能描述: 系统管理员登录 <br/>
     * 方法参数：[name, password] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:24 <br/>
     */
    @Override
    public boolean login(String name, String password) {
        con = DBUtil.getConnection();
        try{
            if(con != null){
                pstm = con.prepareStatement("select * from manager where name = ? and password = ?");
                pstm.setString(1,name);
                pstm.setString(2,password);
                rs = pstm.executeQuery();
                if(rs.next()){
                    flag = true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm,rs);
        }
        return flag;
    }

    /**
     * 方法名称：add <br/>
     * 功能描述: 系统管理员增加 <br/>
     * 方法参数：[manager] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:25 <br/>
     */
    @Override
    public boolean add(Manager manager) {
        con = DBUtil.getConnection();
        try{
            if(con != null){
                pstm = con.prepareStatement("insert into manager (name,password,tel,email,role,memo) values (?,?,?,?,?,?)");
                pstm.setString(1,manager.getName());
                pstm.setString(2,manager.getPassword());
                pstm.setString(3,manager.getTel());
                pstm.setString(4,manager.getEmail());
                pstm.setString(5,manager.getRole());
                pstm.setString(6,manager.getMemo());
                int rs = pstm.executeUpdate();
                if(rs > 0){
                    flag = true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm);
        }
        return flag;
    }

    /**
     * 方法名称：findById <br/>
     * 功能描述: 根据系统管理员账号查询管理员信息 <br/>
     * 方法参数：[name] <br/>
     * 结果返回：com.zbsx.bean.Manager <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:25 <br/>
     */
    @Override
    public Manager findById(String name) {
        con = DBUtil.getConnection();
        Manager manager = null;
        try{
            if(con != null){
                pstm = con.prepareStatement("select * from manager where name = ?");
                pstm.setString(1,name);
                rs = pstm.executeQuery();
                while(rs.next()){
                    manager = new Manager(rs.getString("name"),rs.getString("password"),
                            rs.getString("tel"),rs.getString("email"),rs.getString("role"),rs.getInt("state"),rs.getString("memo"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm,rs);
        }
        return manager;
    }

    /**
     * 方法名称：update <br/>
     * 功能描述: 系统管理员信息修改 <br/>
     * 方法参数：[manager] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:26 <br/>
     */
    @Override
    public boolean update(Manager manager) {
        con = DBUtil.getConnection();
        try{
            if(con != null){
                pstm = con.prepareStatement("update manager set password = ?, tel = ?, email = ?, role=? , state = ?, memo = ? where name = ?");
                pstm.setString(1,manager.getPassword());
                pstm.setString(2,manager.getTel());
                pstm.setString(3,manager.getEmail());
                pstm.setString(4,manager.getRole());
                pstm.setInt(5,manager.getState());
                pstm.setString(6,manager.getMemo());
                pstm.setString(7,manager.getName());
                int rs = pstm.executeUpdate();
                if(rs > 0){
                    flag = true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm);
        }
        return flag;
    }

    /**
     * 方法名称：delete <br/>
     * 功能描述: 系统管理员信息删除 <br/>
     * 方法参数：[name] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:26 <br/>
     */
    @Override
    public boolean delete(String name) {
        con = DBUtil.getConnection();
        try{
            if(con != null){
                pstm = con.prepareStatement("delete from manager where name = ?");
                pstm.setString(1,name);
                int rs = pstm.executeUpdate();
                if(rs > 0){
                    flag = true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm);
        }
        return flag;
    }

    /**
     * 方法名称：findAll <br/>
     * 功能描述: 遍历管理员信息列表 <br/>
     * 方法参数：[] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Manager> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:27 <br/>
     */
    @Override
    public List<Manager> findAll() {
        con = DBUtil.getConnection();
        List<Manager> list = new ArrayList<>();
        try{
            if(con != null){
                pstm = con.prepareStatement("select * from manager");
                rs = pstm.executeQuery();
                while(rs.next()){
                     Manager manager = new Manager(rs.getString("name"),rs.getString("password"),
                            rs.getString("tel"),rs.getString("email"),rs.getString("role"),rs.getInt("state"),rs.getString("memo"));
                     list.add(manager);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm,rs);
        }
        return list;
    }

    /**
     * 方法名称：findManager <br/>
     * 功能描述: 多条件查询用户 <br/>
     * 方法参数：[name, role] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Manager> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/15 16:53 <br/>
     */
    @Override
    public List<Manager> findManager(String name, String role) {
        con = DBUtil.getConnection();
        List<Manager> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from manager where 1 = 1 ");
        if(!"".equals(name)){
            sql.append("and name = '" + name +"'");
        }
        if(!"".equals(role)){
            sql.append("and role = '" + role +"'");
        }
        //System.out.println(sql.toString());
        try{
            if(con != null){
                pstm = con.prepareStatement(sql.toString());
                rs = pstm.executeQuery();
                while(rs.next()){
                    Manager manager = new Manager(rs.getString("name"),rs.getString("password"),
                            rs.getString("tel"),rs.getString("email"),rs.getString("role"),rs.getInt("state"),rs.getString("memo"));
                    list.add(manager);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm,rs);
        }
        return list;
    }

    /**
     * 方法名称：geStateByname <br/>
     * 功能描述: 获取账号状态 <br/>
     * 方法参数：[name] <br/>
     * 结果返回：int <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/15 23:31 <br/>
     */
    @Override
    public int geStateByname(String name) {
        con = DBUtil.getConnection();
        int state = 1;
        try{
            if(con != null){
                pstm = con.prepareStatement("select state from manager where name = ?");
                pstm.setString(1,name);
                rs = pstm.executeQuery();
                while(rs.next()){
                    state = rs.getInt("state");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm,rs);
        }
        return state;
    }

    /**
     * 方法名称：updateState <br/>
     * 功能描述: 更新账号状态 <br/>
     * 方法参数：[name, state] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/15 23:32 <br/>
     */
    @Override
    public boolean updateState(String name, int state) {
        con = DBUtil.getConnection();
        try{
            if(con != null){
                pstm = con.prepareStatement("update manager set state = ? where name = ?");
                pstm.setInt(1,state);
                pstm.setString(2,name);
                int rs = pstm.executeUpdate();
                if(rs > 0){
                    flag = true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm);
        }
        return flag;
    }
}