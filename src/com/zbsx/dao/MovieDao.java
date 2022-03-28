package com.zbsx.dao;

import com.zbsx.bean.Movie;

import java.util.List;

/**
 * 包名: com.zbsx.dao
 * 类名: MovieDao
 * 创建用户: Administrator
 * 创建日期: 2021年07月16日 14:46
 * 项目名: movie
 **/
public interface MovieDao {
    /**
     * 方法名称：findAll <br/>
     * 功能描述: 遍历电影列表 <br/>
     * 方法参数：[] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Movie> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/16 14:46 <br/>
     */
    List<Movie> findAll();
    /**
     * 方法名称：add <br/>
     * 功能描述: 电影信息添加 <br/>
     * 方法参数：[movie] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/16 14:46 <br/>
     */
    boolean add(Movie movie);
    /**
     * 方法名称：findByName <br/>
     * 功能描述: 通过name查找电影 <br/>
     * 方法参数：[movie_name] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/16 14:47 <br/>
     */
    boolean findByName(String movie_name);
    /**
     * 方法名称：update <br/>
     * 功能描述: 电影信息修改 <br/>
     * 方法参数：[movie] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/16 14:47 <br/>
     */
    boolean update(Movie movie);
    /**
     * 方法名称： updateState<br/>
     * 功能描述: 电影上架/下架 <br/>
     * 方法参数：[movie_id, movie_state] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/16 23:27 <br/>
     */
    boolean updateState(int movie_id,int movie_state);
    /**
     * 方法名称：findNoBan <br/>
     * 功能描述: 根据状态查找电影 <br/>
     * 方法参数：[state] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Movie> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/21 20:17 <br/>
     */
    List<Movie> findNoBan(int state);
    /**
     * 方法名称：findById <br/>
     * 功能描述: 通过id查找相关电影 <br/>
     * 方法参数：[movie_id] <br/>
     * 结果返回：com.zbsx.bean.Movie <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/23 23:59 <br/>
     */
    Movie findById(int movie_id);
}
