package com.example.mp2;

public class order1 {
    String name;
    int time;
    int driverid;
    int orderid;

    public order1(){};
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDriverid() {
        return driverid;
    }

    public void setDriverid(int driverid) {
        this.driverid = driverid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public order1(String name, int time, int driverid, int orderid) {
        this.name = name;
        this.time = time;
        this.driverid = driverid;
        this.orderid = orderid;
    }

}
