package com.ba.Entities;


import javax.persistence.*;
import java.util.Set;

@Entity
public class TableCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long table_category_id;

    private String name;

    private int count;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="table_category_id")
    private Set<Tables> tables;


    public TableCategory() {
    }

    public TableCategory(String name, int count, Set<Tables> tables) {
        this.name = name;
        this.count = count;
        this.tables = tables;
    }

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

    public Set<Tables> getTables() {
        return tables;
    }

    public void setTables(Set<Tables> tables) {
        this.tables = tables;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
