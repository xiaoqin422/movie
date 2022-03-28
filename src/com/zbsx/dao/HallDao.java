package com.zbsx.dao;

import com.zbsx.bean.Hall;
import com.zbsx.dto.Hall_Cinema_DTO;

import java.util.List;

/**
 * 包名: com.zbsx.dao
 * 类名: HallDao
 * 创建用户: Administrator
 * 创建日期: 2021年07月17日 20:29
 * 项目名: movie
 **/
public interface HallDao {
    /**
     * 方法名称： findAll<br/>
     * 功能描述: 影厅信息遍历 <br/>
     * 方法参数：[] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Hall> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 20:46 <br/>
     */
    List<Hall_Cinema_DTO> findAll();
    /**
     * 方法名称： findById<br/>
     * 功能描述: 影厅查找-id <br/>
     * 方法参数：[hall_id] <br/>
     * 结果返回：com.zbsx.bean.Hall <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 20:46 <br/>
     */
    Hall  findById(int hall_id);
    /**
     * 方法名称： findHall<br/>
     * 功能描述: 影厅查找-多条件 <br/>
     * 方法参数：[hall_name, cinema_name] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Hall> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 20:46 <br/>
     */
    List<Hall_Cinema_DTO> findHall(String hall_name,String cinema_name);
    /**
     * 方法名称：findHallByCinema_ID <br/>
     * 功能描述: 影厅添加查重 <br/>
     * 方法参数：[hall_name, cinema_id] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/21 14:38 <br/>
     */
    boolean findHallByCinema_ID(String hall_name,int cinema_id);
    /**
     * 方法名称： delete<br/>
     * 功能描述: 影厅删除 <br/>
     * 方法参数：[hall_id] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 20:46 <br/>
     */
    boolean delete(int hall_id);
    /**
     * 方法名称： update<br/>
     * 功能描述: 影厅修改 <br/>
     * 方法参数：[hall] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 20:46 <br/>
     */
    boolean update(Hall hall);
    /**
     * 方法名称： add<br/>
     * 功能描述: 影厅增加 <br/>
     * 方法参数：[hall] <br/>
     * 结果返回：boolean <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/17 20:46 <br/>
     */
    boolean add(Hall hall);
    /**
     * 方法名称：findByCinema_id <br/>
     * 功能描述: 通过影院id查影厅信息 <br/>
     * 方法参数：[cinema_id] <br/>
     * 结果返回：java.util.List<com.zbsx.bean.Hall> <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/21 20:34 <br/>
     */
    List<Hall> findByCinema_id(int cinema_id);
}
