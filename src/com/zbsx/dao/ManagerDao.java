package com.zbsx.dao;

import com.zbsx.bean.Manager;

import java.util.List;

/**
 * 包名: com.zbsx.dao
 * 类名: ManagerDao
 * 创建用户: Administrator
 * 创建日期: 2021年07月13日 13:10
 * 项目名: movie
 **/
public interface ManagerDao {

    /**
     * 方法名称： login<br/>
     * 功能描述: 系统管理员登录 <br/>
     * 方法参数：[name, password] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:24 <br/>
     */
    boolean login(String name, String password);
    /**
     * 方法名称：add <br/>
     * 功能描述: 系统管理员增加 <br/>
     * 方法参数：[manager] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:25 <br/>
     */
    boolean add(Manager manager);
    /**
     * 方法名称：findById <br/>
     * 功能描述: 根据系统管理员账号查询管理员信息 <br/>
     * 方法参数：[name] <br/>
     * 结果返回：com.zbsx.bean.Manager <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:25 <br/>
     */
    Manager findById(String name);
    /**
     * 方法名称：update <br/>
     * 功能描述: 系统管理员信息修改 <br/>
     * 方法参数：[manager] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:26 <br/>
     */
    boolean update(Manager manager);
    /**
     * 方法名称：delete <br/>
     * 功能描述: 系统管理员信息删除 <br/>
     * 方法参数：[name] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:26 <br/>
     */
    boolean delete(String username);
    /**
     * 方法名称：findAll <br/>
     * 功能描述: 遍历管理员信息列表 <br/>
     * 方法参数：[] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Manager> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:27 <br/>
     */
    List<Manager> findAll();
    /**
     * 方法名称：findManager <br/>
     * 功能描述: 多条件查询用户 <br/>
     * 方法参数：[name, role] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Manager> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/15 16:53 <br/>
     */
    List<Manager> findManager(String name, String role);
    /**
     * 方法名称：geStateByname <br/>
     * 功能描述: 获取账号状态 <br/>
     * 方法参数：[name] <br/>
     * 结果返回：int <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/15 23:31 <br/>
     */
    int geStateByname(String name);
    /**
     * 方法名称：updateState <br/>
     * 功能描述: 更新账号状态 <br/>
     * 方法参数：[name, state] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/15 23:32 <br/>
     */
    boolean updateState(String name,int state);
}
