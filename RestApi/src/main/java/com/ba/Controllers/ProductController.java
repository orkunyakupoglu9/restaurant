package com.ba.Controllers;

import com.ba.Entities.Product;
import com.ba.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
     private ProductService service;





    @GetMapping("/list")
    public List<Product> listAllProducts()
    {



        return service.getAllProducts();
    }

    @GetMapping("/categories")
    public List<String> lisAllCategories()
    {

       return service.listAllCategories();


    }

    @GetMapping("/categories/{category}")
    public List<Product> listProductsByCategory(@PathVariable String category)
    {

        return service.listProductByCategory(category);
    }





    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product)
    {

        service.addProduct(product);

        return product;

    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id)
    {

        service.deleteProduct(id);

    }

    /*@PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product product)
    {
        Optional<Product> optionalProduct= service.getAllProducts().stream().filter(product1->product.getId()==id).findAny();

        if(optionalProduct==null)
        {
            System.out.println("cannot find the id");
            return null;
        }

        optionalProduct.get().setName(product.getName());
        optionalProduct.get().setDescription(product.getDescription());
        optionalProduct.get().setPrice(product.getPrice());


        return product;

    }*/





}
