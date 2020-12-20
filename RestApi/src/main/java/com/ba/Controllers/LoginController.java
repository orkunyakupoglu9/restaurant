package com.ba.Controllers;


import com.ba.DTO.UsersDTO;
import com.ba.Entities.Users;
import com.ba.Repository.UsersRepository;
import com.ba.Service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.mindrot.jbcrypt.BCrypt;


import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/check")
    private String isValid(@RequestBody Users user)
    {

         String validation ="false";

        /*ModelMapper modelMapper = new ModelMapper();

        Users user = modelMapper.map(userDto, Users.class);*/

        String username=user.getUsername();
        String password=user.getPassword();

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);







        List<Users> userList= usersRepository.findAll();


        for(int i=0;i<userList.size();i++)
        {

            if(userList.get(i).getUsername().equals(username)&&BCrypt.checkpw(password,userList.get(i).getPassword()))
            {
                validation="true";
                break;
            }

            else{

                validation="false";
            }


        }



        return validation;

    }







}
