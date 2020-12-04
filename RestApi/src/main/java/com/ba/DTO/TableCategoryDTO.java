package com.ba.DTO;

import com.ba.Entities.Tables;

import java.util.Set;

public class TableCategoryDTO {

    private long table_category_id;

    private String name;

    private int count;

    private Set<Tables> tables;

    public long getTable_category_id() {
        return table_category_id;
    }

    public void setTable_category_id(long table_category_id) {
        this.table_category_id = table_category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<Tables> getTables() {
        return tables;
    }

    public void setTables(Set<Tables> tables) {
        this.tables = tables;
    }
}
