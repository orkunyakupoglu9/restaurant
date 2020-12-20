package com.ba.Controllers;


import com.ba.DTO.TableCategoryDTO;
import com.ba.DTO.TablesDTO;
import com.ba.Entities.Tables;
import com.ba.Entities.TableCategory;
import com.ba.Repository.TableCategoryRepository;

import com.ba.Repository.TableRepository;
import com.ba.Service.TableCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/table-category")
public class TableCategoryController {

    @Autowired
    TableCategoryService tableCategoryService;

    @Autowired
    TableCategoryRepository tableCategoryRepository;

   @Autowired
   TableRepository tableRepository;


    @GetMapping("/list")
    public List<TableCategoryDTO> listAllTableCategories()
    {

        return tableCategoryService.getAllTableCategory();

    }


    @PostMapping("/add-tablecategory")
    public String TableCategoryAdd(@RequestBody TableCategoryDTO tableCategoryDto)
    {

        tableCategoryService.addTableCategory(tableCategoryDto);

        return tableCategoryDto.toString();

    }

    @PostMapping("/add-table/{id}")
    public String addTable(@RequestBody TablesDTO tablesDto, @PathVariable Long id)
    {
        ModelMapper modelMapper = new ModelMapper();
        // user here is a prepopulated User instance

        Tables tables = modelMapper.map(tablesDto, Tables.class);


        Optional <TableCategory> optionalCategory=tableCategoryRepository.findById(id);
        if(!optionalCategory.isPresent()) {
            return "no category";
        }

        TableCategory tableCategory1=optionalCategory.get();
        tableCategory1.getTables().add(tables);



        tableCategoryRepository.save(tableCategory1);

        return tableCategory1.toString();


    }

    @GetMapping("/list/table/{id}")
    public Set<Tables> listAllTables(@PathVariable Long id)
    {
        Optional<TableCategory> optionalCategory=tableCategoryRepository.findById(id);
        //optionalCategory.get().getTables();



        return optionalCategory.get().getTables();

    }




   /* @GetMapping("/table/{id}")
    public Set<Tables> getTablesById(@PathVariable Long id)
    {
        Optional<TableCategory> optionalCategory=tableCategoryRepository.findById(id);

        return optionalCategory.get().getTables();

    }*/


}
