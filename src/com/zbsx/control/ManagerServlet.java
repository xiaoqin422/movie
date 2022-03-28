package com.zbsx.control;
/**
 * 包名: ${PACKAGE_NAME}
 * 类名: ${NAME}
 * 创建用户: Administrator
 * 创建日期: 2021年07月13日 14:23
 * 项目名: movie
 **/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zbsx.bean.Manager;
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

@WebServlet(name = "ManagerServlet", value = "/admin")
public class ManagerServlet extends HttpServlet {
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
        System.out.println("管理员模块：" + method);
        JsonMessage msg = new JsonMessage();
        boolean flag;
        List<Manager> list = null;
        switch (method){
            case "login":
                flag = MovieFactory.getManagerInstance().login(request.getParameter("name"),request.getParameter("password"));
                if(flag){
                    int state_login = MovieFactory.getManagerInstance().geStateByname(request.getParameter("name"));
                    if(state_login == 0){
                        msg.setCode(0);
                        msg.setMsg("账号被停用,请联系管理员！");
                        break;
                    }
                    request.getSession().setAttribute("manager",MovieFactory.getManagerInstance().geStateByname(request.getParameter("name")));
                    msg.setCode(1);
                    msg.setMsg("登录成功");
                    msg.setLocation("index.html");
                }else {
                    msg.setCode(0);
                    msg.setMsg("账号或密码错误！");
                }
                break;
            case "list" :
                String select = request.getParameter("method-select");
                if("1".equals(select)){
                    list = MovieFactory.getManagerInstance().findManager(request.getParameter("name"),request.getParameter("role"));
                }else{
                    list = MovieFactory.getManagerInstance().findAll();
                }
                msg.setCode(0);
                msg.setCount(list.size());
                msg.setData(JSONArray.parseArray(JSON.toJSONString(list)));
                msg.setMsg("");
                break;
            case "del" :
                String name = request.getParameter("name");
                flag = MovieFactory.getManagerInstance().delete(name);
                if(flag){
                    msg.setCode(1);
                    msg.setMsg("删除成功");
                }else{
                    msg.setCode(0);
                    msg.setMsg("删除失败");
                }
                break;
            case "dels" :
                String names = request.getParameter("name");
                String[] ids = names.split(",");
                int num = 0;
                for(String s : ids){
                    flag = MovieFactory.getManagerInstance().delete(s);
                    if(flag){
                        num += 1;
                    }
                }
                if(num == ids.length){
                    msg.setCode(1);
                    msg.setMsg("删除成功,共删除"+num+"条信息.");
                }else{
                    msg.setCode(0);
                    msg.setMsg("删除失败");
                }
                break;
            case "add" :
                System.out.println(request.getParameter("form"));
                Manager manager_add = JSONObject.parseObject(request.getParameter("form"), Manager.class);
                Manager manager_add1 = MovieFactory.getManagerInstance().findById(manager_add.getName());
                if(manager_add1 != null){
                    msg.setCode(0);
                    msg.setMsg("该用户名已注册！");
                }else {
                    flag = MovieFactory.getManagerInstance().add(manager_add);
                    if(flag){
                        msg.setCode(1);
                        msg.setMsg("添加成功");
                    }else{
                        msg.setCode(0);
                        msg.setMsg("添加失败");
                    }
                }
                break;
            case "edit" :
                Manager manager_edit = JSONObject.parseObject(request.getParameter("form"), Manager.class);
                Manager manager_edit1 = MovieFactory.getManagerInstance().findById(manager_edit.getName());
                if(manager_edit1 == null){
                    msg.setCode(0);
                    msg.setMsg("该用户不存在！");
                }else {
                    manager_edit.setState(manager_edit1.getState());
                    flag = MovieFactory.getManagerInstance().update(manager_edit);
                    if(flag){
                        msg.setCode(1);
                        msg.setMsg("修改成功");
                    }else{
                        msg.setCode(0);
                        msg.setMsg("修改失败");
                    }
                }
                break;
            case  "ban" :
                String name_ban = request.getParameter("name");
                String state = request.getParameter("state");
                flag = MovieFactory.getManagerInstance().updateState(name_ban,Integer.valueOf(state));
                if(flag){
                    msg.setCode(1);
                    msg.setMsg("操作成功");
                }else{
                    msg.setCode(0);
                    msg.setMsg("操作失败");
                }
                break;
            default:
                msg.setCode(-1);
                msg.setCount(0);
                msg.setMsg("请求异常");
        }
        out.println(JSON.toJSONString(msg));
    }
}
