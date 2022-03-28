package com.zbsx.control; /**
 * 包名: ${PACKAGE_NAME}
 * 类名: ${NAME}
 * 创建用户: Administrator
 * 创建日期: 2021年07月19日 19:58
 * 项目名: movie
 **/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zbsx.bean.Movie;
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

@WebServlet(name = "MovieServlet", value = "/Movie")
public class MovieServlet extends HttpServlet {
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
        System.out.println("影视模块：" + method);
        JsonMessage msg = new JsonMessage();
        boolean flag;
        List<Movie> list = null;
        switch (method){
            case "list" :
                list = MovieFactory.getMovieInstance().findAll();
                msg.setCode(0);
                msg.setMsg("");
                msg.setCount(list.size());
                msg.setData(JSONArray.parseArray(JSON.toJSONString(list)));
                break;
            case "add" :
                Movie movie_add = JSONObject.parseObject(request.getParameter("form"), Movie.class);
                if(MovieFactory.getMovieInstance().findByName(movie_add.getMovie_cn_name())){
                    msg.setCode(0);
                    msg.setMsg("该影视已被添加");
                }else {
                    flag = MovieFactory.getMovieInstance().add(movie_add);
                    if(flag){
                        msg.setCode(1);
                        msg.setMsg("添加成功");
                    }else{
                        msg.setCode(0);
                        msg.setMsg("添加失败");
                    }
                }
                break;
            case "update":
                System.out.println(request.getParameter("form"));
                Movie movie_update = JSONObject.parseObject(request.getParameter("form"),Movie.class);
                flag = MovieFactory.getMovieInstance().update(movie_update);
                if(flag){
                    msg.setCode(1);
                    msg.setMsg("修改成功");
                }else{
                    msg.setCode(0);
                    msg.setMsg("修改失败");
                }
                break;
            case "ban":
                int movie_state = Integer.parseInt(request.getParameter("movie_state"));
                int movie_id = Integer.parseInt(request.getParameter("movie_id"));
                flag = MovieFactory.getMovieInstance().updateState(movie_id,movie_state);
                if(flag){
                    msg.setCode(1);
                    msg.setMsg("更新成功");
                }else{
                    msg.setCode(0);
                    msg.setMsg("更新失败");
                }
                break;
            case "selected" :
                list = MovieFactory.getMovieInstance().findNoBan(1);
                out.println(JSONArray.parseArray(JSON.toJSONString(list)));
                break;
            case  "order":
                int id = Integer.parseInt(request.getParameter("movie_id"));
                System.out.println(id);
                Movie movie_order = MovieFactory.getMovieInstance().findById(id);
                msg.setMsg("查询成功");
                msg.setCode(1);
                JSONArray array = new JSONArray();
                array.add(movie_order);
                msg.setData(array);
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
