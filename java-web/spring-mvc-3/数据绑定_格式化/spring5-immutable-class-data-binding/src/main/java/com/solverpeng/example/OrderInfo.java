package com.solverpeng.example;

public class OrderInfo {
    private final String id;
    private final String zip;

    public OrderInfo(String id, String zip) {
        this.id = id;
        this.zip = zip;
    }

    public String getId() {
        return id;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id='" + id + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
