package com.ba.Controllers;


import com.ba.Entities.Authorities;
import com.ba.Entities.Product;
import com.ba.Entities.Users;
import com.ba.Repository.AuthorityRepository;
import com.ba.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UsersController {


    @Autowired
    private UsersService usersService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @GetMapping("/list")
    public List<Users> listAllUsers()
    {



        return usersService.getAllUsers();
    }


    @GetMapping("/add/{username}/{password}")
    public String addUser(@PathVariable String username,@PathVariable String password)
    {
        Users user=new Users();
        user.setEnabled(true);
        user.setPassword("{noop}"+password);
        user.setUsername(username);

        usersService.addUser(user);

        Authorities authorities=new Authorities();
        authorities.setAuthority("ROLE_USER");
        authorities.setUsername(username);

        authorityRepository.save(authorities);

        return "user created";

    }




    @PostMapping("/add")
    public Users UserAdd(@RequestBody Users user)
    {

        usersService.addUser(user);

        return user;

    }


}
