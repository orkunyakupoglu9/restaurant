package com.ba.Service;

import com.ba.Entities.Product;
import com.ba.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public List<Product> getAllProducts()
    {


        return repository.findAll();

    }

    public void addProduct(Product product)
    {

        repository.save(product);


    }


    public String deleteProduct(@PathVariable Long id)
    {
        repository.deleteById(id);

        return "ID "+id+" is deleted";
    }


    /*public List<String> listAllCategories()
    {
        List<String> categoryList=new ArrayList<>();

        categoryList=(repository.getAllCategories());


        return categoryList;

    }*/

    /*public List<Product>  listProductByCategory(String categoryName)
    {
        List<Product> productByCategory= new ArrayList<>();

        productByCategory=repository.findCategory(categoryName);

        return productByCategory;

    }*/









}
