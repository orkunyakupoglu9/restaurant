package com.ba.Builder;


import com.ba.Entities.Order;
import com.ba.Entities.Tables;

import java.sql.Timestamp;

public class OrderBuilder {

    private long order_id;

    private String orders_name;

    private double total_price;

    private String payment_type;

    private Timestamp order_date = new Timestamp(System.currentTimeMillis());

    private long waiter_id;

    private Tables table;


    public OrderBuilder order_date(Timestamp order_date) {
        this.order_date = order_date;
        return this;
    }

    public OrderBuilder order_id(long order_id) {
        this.order_id = order_id;
        return this;
    }

    public OrderBuilder orders_name(String orders_name) {
        this.orders_name = orders_name;
        return this;
    }

    public OrderBuilder payment_type(String payment_type) {
        this.payment_type = payment_type;
        return this;
    }

    public OrderBuilder table(Tables table) {
        this.table = table;
        return this;
    }

    public OrderBuilder total_price(double total_price) {
        this.total_price = total_price;
        return this;
    }

    public OrderBuilder waiter_id(long waiter_id) {
        this.waiter_id = waiter_id;
        return this;
    }

    public Order build(){

        Order order=new Order();
        order.setOrder_id(this.order_id);
        order.setOrder_date(this.order_date);
        order.setPayment_type(this.payment_type);
        order.setOrders_name(this.orders_name);
        order.setTable(this.table);
        order.setTotal_price(this.total_price);
        order.setWaiter_id(this.waiter_id);

        return order;

    }







}
