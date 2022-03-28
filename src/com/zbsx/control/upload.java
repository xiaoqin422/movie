package com.zbsx.control;
/**
 * 包名: ${PACKAGE_NAME}
 * 类名: ${NAME}
 * 创建用户: Administrator
 * 创建日期: 2021年07月18日 17:36
 * 项目名: movie
 **/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zbsx.util.FileMessage;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "upload", value = "/upload")
public class upload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String method = request.getParameter("method");
        System.out.println(method);
        DiskFileItemFactory factory = new DiskFileItemFactory();//jar包的类
        ServletFileUpload upload = new ServletFileUpload(factory);//jar包的类
        try {
            List<FileItem> items = upload.parseRequest(request);
            //将前端的表单数据封装成list。
            //form表单必须加enctype="multipart/form-data"，在使用包含文件上传控件的表单时，必须使用该值。
            for (FileItem item:items){
                if(item.isFormField()){
                    //说明普通表单项
                }else {
                    //说明上传文件项
                    //获取上传文件的名称
                    String name  = item.getName();
                    //获取相对路径

                    String tpath = "movie".equals(request.getParameter("method"))?"images/movie/":"images/User/";
                    String suffix = name.substring(name.lastIndexOf(".") + 1);//文件后缀名
                    name = Date.parse(String.valueOf(new Date())) + "."+suffix;
                    String path = getServletContext().getRealPath("/" + tpath +name);
                    //将相对路径保存到数据库
                    System.out.println(path);
                    //使用绝对路径完成文件上传
                    item.write(new File(path));
                    //item.write(new File("E:\\本地文件夹\\文档\\IDEA\\movie\\web\\images\\User",name));
                    //删除临时文件
                    item.delete();
                    Map<String, Object> fileMap = new HashMap<>();
                    fileMap.put("file_id",tpath +name);
                    fileMap.put("file_name",name);
                    fileMap.put("file_suffix",suffix);
                    fileMap.put("file_url",path);
                    FileMessage fileMessage = new FileMessage(true,"上传成功",new JSONObject(fileMap));
                    out.println(JSON.toJSONString(fileMessage));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
