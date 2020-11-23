package com.ba.Controllers;


import com.ba.Repository.AuthorityRepository;
import com.ba.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HelloController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AuthorityRepository authorityRepository;





    @GetMapping("/user")
    public String sayHelloforUser(){

        return "Hi from USER";


    }

    @GetMapping("/admin")
    public String sayHelloForAdmin(){

        return "Hi from ADMIN";

    }




}
