package com.hxb.demo01;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

class Jdbc {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/demo01?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=UTF-8";
    static final String USER = "root";
    static final String PASS = "123456";

    public Connection Conn() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static void main(String[] args) {
        Jdbc jdbc = new Jdbc();
        try {
            jdbc.Conn();
            System.out.println("成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


public class FamilyAccount {
    Scanner scanner = new Scanner(System.in);
    Jdbc jdbc = new Jdbc();

    //头 部
    public void Head() {
        System.out.print("-----------家庭收支记账软件------------- \n" +
                "            1，收支明细        \n " +
                "           2，登记收入        \n " +
                "           3，登记支出        \n " +
                "           4，退 出           \n ");
        System.out.print("          请选择（1-4）:");
    }

    //遍历查询
    public void select() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;
        String sql = "select * from aling";
        connection = jdbc.Conn();
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        // 展开结果集数据库
        System.out.println("---------当前收支记录明细--------------------");
        System.out.println("-------     收支  收支余额  收支金额  说明  ---");
        while (rs.next()) {
            int id = rs.getInt("id");
            String shouzhi = rs.getString("shouzhi");
            String yu_e = rs.getString("yu_e");
            String jin_e = rs.getString("jin_e");
            String shuoming = rs.getString("shuoming");
            System.out.println("          " + shouzhi + "   " + yu_e + "   " + jin_e + "   " + shuoming);
        }
        line();
        hu();
    }

    //获取最后一次余额
    public Account select_yu() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;
        String sql = "select * from aling order by id DESC limit 1";
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
        PreparedStatement stmt = null;
        PreparedStatement statement = null;
        String sql = "insert into aling(shouzhi,yu_e,jin_e,shuoming) value ('收入',?,?,?)";
        Account account = new Account();
        int yu_e = Integer.parseInt(select_yu().getYu_e());
        int yu_2 = Integer.parseInt(yu);
        int yu_all = yu_e + yu_2;
        String yu_all_1 = Integer.toString(yu_all);
        statement = connection.prepareStatement(sql);
        statement.setString(1, yu_all_1);
        statement.setString(2, yu);
        statement.setString(3, sh);
        statement.executeUpdate();
        System.out.println("登记成功");
        hu();
    }

    //支出
    public void out(String zhi, String sh) throws SQLException, ClassNotFoundException {
        Connection connection = jdbc.Conn();
        PreparedStatement statement = null;
        String sql = "insert into aling(shouzhi,yu_e,jin_e,shuoming) value ('支出',?,?,?)";
        int yu_all_3 = Integer.parseInt(select_yu().getYu_e()) - Integer.parseInt(zhi);
        String yu_all_2 = Integer.toString(yu_all_3);
        statement = connection.prepareStatement(sql);
        statement.setString(1, yu_all_2);
        statement.setString(2, zhi);
        statement.setString(3, sh);
        statement.executeUpdate();
        System.out.println("登记成功");
        hu();
    }

    public void line() {
        System.out.println("-----------------------------------------------");
    }

    public void check_input(int number) throws SQLException, ClassNotFoundException {
        switch (number) {
            case 1:
                select();
                break;
            case 2:
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入收入金额:");
                String shouru = scanner.nextLine();
                System.out.print("请输入说明：");
                String shuoming = scanner.nextLine();
                in(shouru, shuoming);
                break;
            case 3:
                Scanner scanner1 = new Scanner(System.in);
                System.out.print("请输入支出金额:");
                String shouru1 = scanner1.nextLine();
                System.out.print("请输入说明：");
                String shuoming1 = scanner1.nextLine();
                out(shouru1, shuoming1);
                break;
            case 4:
                System.out.println("结束");
                break;
            default:
                System.out.println("输入错误");
                break;
        }
    }

    //检查是否字符串
    public void checkString(String n1) throws SQLException, ClassNotFoundException {
        Pattern pattern = Pattern.compile("[0-9]*");
        if (pattern.matcher(n1).matches()) {
            check_number(Integer.parseInt(n1));
        } else {
            System.out.println("错误，不是数字");
            System.out.println("请输入1-4：");
            String t = scanner.nextLine();
            checkString(t);
        }
    }

    //检查是否数字
    public void check_number(int n_number) throws SQLException, ClassNotFoundException {
        if (n_number > 4 || n_number < 1) {
            System.out.print("错误，不是1-4，请输入1-4：");
            String n_1 = scanner.nextLine();
            FamilyAccount familyAccount = new FamilyAccount();
            familyAccount.checkString(n_1);
        } else {
            check_input(n_number);
        }
    }

    //回调
    public void hu() throws SQLException, ClassNotFoundException {
        FamilyAccount familyAccount = new FamilyAccount();
        Scanner scanner = new Scanner(System.in);
        familyAccount.Head();
        String n = scanner.nextLine();
        familyAccount.checkString(n);
    }

    //主函数
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        FamilyAccount familyAccount = new FamilyAccount();
        familyAccount.hu();
    }
}
