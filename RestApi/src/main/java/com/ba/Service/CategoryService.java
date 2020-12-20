package com.ba.Service;


import com.ba.DTO.CategoryDTO;
import com.ba.Entities.Category;
import com.ba.Entities.Product;
import com.ba.Repository.CategoryRepository;
import com.ba.Repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public List<CategoryDTO> getAllCategory()
    {
        ModelMapper modelMapper = new ModelMapper();

        List<CategoryDTO> categoryDTOList=new ArrayList<>();

         List<Category> categories= categoryRepository.findAll();

        categories.forEach(category -> {
            CategoryDTO categoryDto = modelMapper.map(category, CategoryDTO.class);
            categoryDTOList.add(categoryDto);
        });


       /* for(long i=1L;i<=categoryRepository.count();i++) {


                CategoryDTO categoryDto = modelMapper.map(categoryRepository.findById(i).get(), CategoryDTO.class);
                categoryDTOList.add(categoryDto);
        }*/

        return categoryDTOList;

    }

    public String addCategory(CategoryDTO categoryDto)
    {
        ModelMapper modelMapper = new ModelMapper();


        Category category=modelMapper.map(categoryDto,Category.class);



        categoryRepository.save(category);


        return categoryDto.toString();


    }




}
