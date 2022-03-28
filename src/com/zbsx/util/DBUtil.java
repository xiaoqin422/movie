package com.zbsx.util;

import java.sql.*;

/**
 * 包名: com.zbsx.dbutil
 * 类名: DBUtil
 * 创建用户: Administrator
 * 创建日期: 2021年07月13日 13:05
 * 项目名: movie
 **/
public class DBUtil {

    //1.定义常量 保存数据库连接的相关信息

    public static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/movie_db?useSSL=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123123";

    //2.使用静态代码块进行配置

    static {
        try {
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法名称：getConnection <br/>
     * 功能描述: 获取数据库连接 <br/>
     * 方法参数：[] <br/>
     * 结果返回：java.sql.Connection <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:06 <br/>
     */
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 方法名称：close <br/>
     * 功能描述: 释放数据库资源 <br/>
     * 方法参数：[con, preparedStatement] <br/>
     * 结果返回：void <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:07 <br/>
     */
    public static void close(Connection con, PreparedStatement preparedStatement) {
        if (con != null && preparedStatement != null) {
            try {
                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 方法名称：close <br/>
     * 功能描述: 释放数据库资源 <br/>
     * 方法参数：[con, preparedStatement, resultSet] <br/>
     * 结果返回：void <br/>
     * 创建作者：1913040637秦笑笑 <br/>
     * 创建时间: 2021/7/13 13:08 <br/>
     */
    public static void close(Connection con, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (con != null && preparedStatement != null && resultSet != null) {
            try {
                resultSet.close();
                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}