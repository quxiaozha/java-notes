package com.quxun.jdbc;

import java.sql.*;

/**
 * @Author quxiaozha
 * Description:jdbc连oracle笔记
 * Created by quxiaozha on 2018-9-3.
 */
public class JdbcDemoForOracle {
    public static void main(String[] args) {
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String dbURL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
            conn = DriverManager.getConnection(dbURL, "oracle", "oracle");
            System.out.println(conn.getTypeMap());
            System.out.println("连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
