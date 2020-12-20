package com.ba.Controllers;

import com.ba.DTO.ProductDTO;
import com.ba.Entities.Product;
import com.ba.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
     private ProductService service;





    @GetMapping("/list")
    public List<ProductDTO> listAllProducts()
    {



        return service.getAllProducts();
    }



    @PostMapping("/add")
    public String addProduct(@RequestBody ProductDTO productDto)
    {
        /*ModelMapper modelMapper = new ModelMapper();
        // user here is a prepopulated User instance

        Product product = modelMapper.map(productDto, Product.class);*/

        service.addProduct(productDto);

        return productDto.toString();

    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id)
    {

        service.deleteProduct(id);

        return "ID:"+id+"removed";

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
