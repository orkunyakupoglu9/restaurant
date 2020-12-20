package com.ba.DTO;

import com.ba.Entities.Tables;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

public class OrderDTO {

    private long order_id;

    private String orders_name;
    private double total_price;
    private String payment_type;
    private Timestamp order_date = new Timestamp(System.currentTimeMillis());

    private Tables table;

    private long waiter_id;




    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getOrders_name() {
        return orders_name;
    }

    public void setOrders_name(String orders_name) {
        this.orders_name = orders_name;
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

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public Tables getTable() {
        return table;
    }

    public void setTable(Tables table) {
        this.table = table;
    }

    public long getWaiter_id() {
        return waiter_id;
    }

    public void setWaiter_id(long waiter_id) {
        this.waiter_id = waiter_id;
    }
}
