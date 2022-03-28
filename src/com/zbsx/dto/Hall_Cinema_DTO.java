package com.zbsx.dto;

public class Hall_Cinema_DTO {
	 private int hall_id;
	 private String hall_name;
	 private int hall_capacity;
	 private int cid;
	 private String cinema_name;
	 private String cinema_address;
	 /**
	  * 方法名称：Hall_Cinema_DTO <br/>
	  * 功能描述: Hall_Cinema_DTO无参构造函数 <br/>
	  * 方法参数：[] <br/>
	  * 结果返回： <br/>
	  * 创建作者：1913040630崔晓康 <br/>
	  * 创建时间: 2021/7/18 0:26 <br/>
	  */
	public Hall_Cinema_DTO() {
		super();
	}
	/**
	 * 方法名称：Hall_Cinema_DTO <br/>
	 * 功能描述: Hall_Cinema_DTO有参构造函数 <br/>
	 * 方法参数：[hall_id, hall_name, hall_capacity, cid, cinema_name, cinema_address] <br/>
	 * 结果返回： <br/>
	 * 创建作者：1913040630崔晓康 <br/>
	 * 创建时间: 2021/7/18 0:27 <br/>
	 */
	public Hall_Cinema_DTO(int hall_id, String hall_name, int hall_capacity, int cid, String cinema_name,
			String cinema_address) {
		super();
		this.hall_id = hall_id;
		this.hall_name = hall_name;
		this.hall_capacity = hall_capacity;
		this.cid = cid;
		this.cinema_name = cinema_name;
		this.cinema_address = cinema_address;
	}

	public int getHall_id() {
		return hall_id;
	}

	public String getHall_name() {
		return hall_name;
	}

	public int getHall_capacity() {
		return hall_capacity;
	}

	public int getCid() {
		return cid;
	}

	public String getCinema_name() {
		return cinema_name;
	}

	public String getCinema_address() {
		return cinema_address;
	}

	@Override
	public String toString() {
		return "Hall_Cinema_DTO [hall_id=" + hall_id + ", hall_name=" + hall_name + ", hall_capacity=" + hall_capacity
				+ ", cid=" + cid + ", cinema_name=" + cinema_name + ", cinema_address=" + cinema_address + "]";
	}
	
	 
}
