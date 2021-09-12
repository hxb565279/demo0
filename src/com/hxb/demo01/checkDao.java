package com.hxb.demo01;/*
 * demo0
 *@auth 和学博
 * hxb
 * com.hxb.demo01
 * @time  10:08
 */

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class checkDao {
    static AccountDao accountDao = new AccountDao();
    static Scanner scanner = new Scanner(System.in);
    public static String t = "1";

    public static void check_input(int number) throws SQLException, ClassNotFoundException {
        switch (number) {
            case 1:
                accountDao.select();
                break;
            case 2:
                Scanner scanner = new Scanner(System.in);
                System.out.print("输入本次收入金额:");
                 t = scanner.nextLine();
                checkDao.check_number2(t);
                System.out.print("输入本次说明：");
                String shuoming = scanner.nextLine();
                accountDao.in(t, shuoming);
                break;
            case 3:
                Scanner scanner1 = new Scanner(System.in);
                System.out.print("输入本次支出金额:");
                t = scanner1.nextLine();
                checkDao.check_number2(t);
                System.out.print("输入本次说明：");
                String shuoming1 = scanner1.nextLine();
                accountDao.out(t, shuoming1);
                break;
            case 4:
                System.out.println("结束");
                break;
            default:
                System.out.println("输入错误");
                break;
        }
    }

    //检查数字符合
    public static void check_number2(String n1) throws SQLException, ClassNotFoundException {
        Pattern pattern = Pattern.compile("[0-9]*");
        if (pattern.matcher(n1).matches()) {

        } else {
            System.out.print("错误,不是数字，请输入：");
             t = scanner.nextLine();
            check_number2(t);
        }
    }

    //检查是否数字_1-4
    public static void checkString(String n1) throws SQLException, ClassNotFoundException {
        Pattern pattern = Pattern.compile("[0-9]*");
        if (pattern.matcher(n1).matches()) {
            check_number(Integer.parseInt(n1));
        } else {
            System.out.println("错误，不是数字;请输入1-4：");
            String t = scanner.nextLine();
            checkString(t);
        }
    }

    //检查是否数字符合
    public static void check_number(int n_number) throws SQLException, ClassNotFoundException {
        if (n_number > 4 || n_number < 1) {
            System.out.print("错误，不是1-4，请输入1-4：");
            String n_1 = scanner.nextLine();
            checkString(n_1);
        } else {
            checkDao.check_input(n_number);
        }
    }


    public void hu() throws SQLException, ClassNotFoundException {
        view view = new view();
        Scanner scanner = new Scanner(System.in);
        view.Head();
        String n = scanner.nextLine();
        checkString(n);
    }
}

