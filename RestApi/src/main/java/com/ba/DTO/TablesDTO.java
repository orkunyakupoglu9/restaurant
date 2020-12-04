package com.ba.DTO;

public class TablesDTO {

    private long table_id;

    private int table_number;

    private long table_category_id;


    public long getTable_id() {
        return table_id;
    }

    public void setTable_id(long table_id) {
        this.table_id = table_id;
    }

    public int getTable_number() {
        return table_number;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    public long getTable_category_id() {
        return table_category_id;
    }

    public void setTable_category_id(long table_category_id) {
        this.table_category_id = table_category_id;
    }
}