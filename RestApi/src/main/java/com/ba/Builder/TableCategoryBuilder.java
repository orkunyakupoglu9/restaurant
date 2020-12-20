package com.ba.Builder;

import com.ba.Entities.TableCategory;
import com.ba.Entities.Tables;

import java.util.Set;

public class TableCategoryBuilder {

    private long table_category_id;

    private String name;

    private int count;

    private Set<Tables> tables;

    public TableCategoryBuilder count(int count) {
        this.count = count;
        return this;
    }

    public TableCategoryBuilder name (String name) {
        this.name = name;
        return this;
    }

    public TableCategoryBuilder table_category_id(long table_category_id) {
        this.table_category_id = table_category_id;
        return this;
    }

    public TableCategoryBuilder tables(Set<Tables> tables) {
        this.tables = tables;
        return this;
    }

    public TableCategory build(){

        TableCategory tableCategory=new TableCategory();

        tableCategory.setTable_category_id(this.table_category_id);
        tableCategory.setName(this.name);
        tableCategory.setCount(this.count);
        tableCategory.setTables(this.tables);


        return tableCategory;

    }





}
