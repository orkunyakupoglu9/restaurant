package com.ba.Repository;

import com.ba.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

   /* @Query("Select DISTINCT category From Product")
    public List<String> getAllCategories();

    @Query("SELECT p from Product p Where p.category=:categoryName")
    public List <Product>findCategory(String categoryName);*/


}
