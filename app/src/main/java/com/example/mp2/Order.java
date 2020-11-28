package com.example.mp2;

public class Order {

    String name;
    String time;
    String orderid;
    String driverid;

    public Order(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getDriverid() {
        return driverid;
    }

    public void setDriverid(String driverid) {
        this.driverid = driverid;
    }

    public Order(String name, String time, String orderid, String driverid) {
        this.name = name;
        this.time = time;
        this.orderid = orderid;
        this.driverid = driverid;
    }

}