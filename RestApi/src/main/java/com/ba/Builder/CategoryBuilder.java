package com.ba.Builder;

import com.ba.Entities.Category;
import com.ba.Entities.Product;

import java.util.Set;

public class CategoryBuilder {

    private long category_id;

    private String name;
    private String description;
    private String image_url;

    private Set<Product> products;


    public CategoryBuilder category_id(long category_id) {
        this.category_id = category_id;
        return this;
    }

    public CategoryBuilder description(String description) {
        this.description = description;
        return this;
    }

    public CategoryBuilder image_url(String image_url) {
        this.image_url = image_url;
        return this;
    }

    public CategoryBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CategoryBuilder products(Set<Product> products) {
        this.products = products;
        return this;
    }

    public Category build(){

        Category category=new Category();
        category.setCategory_id(this.category_id);
        category.setDescription(this.description);
        category.setImage_url(this.image_url);
        category.setProducts(this.products);

        return category;

    }


}
