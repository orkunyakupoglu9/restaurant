package com.ba.Service;


import com.ba.DTO.TableCategoryDTO;
import com.ba.Entities.TableCategory;
import com.ba.Repository.TableCategoryRepository;
import com.ba.Repository.TableRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableCategoryService {

    @Autowired
    TableCategoryRepository tableCategoryRepository;

    @Autowired
    TableRepository tableRepository;

    public List<TableCategoryDTO> getAllTableCategory()
    {
        ModelMapper modelMapper = new ModelMapper();
        // user here is a prepopulated User instance
        List<TableCategoryDTO> tableCategoryDTOList=new ArrayList<>();

        for(long i=1L;i<=tableCategoryRepository.count();i++) {

            TableCategoryDTO tableCategoryDto=modelMapper.map(
                    tableCategoryRepository.findById(i).get(),TableCategoryDTO.class);

            tableCategoryDTOList.add(tableCategoryDto);


        }

        return tableCategoryDTOList;

    }


    public String addTableCategory(TableCategoryDTO tableCategoryDto)
    {
        ModelMapper modelMapper = new ModelMapper();
        // user here is a prepopulated User instance

        TableCategory tableCategory=modelMapper.map(tableCategoryDto,TableCategory.class);

        tableCategoryRepository.save(tableCategory);


        return tableCategoryDto.toString();


    }








}
