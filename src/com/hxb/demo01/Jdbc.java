package com.hxb.demo01;
/* demo0
 *@auth 和学博
 * hxb
 * com.hxb.demo01
 * @time  6:33
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/demo01?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
    static final String USER = "root";
    static final String PASS = "123456";

    public Connection Conn() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}

