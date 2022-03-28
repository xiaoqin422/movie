package com.zbsx.dao;

import com.zbsx.bean.User;

import java.util.List;

/**
 * 包名: com.zbsx.dao
 * 类名: UserDao
 * 创建用户: Administrator
 * 创建日期: 2021年07月13日 14:09
 * 项目名: movie
 **/
public interface UserDao {
    /**
     * 方法名称： findAll<br/>
     * 功能描述: 遍历用户信息 <br/>
     * 方法参数：[] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.User> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:37 <br/>
     */
    List<User> findAll();
    /**
     * 方法名称：findByName <br/>
     * 功能描述: 通过用户名查找用户 <br/>
     * 方法参数：[user_name] <br/>
     * 结果返回：com.zbsx.bean.User <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:37 <br/>
     */
    User findByName(String user_name);
    /**
     * 方法名称：login <br/>
     * 功能描述: 用户登录 <br/>
     * 方法参数：[user_name, user_pwd] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:38 <br/>
     */
    boolean login(String user_name,String user_pwd);
    /**
     * 方法名称：add <br/>
     * 功能描述: 用户添加 <br/>
     * 方法参数：[user] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:38 <br/>
     */
    boolean add(User user);
    /**
     * 方法名称：update <br/>
     * 功能描述: 用户修改 <br/>
     * 方法参数：[user] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:38 <br/>
     */
    boolean update(User user);
    /**
     * 方法名称：delete <br/>
     * 功能描述: 用户删除 <br/>
     * 方法参数：[user_name] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:38 <br/>
     */
    boolean delete(String user_name);
    /**
     * 方法名称：updateState<br/>
     * 功能描述: 账号冻结/解冻 <br/>
     * 方法参数：[user_name, state] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:38 <br/>
     */
    boolean updateState(String user_name,int state);
    /**
     * 方法名称：updateRole <br/>
     * 功能描述: 修改用户角色 <br/>
     * 方法参数：[user_name, role] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:39 <br/>
     */
    boolean updateRole(String user_name,int role);
    /**
     * 方法名称：findUser <br/>
     * 功能描述: 用户信息查找 <br/>
     * 方法参数：[user_name, role] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.User> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 1:26 <br/>
     */
    List<User> findUser(String user_name ,int role);
}
