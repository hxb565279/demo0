package com.hxb.demo01;

public class Account {
    private int id;
    private String shouzhi;
    private String yu_e;
    private String jin_e;
    private String shuoming;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", shouzhi='" + shouzhi + '\'' +
                ", yu_e='" + yu_e + '\'' +
                ", jin_e='" + jin_e + '\'' +
                ", shuoming='" + shuoming + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShouzhi() {
        return shouzhi;
    }

    public void setShouzhi(String shouzhi) {
        this.shouzhi = shouzhi;
    }

    public String getYu_e() {
        return yu_e;
    }

    public void setYu_e(String yu_e) {
        this.yu_e = yu_e;
    }

    public String getJin_e() {
        return jin_e;
    }

    public void setJin_e(String jin_e) {
        this.jin_e = jin_e;
    }

    public String getShuoming() {
        return shuoming;
    }

    public void setShuoming(String shuoming) {
        this.shuoming = shuoming;
    }
}
