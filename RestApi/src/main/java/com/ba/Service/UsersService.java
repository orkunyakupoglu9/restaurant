package com.ba.Service;

import com.ba.Entities.Users;
import com.ba.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public void addUser(Users user)
    {

        usersRepository.save(user);


    }

    public List<Users> getAllUsers()
    {


        return usersRepository.findAll();

    }

    public String deleteUser(@PathVariable String username)
    {
        usersRepository.deleteById(username);

        return username+" is deleted";
    }







}
