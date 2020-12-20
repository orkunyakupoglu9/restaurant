package com.ba.DTO;

import com.ba.Entities.Category;
import com.ba.Entities.Media;

import java.util.HashSet;
import java.util.Set;

public class ProductDTO {

    private long id;

    private String name;
    private double price;
    private String description;

    private Set<Category> categories;

    private long [] category_id;

    private long media_id;

    private Media media;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public long[] getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long[] category_id) {
        this.category_id = category_id;
    }

    public long getMedia_id() {
        return media_id;
    }

    public void setMedia_id(long media_id) {
        this.media_id = media_id;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
