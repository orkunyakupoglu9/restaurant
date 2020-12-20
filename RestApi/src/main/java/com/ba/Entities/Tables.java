package com.ba.Entities;

import javax.persistence.*;

@Entity
@Table(name = "TABLES")
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long table_id;

    private int table_number;



    public Tables() {
    }


    public Tables(int table_number) {
        this.table_number = table_number;
    }



    public int getTable_number() {
        return table_number;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    public long getTable_id() {
        return table_id;
    }

    public void setTable_id(long table_id) {
        this.table_id = table_id;
    }


}
