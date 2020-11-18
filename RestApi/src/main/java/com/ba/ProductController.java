package com.ba;

import com.ba.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
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

    @PutMapping("/update/{id}")
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

    }












}
