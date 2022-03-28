package com.zbsx.control;
/**
 * 包名: ${PACKAGE_NAME}
 * 类名: ${NAME}
 * 创建用户: Administrator
 * 创建日期: 2021年07月23日 17:57
 * 项目名: movie
 **/

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String path = req.getRequestURI();
        String[] pa = path.split("/");
        String url = pa[pa.length - 1];
        String type = url.substring(url.lastIndexOf(".") + 1);
        if ("html".equals(type) && !"login.html".equals(url) && !"reg.html".equals(url) && !"admin.html".equals(url)) {
            if (pa.length == 3) {
                if (session.getAttribute("user") == null) {
                    res.sendRedirect("/show/login.html");
                }
            } else {
                if (session.getAttribute("manager") == null) {
                    res.sendRedirect("admin.html");
                }
            }
        }
        chain.doFilter(request, response);
    }
}
