package com.zbsx.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zbsx.bean.Schedule;
import com.zbsx.dto.Schedule_movie_hall_cinema;
import com.zbsx.factory.MovieFactory;
import com.zbsx.util.JsonMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ScheduleServlet", value = "/Schedule")
public class ScheduleServlet extends HttpServlet {
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
        System.out.println("场次模块：" + method);
        JsonMessage msg = new JsonMessage();
        boolean flag;
        Integer schedule_id;
        Schedule schedule;
        switch (method) {
            case "list":
                List<Schedule_movie_hall_cinema> list = MovieFactory.getScheduleInstance().findAll();
                msg.setCode(0);
                msg.setCount(list.size());
                msg.setData(JSONArray.parseArray(JSON.toJSONString(list)));
                msg.setMsg("");
                break;
            case "ban":
                int id = Integer.parseInt(request.getParameter("id"));
                int state = Integer.parseInt(request.getParameter("state"));
                if(MovieFactory.getScheduleInstance().ban(id,state)){
                    msg.setCode(1);
                    msg.setMsg("操作成功");
                }else{
                    msg.setCode(0);
                    msg.setMsg("操作失败");
                }
                break;
            case "add":
                System.out.println(request.getParameter("form"));
                schedule = JSONObject.parseObject(request.getParameter("form"), Schedule.class);
                System.out.println(schedule.toString());
                if (MovieFactory.getScheduleInstance().add(schedule)) {
                    msg.setCode(1);
                    msg.setMsg("添加成功");
                } else {
                    msg.setCode(0);
                    msg.setMsg("添加失败");
                }
                break;
            case "delete":
                schedule_id = Integer.parseInt(request.getParameter("schedule_id"));
                if (MovieFactory.getScheduleInstance().delete(schedule_id)) {
                    msg.setCode(1);
                    msg.setMsg("删除成功");
                } else {
                    msg.setCode(0);
                    msg.setMsg("删除失败");
                }
                break;
            case "update":
                schedule = JSONObject.parseObject(request.getParameter("form"), Schedule.class);
                System.out.println(schedule.toString());
                if (MovieFactory.getScheduleInstance().update(schedule)) {
                    msg.setCode(1);
                    msg.setMsg("修改成功");
                } else {
                    msg.setCode(0);
                    msg.setMsg("修改失败");
                }
                break;
            case "findByScheduleId":
                schedule_id = Integer.parseInt(request.getParameter("schedule_id"));
                schedule = MovieFactory.getScheduleInstance().findByScheduleId(schedule_id);
                if (schedule != null) {
                    msg.setCode(1);
                    JSONArray array = new JSONArray();
                    array.add(schedule);
                    msg.setData(array);
                    msg.setMsg("查询成功");
                } else {
                    msg.setCode(0);
                    msg.setMsg("查询失败");
                }
                break;
            case "order" :
                int movie_id = Integer.parseInt(request.getParameter("movie_id"));
                String data = request.getParameter("data");
                list = MovieFactory.getScheduleInstance().findScheduleForOrder(movie_id,data);
                msg.setCode(0);
                msg.setMsg("查询成功");
                msg.setCount(list.size());
                msg.setData(JSONArray.parseArray(JSON.toJSONString(list)));
                break;
            default:
                msg.setCode(0);
                msg.setCount(0);
                msg.setMsg("请求异常");
        }
        out.println(JSON.toJSONString(msg));
    }
}
