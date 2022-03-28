package com.zbsx.dao;

import com.zbsx.bean.OrderInfo;

import java.util.List;

public interface BookDao {
    boolean add(OrderInfo info);
    boolean delete(String order_id);
    OrderInfo findByOrderId(String order_id);
    List<OrderInfo> findAll();
}
