package org.nh.gome.demo.db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: JdbcDemo.java
 * @description:
 * @author: yindanqing
 * @create: 2020/1/8 20:30
 */
public class JdbcDemo {

    private static final String CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://cdb-1v2wt3os.bj.tencentcdb.com:10243/mvc?useUnicode=true&characterEncoding=UTF8";
    private static final String USER = "user_dev";
    private static final String PWD = "user_dev_nh";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName(CLASS_NAME);
        try(Connection conn = DriverManager.getConnection(URL, USER, PWD);
            PreparedStatement psmt = conn.prepareStatement("select * from nums");
            ResultSet resultSet = psmt.executeQuery()
        ) {
            while (resultSet.next()){
                Integer setInt = resultSet.getInt("num");
                System.out.println(setInt);
                System.out.println(resultSet.getClob("num").length());
                BigDecimal bigDecimal = resultSet.getBigDecimal("num");
                System.out.println(bigDecimal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
