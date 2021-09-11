package com.hxb.demo01;

import java.util.Scanner;
import java.util.regex.Pattern;

public class FamilyAccount {
    Scanner scanner = new Scanner(System.in);
    //头 部
    public void Head() {
        System.out.println("-----------家庭收支记账软件--------- \n" +
                "           1，收支明细        \n " +
                "           2，登记收入        \n " +
                "           3，登记支出        \n " +
                "           4，退 出           \n ");
        System.out.print("  请选择（1-4）:");
    }

    public void line() {
        System.out.println("--------------------------");
    }
//检查是否字符串
    public void checkString(String n1) {
        Pattern pattern = Pattern.compile("[0-9]*");
        if (pattern.matcher(n1).matches()){
              check_number(Integer.parseInt(n1));
        }else{
            System.out.println("错误，不是数字");
            System.out.println("请输入1-4：");
             String t=   scanner.nextLine();
             checkString(t);
        }
    }
    //检查是否数字
    public void check_number(int n_number){
        if (n_number > 4 || n_number < 1) {
            System.out.print("错误，不是1-4，请输入1-4：");
            String n_1=   scanner.nextLine();
            FamilyAccount familyAccount = new FamilyAccount();
            familyAccount.checkString(n_1);
        } else {
            System.out.println("输入正确");
        }
    }
//主函数
    public static void main(String[] args) {
        FamilyAccount familyAccount = new FamilyAccount();
        Scanner scanner = new Scanner(System.in);
        familyAccount.Head();
        String n = scanner.nextLine();
          familyAccount.checkString(n);
    }


}
