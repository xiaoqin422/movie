package com.zbsx.dao;


import com.zbsx.bean.Cinema;

import java.util.List;

public interface CinemaDao {
	/**
	 * 方法名称： findAll<br/>
	 * 功能描述: 遍历电影院信息 <br/>
	 * 方法参数：[] <br/>
	 * 结果返回：java.util.List<com.zbsx.bean.Cinema> <br/>
	 * 创建作者：1913040630崔晓康 <br/>
	 * 创建时间: 2021/7/17 22:26 <br/>
	 */
	List<Cinema> findAll();
	/**
	 * 方法名称：add <br/>
	 * 功能描述: 电影院添加 <br/>
	 * 方法参数：[cinema] <br/>
	 * 结果返回：boolean <br/>
	 * 创建作者：1913040630崔晓康 <br/>
	 * 创建时间: 2021/7/17 22:27 <br/>
	 */
	boolean add(Cinema cinema);
	/**
	 * 方法名称：delete <br/>
	 * 功能描述: 电影院删除 <br/>
	 * 方法参数：[cinema_id] <br/>
	 * 结果返回：boolean <br/>
	 * 创建作者：1913040630崔晓康 <br/>
	 * 创建时间: 2021/7/17 22:27 <br/>
	 */
	boolean delete(int cinema_id);
	/**
	 * 方法名称：update <br/>
	 * 功能描述: 电影院修改 <br/>
	 * 方法参数：[cinema] <br/>
	 * 结果返回：boolean <br/>
	 * 创建作者：1913040630崔晓康 <br/>
	 * 创建时间: 2021/7/17 22:27 <br/>
	 */
	boolean update(Cinema cinema);

	/**
	 * 方法名称： <br/>
	 * 功能描述: 电影院查询--name <br/>
	 * 方法参数：[cinema_name] <br/>
	 * 结果返回：boolean <br/>
	 * 创建作者：1913040630崔晓康 <br/>
	 * 创建时间: 2021/7/20 22:51 <br/>
	 */
	boolean findByName(String cinema_name);
	/**
	 * 方法名称：findCinema <br/>
	 * 功能描述: 电影院查询--name <br/>
	 * 方法参数：[cinema_name] <br/>
	 * 结果返回：java.util.List<com.zbsx.bean.Cinema> <br/>
	 * 创建作者：1913040630崔晓康 <br/>
	 * 创建时间: 2021/7/17 22:28 <br/>
	 */
	List<Cinema> findCinema(String cinema_name);
	
}
