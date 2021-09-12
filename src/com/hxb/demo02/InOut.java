package com.hxb.demo02;

import java.util.Scanner;


public class InOut {

    static int amount = 10000;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        printf_1();
    }

    static Info[] box = new Info[20];

    private static void printf_1() {
        // TODO Auto-generated method stub
        System.out.println("Select as you want:");
        System.out.println("1.Add a piece of new In.");
        System.out.println("2.Add a piece of new out");
        System.out.println("3.Print information of all.");
        System.out.println("4.Exit.");
        String judgment = sc.next();
        switch (judgment) {
            case "1":
                printf_add("in");
                break;
            case "2":
                printf_add("out");
                break;
            case "3":
                printf_all();
                break;
            case "4":
                System.out.println("~~~");
                return;
            default:
                System.out.println("Error! Agine.");
        }
        printf_1();
    }

    private static void printf_all() {
        // TODO Auto-generated method stub
        if (box[0] == null) return;
        System.out.println("InOrOut	money	amount	explianment");
        for (int i = 0; box[i] != null; i++) {
            System.out.println(box[i].getKind() + "	" + box[i].getMoney() + "	"
                    + box[i].getPre_money() + "	" + box[i].getExp());
        }
    }

    private static void printf_add(String kind) {
        // TODO Auto-generated method stub
        System.out.println("Input amount of money.");
        String money = sc.next();
        try {
        } catch (Exception e) {
            System.out.println("Error! Agine.");
            printf_add(kind);
            return;
        }
        System.out.println("Input explianment.");
        String add_exp = sc.next();
        int add_money = Integer.parseInt(money);
        int i;
        for (i = 0; box[i] != null; i++) {
        }

        switch (kind) {
            case "in":
                amount += add_money;
                break;
            case "out":
                amount -= add_money;
                break;
        }

        box[i] = new Info(kind, add_money, amount, add_exp);
        System.out.println("~");
    }

}


class Info {
    String kind;

    public Info(String kind, int money, int pre_money, String exp) {
        super();
        this.kind = kind;
        this.money = money;
        this.pre_money = pre_money;
        this.exp = exp;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPre_money() {
        return pre_money;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    int money;
    int pre_money;
    String exp;
}