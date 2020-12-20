package com.ba.Controllers;


import com.ba.DTO.RoleDTO;
import com.ba.DTO.UsersDTO;
import com.ba.Entities.Authorities;
import com.ba.Entities.Product;
import com.ba.Entities.Users;
import com.ba.Repository.AuthorityRepository;
import com.ba.Service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UsersController {


    @Autowired
    private UsersService usersService;



    @GetMapping("/list")
    public List<UsersDTO> listAllUsers()
    {

        return usersService.getAllUsers();


    }

    @GetMapping("/roles-list")
    public List<RoleDTO> listAllRoles()
    {

        return usersService.getAllRoles();


    }




    @PostMapping("/add")
    public String UserAdd(@RequestBody UsersDTO userDto)
    {


        usersService.addUser(userDto);

        return "user "+userDto.toString()+" added";

    }

    @DeleteMapping("/delete/{id}")
    public void UserDelete(@PathVariable Long id)
    {

        usersService.deleteUser(id);

    }






}
