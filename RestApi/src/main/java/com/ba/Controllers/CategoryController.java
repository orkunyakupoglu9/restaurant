package com.ba.Controllers;

import com.ba.Entities.Category;
import com.ba.Entities.Product;
import com.ba.Repository.CategoryRepository;
import com.ba.Repository.ProductRepository;
import com.ba.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;



    @GetMapping("/list")
    public List<Category> listAllCategories()
    {
        return categoryService.getAllCategory();

    }

    @GetMapping("/{id}")
    public String getCategorybyId(@PathVariable Long id)
    {
        Optional<Category> optionalCategory=categoryRepository.findById(id);

        if(!optionalCategory.isPresent())
        {
            return "no match";
        }

        Category category=optionalCategory.get();

        category.getProducts().forEach(p->{
            System.out.println("Product name"+p.getName());
        });

        return category.toString();

    }

    @GetMapping("/product/{id}")
    public Set<Product> getProductsById(@PathVariable Long id)
    {
        Optional<Category> optionalCategory=categoryRepository.findById(id);

       return optionalCategory.get().getProducts();


    }





    @PostMapping("/add-category")
    public String categoryAdd(@RequestBody Category category)
    {
         categoryService.addCategory(category);

         return category.toString();

    }
    @PostMapping("/add-product/{id}")
    public String addProduct(@RequestBody Product product,@PathVariable Long id)
    {
        Optional <Category> optionalCategory=categoryRepository.findById(id);
        if(!optionalCategory.isPresent()) {
            return "no category";
        }

        Category category1=optionalCategory.get();
        category1.getProducts().add(product);



        categoryRepository.save(category1);

        return category1.toString();


    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id)
    {
        categoryRepository.deleteById(id);

        return "ID:"+id+" and products removed";



    }



}
