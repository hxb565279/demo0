package com.hxb.demo01;
/* demo0
 *@auth 和学博
 * hxb
 * com.hxb.demo01
 * @time  6:33
 */

import java.sql.*;
import java.util.Scanner;
/*
  遍历查询
  获取最后一次
  收入
  支出
 */

public class AccountDao {
    Scanner scanner = new Scanner(System.in);
    Jdbc jdbc = new Jdbc();
    view view = new view();
    checkDao checkDao = new checkDao();

    //遍历查询
    public void select() throws SQLException, ClassNotFoundException {
        Connection connection;
        Statement statement;
        String sql = "select * from account";
        connection = jdbc.Conn();
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        System.out.println("---------当前收支记录明细--------------------");
        System.out.println("-------    收支  余额  收支金额  说明  ---");
        while (rs.next()) {
            String shouzhi = rs.getString("shouzhi");
            String yu_e = rs.getString("yu_e");
            String jin_e = rs.getString("jin_e");
            String shuoming = rs.getString("shuoming");
            System.out.println("          " + shouzhi + "   " + yu_e + "   " + jin_e + "   " + shuoming);
        }
        view.line();
        checkDao.hu();
    }

    //获取最后一次余额
    public Account select_yu() throws SQLException, ClassNotFoundException {
        Connection connection;
        Statement statement;
        String sql = "select * from account order by id DESC limit 1";
        connection = jdbc.Conn();
        statement = connection.createStatement();
        ResultSet rs1 = statement.executeQuery(sql);
        Account account = new Account();
        while (rs1.next()) {
            account.setId(rs1.getInt("id"));
            account.setShouzhi(rs1.getString("shouzhi"));
            account.setYu_e(rs1.getString("yu_e"));
            account.setJin_e(rs1.getString("jin_e"));
            account.setShuoming(rs1.getString("shuoming"));
        }
        return account;
    }

    //收入
    public void in(String yu, String sh) throws SQLException, ClassNotFoundException {
        Connection connection = jdbc.Conn();
        String sql = "insert into account(shouzhi,yu_e,jin_e,shuoming) value ('收入',?,?,?)";
        int yu_all = Integer.parseInt(select_yu().getYu_e()) + Integer.parseInt(yu);
        common(yu, sh, connection, sql, yu_all);
    }


    //支出
    public void out(String zhi, String sh) throws SQLException, ClassNotFoundException {
        Connection connection = jdbc.Conn();
        String sql = "insert into account(shouzhi,yu_e,jin_e,shuoming) value ('支出',?,?,?)";
        int yu_all_3 = Integer.parseInt(select_yu().getYu_e()) - Integer.parseInt(zhi);
        common(zhi, sh, connection, sql, yu_all_3);
    }

    //公共
    public void common(String yu, String sh, Connection connection, String sql, int yu_all) throws SQLException, ClassNotFoundException {
        PreparedStatement statement;
        String yu_all_1 = Integer.toString(yu_all);
        statement = connection.prepareStatement(sql);
        statement.setString(1, yu_all_1);
        statement.setString(2, yu);
        statement.setString(3, sh);
        statement.executeUpdate();
        System.out.println("登记成功");
        checkDao.hu();
    }
}
