package com.hxb.demo01;/*
 * demo0
 *@auth 和学博
 * hxb
 * com.hxb.demo01
 * @time  6:33
 */

public class view {
    //头 部
    public void Head() {
        System.out.print("-----------家庭收支记账软件------------- \n" +
                "            1，收支明细        \n " +
                "           2，登记收入        \n " +
                "           3，登记支出        \n " +
                "           4，退 出           \n ");
        System.out.print("          请选择（1-4）:");
    }
    public void line() {
        System.out.println("-----------------------------------------------");
    }
}
