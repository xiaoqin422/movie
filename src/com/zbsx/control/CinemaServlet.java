package com.zbsx.control; /**
 * 包名: ${PACKAGE_NAME}
 * 类名: ${NAME}
 * 创建用户: Administrator
 * 创建日期: 2021年07月19日 21:45
 * 项目名: movie
 **/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zbsx.bean.Cinema;
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

@WebServlet(name = "CinemaServlet", value = "/Cinema")
public class CinemaServlet extends HttpServlet {
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
        System.out.println("影院模块：" + method);
        JsonMessage msg = new JsonMessage();
        boolean flag;
        List<Cinema> list = new ArrayList<>();
        switch (method){
            case "list":
                String search = request.getParameter("method-1");
                if("1".equals(search)){
                    String cinema_name = request.getParameter("cinema_name");
                    list = MovieFactory.getCinemaInstance().findCinema(cinema_name);
                }else{
                    list = MovieFactory.getCinemaInstance().findAll();
                }
                msg.setCode(0);
                msg.setMsg("");
                msg.setCount(list.size());
                msg.setData(JSONArray.parseArray(JSON.toJSONString(list)));
                break;
            case "selected":
                list = MovieFactory.getCinemaInstance().findAll();
                out.println(JSONArray.parseArray(JSON.toJSONString(list)));
                break;
            case "add":
                Cinema cinema_add = JSONObject.parseObject(request.getParameter("form"),Cinema.class);
                if(MovieFactory.getCinemaInstance().findByName(cinema_add.getCinema_name())){
                    msg.setCode(0);
                    msg.setMsg("该影院名称已被添加");
                }else{
                    flag = MovieFactory.getCinemaInstance().add(cinema_add);
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
                Cinema cinema_update = JSONObject.parseObject(request.getParameter("form"),Cinema.class);
                flag = MovieFactory.getCinemaInstance().update(cinema_update);
                if(flag){
                    msg.setCode(1);
                    msg.setMsg("修改成功");
                }else {
                    msg.setCode(0);
                    msg.setMsg("修改失败");
                }
                break;
            case "delete" :
                int cinema_id = Integer.parseInt(request.getParameter("cinema_id"));
                flag = MovieFactory.getCinemaInstance().delete(cinema_id);
                if(flag){
                    msg.setCode(1);
                    msg.setMsg("删除成功");
                }else {
                    msg.setCode(0);
                    msg.setMsg("删除失败");
                }
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
