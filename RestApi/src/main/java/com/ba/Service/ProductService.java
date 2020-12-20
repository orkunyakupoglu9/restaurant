package com.ba.Service;

import com.ba.DTO.ProductDTO;
import com.ba.Entities.Product;
import com.ba.Repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;





    public List<ProductDTO> getAllProducts()
    {
        ModelMapper modelMapper = new ModelMapper();


         List<ProductDTO> productDTOList=new ArrayList<>();


        List<Product> productList= repository.findAll();

        productList.forEach(product -> {
            ProductDTO productDto = modelMapper.map(product, ProductDTO.class);
            productDTOList.add(productDto);
        });



        /*for(long i=1L;i<=repository.count();i++) {

            ProductDTO productDto=modelMapper.map(repository.findById(i).get(),ProductDTO.class);
            productDTOList.add(productDto);

        }*/

        return productDTOList;

    }



    public String addProduct(ProductDTO productDto)
    {
        ModelMapper modelMapper = new ModelMapper();
        // user here is a prepopulated User instance

        Product product=modelMapper.map(productDto,Product.class);

        repository.save(product);




        return productDto.toString();


    }


    public String deleteProduct(@PathVariable Long id)
    {

        repository.deleteById(id);


        return "ID "+id+" is deleted";
    }



}
