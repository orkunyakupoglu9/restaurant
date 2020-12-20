package com.ba.Builder;

import com.ba.Entities.Waiter;

public class WaiterBuilder {


    private long waiter_id;

    private String name;
    private String surname;

    public WaiterBuilder name(String name) {
        this.name = name;
        return this;
    }

    public WaiterBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public WaiterBuilder waiter_id(long waiter_id) {
        this.waiter_id = waiter_id;
        return this;
    }

    public Waiter build(){

        Waiter waiter=new Waiter();

        waiter.setName(this.name);
        waiter.setSurname(this.surname);
        waiter.setWaiter_id(this.waiter_id);


        return waiter;


    }






}
