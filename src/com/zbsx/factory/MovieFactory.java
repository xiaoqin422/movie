package com.zbsx.factory;

import com.zbsx.dao.*;
import com.zbsx.dao.impl.*;

/**
 * 包名: com.zbsx.factory
 * 类名: MovieFactory
 * 创建用户: Administrator
 * 创建日期: 2021年07月13日 13:47
 * 项目名: movie
 *
 * @author Administrator*/
public class MovieFactory {
    /**
     * 方法名称：getManagerInstance <br/>
     * 功能描述: 工厂模式-获取系统管理员操作对象 <br/>
     * 方法参数：[] <br/>
     * 结果返回：com.zbsx.dao.ManagerDao <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:54 <br/>
     */
    public static ManagerDao getManagerInstance(){
        return new ManagerDaoImpl();
    }
    /**
     * 方法名称：getMovieInstance <br/>
     * 功能描述: 工厂模式-获取电影院操作对象 <br/>
     * 方法参数：[] <br/>
     * 结果返回：com.zbsx.dao.MovieDao <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/16 23:39 <br/>
     */
    public static MovieDao getMovieInstance(){
        return new MovieDaoImpl();
    }
    /**
     * 方法名称：getUserInstance <br/>
     * 功能描述: 工厂模式-获取用户操作对象 <br/>
     * 方法参数：[] <br/>
     * 结果返回：com.zbsx.dao.UserDao <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 0:44 <br/>
     */
    public static UserDao getUserInstance(){
        return new UserDaoImpl();
    }
    /**
     * 方法名称：getHallInstance <br/>
     * 功能描述:  工厂模式-获取影厅操作对象<br/>
     * 方法参数：[] <br/>
     * 结果返回：com.zbsx.dao.HallDao <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 21:12 <br/>
     */
    public static HallDao getHallInstance(){
        return new HallDaoImpl();
    }
    /**
     * 方法名称：getCinemaInstance <br/>
     * 功能描述: 工厂模式-获取电影院操作对象 <br/>
     * 方法参数：[] <br/>
     * 结果返回：com.zbsx.dao.CinemaDao <br/>
     * 创建作者：1913040630崔晓康 <br/>
     * 创建时间: 2021/7/17 22:36 <br/>
     */
    public static CinemaDao getCinemaInstance(){
        return  new CinemaDaoImpl();
    }

    /**
     * 方法名称：getScheduleInstance <br/>
     * 功能描述: 工厂模式-获取场次操作对象 <br/>
     * 方法参数：[] <br/>
     * 结果返回：com.zbsx.dao.ScheduleDao <br/>
     * 创建作者：1913040615马泽华 <br/>
     * 创建时间: 2021/7/21 17:37 <br/>
     */
    public static ScheduleDao getScheduleInstance() {
        return new ScheduleImpl();
    }
    /**
     * 方法名称：getBookInstance <br/>
     * 功能描述: 工厂模式-获取订票操作对象 <br/>
     * 方法参数：[] <br/>
     * 结果返回：com.zbsx.dao.BookDao <br/>
     * 创建作者：1913040615马泽华 <br/>
     * 创建时间: 2021/7/21 17:42 <br/>
     */
    public static BookDao getBookInstance() {
        return new BookDaoImpl();
    }
}