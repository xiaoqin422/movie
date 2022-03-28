package com.zbsx.control; /**
 * 包名: ${PACKAGE_NAME}
 * 类名: ${NAME}
 * 创建用户: Administrator
 * 创建日期: 2021年07月17日 10:29
 * 项目名: movie
 **/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String method;
        method = request.getParameter("method");
        System.out.println("用户模块：" + method);
        JsonMessage msg = new JsonMessage();
        boolean flag;
        List<User> list = null;
        switch (method) {
            case "login":
                flag = MovieFactory.getUserInstance().login(request.getParameter("user_name"), request.getParameter("user_pwd"));
                if (flag) {
                    User user_login = MovieFactory.getUserInstance().findByName(request.getParameter("user_name"));
                    if (user_login.getUser_state() == 0) {
                        msg.setCode(0);
                        msg.setMsg("账号被停用,请联系管理员！");
                        break;
                    }
                    request.getSession().setAttribute("user",user_login);
                    msg.setCode(1);
                    msg.setMsg("登录成功");
                    msg.setLocation("show/index.html");
                } else {
                    msg.setCode(0);
                    msg.setMsg("账号或密码错误！");
                }
                break;
            case "list":
                String select = request.getParameter("method-select");
                if ("1".equals(select)) {
                    list = MovieFactory.getUserInstance().findUser(request.getParameter("user_name"), Integer.valueOf(request.getParameter("user_role")));
                } else {
                    list = MovieFactory.getUserInstance().findAll();
                }
                msg.setCode(0);
                msg.setCount(list.size());
                msg.setData(JSONArray.parseArray(JSON.toJSONString(list)));
                msg.setMsg("");
                break;
            case "del":
                String user_name = request.getParameter("user_name");
                flag = MovieFactory.getUserInstance().delete(user_name);
                if (flag) {
                    msg.setCode(1);
                    msg.setMsg("删除成功");
                } else {
                    msg.setCode(0);
                    msg.setMsg("删除失败");
                }
                break;
            case "dels":
                String user_names = request.getParameter("user_names");
                String[] ids = user_names.split(",");
                int num = 0;
                for (String s : ids) {
                    flag = MovieFactory.getUserInstance().delete(s);
                    if (flag) {
                        num += 1;
                    }
                }
                if (num == ids.length) {
                    msg.setCode(1);
                    msg.setMsg("删除成功,共删除" + num + "条信息.");
                } else {
                    msg.setCode(0);
                    msg.setMsg("删除失败");
                }
                break;
            case "add":
                System.out.println(request.getParameter("form"));
                User user_add = JSONObject.parseObject(request.getParameter("form"), User.class);
                User user_add1 = MovieFactory.getUserInstance().findByName(user_add.getUser_name());
                if (user_add1 != null) {
                    msg.setCode(0);
                    msg.setMsg("该用户名已注册！");
                } else {
                    if ("".equals(user_add.getUser_headimg()) || user_add.getUser_headimg() == null) {
                        user_add.setUser_headimg("images/UserHead/head.png");
                    }
                    flag = MovieFactory.getUserInstance().add(user_add);
                    if (flag) {
                        msg.setCode(1);
                        msg.setMsg("注册成功");
                    } else {
                        msg.setCode(0);
                        msg.setMsg("注册失败");
                    }
                }
                break;
            case "edit":
                User user_edit = JSONObject.parseObject(request.getParameter("form"), User.class);
                User user_edit1 = MovieFactory.getUserInstance().findByName(user_edit.getUser_name());
                if (user_edit1 == null) {
                    msg.setCode(0);
                    msg.setMsg("该用户不存在！");
                } else {
                    flag = MovieFactory.getUserInstance().update(user_edit);
                    if (flag) {
                        msg.setCode(1);
                        msg.setMsg("修改成功");
                    } else {
                        msg.setCode(0);
                        msg.setMsg("修改失败");
                    }
                }
                break;
            case "ban":
                String name_ban = request.getParameter("user_name");
                String state = request.getParameter("user_state");
                flag = MovieFactory.getUserInstance().updateState(name_ban, Integer.valueOf(state));
                if (flag) {
                    msg.setCode(1);
                    msg.setMsg("操作成功");
                } else {
                    msg.setCode(0);
                    msg.setMsg("操作失败");
                }
                break;
            case "role":
                String name_role = request.getParameter("user_name");
                String role = request.getParameter("user_role");
                flag = MovieFactory.getUserInstance().updateRole(name_role, Integer.valueOf(role));
                if (flag) {
                    msg.setCode(1);
                    msg.setMsg("操作成功");
                } else {
                    msg.setCode(0);
                    msg.setMsg("操作失败");
                }
                break;
            case "findByName":
                String user_name_find = request.getParameter("user_name");
                User user_find = MovieFactory.getUserInstance().findByName(user_name_find);
                out.println(JSONObject.toJSONString(user_find));
                return;
            default:
                msg.setCode(0);
                msg.setCount(0);
                msg.setMsg("请求异常");
        }
        out.println(JSON.toJSONString(msg));
    }
}
