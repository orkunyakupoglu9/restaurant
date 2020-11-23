package com.ba.Entities;


import javax.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_id;


    @Column(name="orders_name")
    private String orders_name;



    @Column(name="total_price")
    private double total_price;


    @Column(name="payment_type")
    private String payment_type;

    @Column(name="order_date")
    private Timestamp order_date = new Timestamp(System.currentTimeMillis());


    public Order() {
    }

    public Order(double totalprice, String payment_type, Timestamp order_date) {
        this.total_price = totalprice;
        this.payment_type = payment_type;
        this.order_date = order_date;
    }

    public String getOrders_name() {
        return orders_name;
    }

    public void setOrders_name(String orders_name) {
        this.orders_name = orders_name;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }


}
