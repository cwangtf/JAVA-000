package com.example.homework.class13.two;

import com.example.homework.class13.two.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Random;

/**
 * @author wangtf
 * @date 2021/2/17
 */
public class InsertDemo {

    public static final String URL = "jdbc:mysql://localhost:3306/test";
    public static final String USER = "root";
    public static final String PWD = "123456";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
//        insertOneByOne();
        addBatch();
    }

    public static void insertOneByOne() {

        long start = System.currentTimeMillis();

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = JdbcUtil.getConnection(USER, PWD, URL, DRIVER);
            stmt = conn.createStatement();
            StringBuilder sql = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < 1000000; i++) {
                sql.append("INSERT INTO `order` (`order_no`,`sku_id`,`user_id`,`receiver_phone`,`receiver_name`,`receiver_address`,`origin_price`,`discount_price`,`paid`,`create_time`,`update_time`,`is_deleted`) VALUES (");
                sql.append("'test'");
                sql.append(",");
                sql.append(random.nextInt(2));
                sql.append(",");
                sql.append(random.nextInt(2));
                sql.append(",");
                sql.append("'18812345678'");
                sql.append(",");
                sql.append("'zhangsan'");
                sql.append(",");
                sql.append("'hangzhou'");
                sql.append(",");
                sql.append(random.nextInt(2));
                sql.append(",");
                sql.append(random.nextInt(2));
                sql.append(",");
                sql.append(random.nextInt(2));
                sql.append(",");
                sql.append("'2021-02-17 20:00:00'");
                sql.append(",");
                sql.append("'2021-02-17 20:00:00'");
                sql.append(",");
                sql.append(0);
                sql.append(");");
                System.out.println(sql.toString());
                stmt.executeUpdate(sql.toString());
                sql.setLength(0);
            }

            stmt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (!Objects.isNull(stmt)) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (!Objects.isNull(conn)) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("循环插入耗时"+(end-start)/1000 + "秒");
    }

    public static void addBatch() {

        long start = System.currentTimeMillis();

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = JdbcUtil.getConnection(USER, PWD, URL, DRIVER);

            // 批量操作
            System.out.println(" 实例化Statement对象... ");

            String sql = "INSERT INTO `order` (`order_no`,`sku_id`,`user_id`,`receiver_phone`,`receiver_name`,`receiver_address`,`origin_price`,`discount_price`,`paid`,`create_time`,`update_time`,`is_deleted`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
            statement = conn.prepareStatement(sql);

            Random random = new Random(2);
            conn.setAutoCommit(false);
            for (int i = 0; i < 100000; i++) {
                statement.setString(1, "test");
                statement.setInt(2, random.nextInt(2));
                statement.setInt(3, random.nextInt(2));
                statement.setString(4, "18812345678");
                statement.setString(5, "zhangsan");
                statement.setString(6, "hangzhou");
                statement.setInt(7, random.nextInt(2));
                statement.setInt(8, random.nextInt(2));
                statement.setInt(9, random.nextInt(2));
                statement.setString(10, "2021-02-17 20:00:00");
                statement.setString(11, "2021-02-17 20:00:00");
                statement.setInt(12, 0);
                statement.addBatch();
            }
            statement.executeBatch();
            conn.commit();
            statement.clearBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (!Objects.isNull(statement)) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (!Objects.isNull(conn)) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批量插入耗时"+(end-start)/1000 + "秒");
    }

}
