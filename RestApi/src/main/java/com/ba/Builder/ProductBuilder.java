package com.ba.Builder;

import com.ba.Entities.Category;
import com.ba.Entities.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductBuilder {

    private long id;

    private String name;
    private double price;
    private String description;
    private Set<Category> categories;

    public ProductBuilder categories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public ProductBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder id(long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder price(double price) {
        this.price = price;
        return this;
    }

    public Product build(){

        Product product=new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setCategories(this.categories);

        return product;

    }





}
