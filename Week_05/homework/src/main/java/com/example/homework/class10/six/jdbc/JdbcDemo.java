package com.example.homework.class10.six.jdbc;

import com.example.homework.class10.six.util.HikariCPUtil;
import com.example.homework.class10.six.util.JdbcUtil;

import java.sql.*;

/**
 * @author wangtf
 * @date 2021/2/16
 */
public class JdbcDemo {

    public static final String URL = "jdbc:mysql://localhost:3306/test";
    public static final String USER = "root";
    public static final String PWD = "123456";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
//        Connection connection = JdbcUtil.getConnection(USER, PWD, URL, DRIVER);
        Connection connection = HikariCPUtil.getConnection(USER, PWD, URL, DRIVER);
        JdbcDemo demo = new JdbcDemo();
        try {
//            demo.nativeJdbc(connection.createStatement());
            demo.prepareStatementJDBC(connection);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.closeConnection(connection);
        }
    }

    public void prepareStatementJDBC(Connection getConn) {
        String insertSql = "insert into user(`name`) values (?);";
        String selectSql = "select `id`,`name` from user;";
        String updateSql = "update user set name=? where name = ?;";
        String deleteSql = "delete from user where name = ?;";

        try {
            // 增
            PreparedStatement insertPs = getConn.prepareStatement(insertSql);
            getConn.setAutoCommit(false);
            insertPs.setString(1, "wangtf");
            insertPs.addBatch();

            insertPs.setString(1, "wangtf2");
            insertPs.addBatch();

            insertPs.setString(1, "wangtf3");
            insertPs.addBatch();

            int[] insertIns = insertPs.executeBatch();
            for (int i = 0; i < insertIns.length; i++) {
                System.out.println("数据 " + i + "执行插入，结果 " + insertIns[i] );
            }
            getConn.commit();
            insertPs.clearBatch();

            // 查
            PreparedStatement selectPs = getConn.prepareStatement(selectSql);
            ResultSet rs = selectPs.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " 名字：" + rs.getString("name"));
            }

            // 改
            PreparedStatement updatePs = getConn.prepareStatement(updateSql);
            getConn.setAutoCommit(false);
            updatePs.setString(1, "wangtfu");
            updatePs.setString(2, "wangtf");
            updatePs.addBatch();
            updatePs.setString(1, "wangtf2u");
            updatePs.setString(2, "wangtf2");
            updatePs.addBatch();
            updatePs.setString(1, "wangtf3u");
            updatePs.setString(2, "wangtf3");
            updatePs.addBatch();
            int[] updateIns = updatePs.executeBatch();
            for (int i = 0; i < updateIns.length; i++) {
                System.out.println("数据 " + i + "执行修改，结果 " + updateIns[i] );
            }
            getConn.commit();

            // 删
            PreparedStatement deletePs = getConn.prepareStatement(deleteSql);
            getConn.setAutoCommit(false);
            deletePs.setString(1, "wangtfu");
            deletePs.addBatch();
            deletePs.setString(1, "wangtf2u");
            deletePs.addBatch();
            deletePs.setString(1, "wangtf3u");
            deletePs.addBatch();
            int[] deleteIns = deletePs.executeBatch();
            for (int i = 0; i < deleteIns.length; i++) {
                System.out.println("数据 " + i + "执行删除，结果 " + deleteIns[i] );
            }
            getConn.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void nativeJdbc(Statement statement) {
        String insertSql = "insert into user(`id`,`name`) values (1,'wangtf');";
        String selectSql = "select `id`,`name` from user;";
        String updateSql = "update user set name='wzl' where id = 1;";
        String deleteSql = "delete from user where id = 1;";

        try {
            // 插入
            int insertRs = statement.executeUpdate(insertSql);
            System.out.println("插入结果：" + insertRs);
            // 查询
            ResultSet rs = statement.executeQuery(selectSql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " 名字：" + rs.getString("name"));
            }
            // 修改
            int updateRs = statement.executeUpdate(updateSql);
            System.out.println("修改结果：" + updateRs);
            // 删除
            int deleteRs = statement.executeUpdate(deleteSql);
            System.out.println("删除结果：" + deleteRs);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
