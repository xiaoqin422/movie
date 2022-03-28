package com.zbsx.control; /**
 * 包名: ${PACKAGE_NAME}
 * 类名: ${NAME}
 * 创建用户: Administrator
 * 创建日期: 2021年07月19日 21:46
 * 项目名: movie
 **/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zbsx.bean.Hall;
import com.zbsx.dto.Hall_Cinema_DTO;
import com.zbsx.factory.MovieFactory;
import com.zbsx.util.JsonMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HallServlet", value = "/Hall")
public class HallServlet extends HttpServlet {
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
        System.out.println("影厅模块：" + method);
        JsonMessage msg = new JsonMessage();
        boolean flag;
        List<Hall_Cinema_DTO> list = new ArrayList<>();
        switch (method){
            case "list":
                String search = request.getParameter("method-1");
                if("1".equals(search)){
                    String hall_name =request.getParameter("hall_name");
                    String cinema_name = request.getParameter("cinema_name");
                    list = MovieFactory.getHallInstance().findHall(hall_name,cinema_name);
                }else {
                    list = MovieFactory.getHallInstance().findAll();
                }
                msg.setCode(0);
                msg.setMsg("");
                msg.setCount(list.size());
                msg.setData(JSONArray.parseArray(JSON.toJSONString(list)));
                break;
            case "add":
                Hall hall_add = JSONArray.parseObject(request.getParameter("form"),Hall.class);
                if (MovieFactory.getHallInstance().findHallByCinema_ID(hall_add.getHall_name(),hall_add.getCinema_id())){
                    msg.setCode(0);
                    msg.setMsg("该影院存在同名影厅");
                }else {
                    flag = MovieFactory.getHallInstance().add(hall_add);
                    if(flag){
                        msg.setCode(1);
                        msg.setMsg("添加成功");
                    }else {
                        msg.setCode(0);
                        msg.setMsg("添加失败");
                    }
                }

                break;
            case "update":
                Hall hall_update = JSONArray.parseObject(request.getParameter("form"),Hall.class);
                flag = MovieFactory.getHallInstance().update(hall_update);
                if(flag){
                    msg.setCode(1);
                    msg.setMsg("修改成功");
                }else {
                    msg.setCode(0);
                    msg.setMsg("修改失败");
                }
                break;
            case "delete":
                int hall_id = Integer.parseInt(request.getParameter("hall_id"));
                flag = MovieFactory.getHallInstance().delete(hall_id);
                if(flag){
                    msg.setCode(1);
                    msg.setMsg("删除成功");
                }else {
                    msg.setCode(0);
                    msg.setMsg("删除失败");
                }
                break;
            case "selected":
                int cinema_id = Integer.parseInt(request.getParameter("cinema_id"));
                out.println(JSONArray.parseArray(JSON.toJSONString(MovieFactory.getHallInstance().findByCinema_id(cinema_id))));
                break;
            default:
                msg.setCode(-1);
                msg.setCount(0);
                msg.setMsg("请求异常");
        }
        if(!"selected".equals(method)){
            out.println(JSON.toJSONString(msg));
        }

    }
}
