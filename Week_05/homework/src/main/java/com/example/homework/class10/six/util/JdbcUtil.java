package com.example.homework.class10.six.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author wangtf
 * @date 2021/2/16
 */
public class JdbcUtil {

    public static void config(String driver) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @param user
     * @param pwd
     * @param url
     * @param driver
     * @return
     */
    public static Connection getConnection(String user, String pwd, String url, String driver) {
        /**
         * 获取一个连接
         */
        config(driver);

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭连接
     * @param connection
     */
    public static void closeConnection(Connection connection) {
        if (!Objects.isNull(connection)) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
