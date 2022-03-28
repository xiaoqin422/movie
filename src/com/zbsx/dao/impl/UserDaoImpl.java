package com.zbsx.dao.impl;

import com.zbsx.bean.User;
import com.zbsx.dao.UserDao;
import com.zbsx.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 包名: com.zbsx.dao.impl
 * 类名: UserDaoImpl
 * 创建用户: Administrator
 * 创建日期: 2021年07月17日 0:43
 * 项目名: movie
 **/
public class UserDaoImpl implements UserDao {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private boolean flag;

    /**
     * 方法名称： findAll<br/>
     * 功能描述: 遍历用户信息 <br/>
     * 方法参数：[] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.User> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:37 <br/>
     */
    @Override
    public List<User> findAll() {
        con = DBUtil.getConnection();
        List<User> list = new ArrayList<>();
        try{
            if(con != null){
                pstm = con.prepareStatement("select * from user ");
                rs = pstm.executeQuery();
                while(rs.next()){
                    User user = new User(rs.getInt("user_id"),rs.getString("user_name"),
                            rs.getString("user_pwd"),rs.getString("user_tel"),
                            rs.getString("user_email"),rs.getInt("user_role"),
                            rs.getString("user_headImg"),rs.getInt("user_state"));
                    list.add(user);
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
     * 方法名称：findByName <br/>
     * 功能描述: 通过用户名查找用户 <br/>
     * 方法参数：[user_name] <br/>
     * 结果返回：com.zbsx.bean.User <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:37 <br/>
     *
     * @param user_name
     */
    @Override
    public User findByName(String user_name) {
        con = DBUtil.getConnection();
        User user = null;
        try{
            if(con != null){
                pstm = con.prepareStatement("select * from user where user_name = ?");
                pstm.setString(1,user_name);
                rs = pstm.executeQuery();
                while(rs.next()){
                    user = new User(rs.getInt("user_id"),rs.getString("user_name"),
                            rs.getString("user_pwd"),rs.getString("user_tel"),
                            rs.getString("user_email"),rs.getInt("user_role"),
                            rs.getString("user_headImg"),rs.getInt("user_state"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm,rs);
        }
        return user;
    }

    /**
     * 方法名称：login <br/>
     * 功能描述: 用户登录 <br/>
     * 方法参数：[user_name, user_pwd] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:38 <br/>
     *
     * @param user_name
     * @param user_pwd
     */
    @Override
    public boolean login(String user_name, String user_pwd) {
        con = DBUtil.getConnection();
        try{
            if(con != null){
                pstm = con.prepareStatement("select * from user where user_name = ? and user_pwd = ?");
                pstm.setString(1,user_name);
                pstm.setString(2,user_pwd);
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
     * 功能描述: 用户添加 <br/>
     * 方法参数：[user] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:38 <br/>
     *
     * @param user
     */
    @Override
    public boolean add(User user) {
        con = DBUtil.getConnection();
        try{
            if(con != null){
                pstm = con.prepareStatement("insert into user (user_name, user_pwd, user_tel, user_email, user_role, user_headImg , user_state) values (?,?,?,?,?,?,?)");
                pstm.setString(1,user.getUser_name());
                pstm.setString(2,user.getUser_pwd());
                pstm.setString(3,user.getUser_tel());
                pstm.setString(4,user.getUser_email());
                pstm.setInt(5,user.getUser_role());
                pstm.setString(6,user.getUser_headimg());
                pstm.setInt(7,user.getUser_state());
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
     * 方法名称：update <br/>
     * 功能描述: 用户修改 <br/>
     * 方法参数：[user] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:38 <br/>
     *
     * @param user
     */
    @Override
    public boolean update(User user) {
        con = DBUtil.getConnection();
        try{
            if(con != null){
                pstm = con.prepareStatement("UPDATE user set  user_pwd = ?, user_tel = ?, user_email = ?,user_headImg = ? where user_name = ?");
                pstm.setString(1,user.getUser_pwd());
                pstm.setString(2,user.getUser_tel());
                pstm.setString(3,user.getUser_email());
                pstm.setString(4,user.getUser_headimg());
                pstm.setString(5,user.getUser_name());
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
     * 功能描述: 用户删除 <br/>
     * 方法参数：[user_name] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:38 <br/>
     *
     * @param user_name
     */
    @Override
    public boolean delete(String user_name) {
        con = DBUtil.getConnection();
        try{
            if(con != null){
                pstm = con.prepareStatement("DELETE  From user where user_name = ?");
                pstm.setString(1,user_name);
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
     * 方法名称：updateState<br/>
     * 功能描述: 账号冻结/解冻 <br/>
     * 方法参数：[user_name, state] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:38 <br/>
     *
     * @param user_name
     * @param state
     */
    @Override
    public boolean updateState(String user_name, int state) {
        con = DBUtil.getConnection();
        try{
            if(con != null){
                pstm = con.prepareStatement("UPDATE user set  user_state = ? where user_name = ?");
                pstm.setInt(1,state);
                pstm.setString(2,user_name);
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
     * 方法名称：updateRole <br/>
     * 功能描述: 修改用户角色 <br/>
     * 方法参数：[user_name, role] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:39 <br/>
     *
     * @param user_name
     * @param role
     */
    @Override
    public boolean updateRole(String user_name, int role) {
        con = DBUtil.getConnection();
        try{
            if(con != null){
                pstm = con.prepareStatement("UPDATE user set  user_role = ? where user_name = ?");
                pstm.setInt(1,role);
                pstm.setString(2,user_name);
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
     * 方法名称：findUser <br/>
     * 功能描述: 用户信息查找 <br/>
     * 方法参数：[user_name, role] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.User> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 1:26 <br/>
     *
     * @param user_name
     * @param role
     */
    @Override
    public List<User> findUser(String user_name, int role) {
        con = DBUtil.getConnection();
        List<User> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from user where 1 = 1 ");
        if(!"".equals(user_name)){
            sql.append("and user_name = '" + user_name +"'");
        }
        if(role != -1){
            sql.append("and user_role = '" + role +"'");
        }
        try{
            if(con != null){
                pstm = con.prepareStatement(sql.toString());
                rs = pstm.executeQuery();
                while(rs.next()){
                   User user = new User(rs.getInt("user_id"),rs.getString("user_name"),
                            rs.getString("user_pwd"),rs.getString("user_tel"),
                            rs.getString("user_email"),rs.getInt("user_role"),
                            rs.getString("user_headImg"),rs.getInt("user_state"));
                   list.add(user);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(con,pstm,rs);
        }
        return list;
    }
}