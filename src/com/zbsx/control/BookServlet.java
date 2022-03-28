package com.zbsx.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zbsx.bean.OrderInfo;
import com.zbsx.bean.Schedule;
import com.zbsx.bean.User;
import com.zbsx.factory.MovieFactory;
import com.zbsx.util.JsonMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/Book")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String method = "无操作";
        method = request.getParameter("method");
        System.out.println("订单模块：" + method);
        JsonMessage msg = new JsonMessage();
        boolean flag;
        String order_id;
        OrderInfo info;
        Schedule schedule;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        switch (method){
            case "add":
                OrderInfo orderInfo = new OrderInfo();
                int price = Integer.parseInt(request.getParameter("price"));
                int schedule_id = Integer.parseInt(request.getParameter("schedule_id"));
                User user = (User) request.getSession().getAttribute("user");
                orderInfo.setOrder_id(String.valueOf(Date.parse(String.valueOf(new Date()))));
                orderInfo.setOrder_price(price);
                orderInfo.setOrder_state(1);
                orderInfo.setUser_id(user.getUser_id());
                orderInfo.setSchedule_id(schedule_id);
                orderInfo.setOrder_position("位置");
                orderInfo.setOrder_time(format.format(new Date()));
                System.out.println(orderInfo.toString());
                schedule = MovieFactory.getScheduleInstance().findByScheduleId(schedule_id);
                if(schedule != null){
                    if(schedule.getSchedule_remain() > 0){//还有数量
                        if(MovieFactory.getBookInstance().add(orderInfo)){//生成订单
                            schedule.setSchedule_remain(schedule.getSchedule_remain()-1);
                            if(MovieFactory.getScheduleInstance().update(schedule)){//减1操作
                                msg.setCode(1);
                                msg.setMsg("订票成功");
                            }
                            else {//减1失败，需要撤回
                                if(MovieFactory.getBookInstance().delete(orderInfo.getOrder_id())){//是否成功撤回
                                    msg.setCode(0);
                                    msg.setMsg("场次更新失败");
                                }
                                else {//撤回失败
                                    msg.setCode(0);
                                    msg.setMsg("系统异常");
                                }
                            }
                        }
                        else {
                            msg.setCode(0);
                            msg.setMsg("订票失败");
                        }
                    }
                    else {
                        msg.setCode(0);
                        msg.setMsg("场次无空座位");
                    }
                }
                else {
                    msg.setCode(0);
                    msg.setMsg("未找到场次");
                }
                break;
            case "list" :
                List<OrderInfo> list = MovieFactory.getBookInstance().findAll();
                msg.setCode(0);
                msg.setCount(list.size());
                msg.setData(JSONArray.parseArray(JSON.toJSONString(list)));
                msg.setMsg("");
                break;
            case "delete":
                String order_id_d = request.getParameter("order_id");
                info = MovieFactory.getBookInstance().findByOrderId(order_id_d);
                if(MovieFactory.getBookInstance().delete(order_id_d)){
                    schedule = MovieFactory.getScheduleInstance().findByScheduleId(info.getSchedule_id());
                    if(schedule != null){
                        schedule.setSchedule_remain(schedule.getSchedule_remain()+1);
                        if(MovieFactory.getScheduleInstance().update(schedule)){
                            msg.setCode(1);
                            msg.setMsg("退票成功");
                        }
                        else {//回滚
                            MovieFactory.getBookInstance().add(info);
                            msg.setCode(0);
                            msg.setMsg("系统异常");
                        }
                    }
                    else {//回滚
                        MovieFactory.getBookInstance().add(info);
                        msg.setCode(0);
                        msg.setMsg("系统异常");
                    }
                }
                else {
                    msg.setCode(0);
                    msg.setMsg("退票失败");
                }
                break;
            case "findByOrderId":
                order_id = request.getParameter("order_id");
                info = MovieFactory.getBookInstance().findByOrderId(order_id);
                if(info != null){
                    msg.setCode(1);
                    JSONArray array = new JSONArray();
                    array.add(info);
                    msg.setData(array);
                    msg.setMsg("查询成功");
                }
                else {
                    msg.setCode(0);
                    msg.setMsg("查询失败");
                }
                break;
            default:
        }
        if(!"selected".equals(method)){
            out.println(JSON.toJSONString(msg));
        }
    }
}
