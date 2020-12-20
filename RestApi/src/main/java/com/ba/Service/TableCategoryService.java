package com.ba.Service;


import com.ba.DTO.TableCategoryDTO;
import com.ba.Entities.TableCategory;
import com.ba.Entities.Tables;
import com.ba.Repository.TableCategoryRepository;
import com.ba.Repository.TableRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TableCategoryService {

    @Autowired
    TableCategoryRepository tableCategoryRepository;

    @Autowired
    TableRepository tableRepository;

    public List<TableCategoryDTO> getAllTableCategory()

    {
        ModelMapper modelMapper = new ModelMapper();

        List<TableCategoryDTO> tableCategoryDTOList=new ArrayList<>();

        List<TableCategory> tableCategoryList= tableCategoryRepository.findAll();

        tableCategoryList.forEach(tableCategory -> {
            TableCategoryDTO tableCategoryDto = modelMapper.map(tableCategory, TableCategoryDTO.class);
            tableCategoryDTOList.add(tableCategoryDto);
        });




       /* for(long i=1L;i<=tableCategoryRepository.count();i++) {

            TableCategoryDTO tableCategoryDto=modelMapper.map(
                    tableCategoryRepository.findById(i).get(),TableCategoryDTO.class);

            tableCategoryDTOList.add(tableCategoryDto);


        }*/

        return tableCategoryDTOList;

    }


    public String addTableCategory(TableCategoryDTO tableCategoryDto)
    {
        ModelMapper modelMapper = new ModelMapper();
        // user here is a prepopulated User instance

        TableCategory tableCategory=modelMapper.map(tableCategoryDto,TableCategory.class);


        int count=tableCategory.getCount();

        Set<Tables> tables = new HashSet<>();


        for(int i=1;i<=count;i++)
        {
            Tables table=new Tables(i);
            tables.add(table);
            tableCategory.setTables(tables);
            tableRepository.save(table);

        }

        tableCategoryRepository.save(tableCategory);





        return tableCategoryDto.toString();


    }



}
