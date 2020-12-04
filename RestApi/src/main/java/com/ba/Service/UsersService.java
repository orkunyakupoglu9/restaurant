package com.ba.Service;

import com.ba.DTO.UsersDTO;
import com.ba.Entities.Authorities;
import com.ba.Entities.Users;
import com.ba.Repository.AuthorityRepository;
import com.ba.Repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;



import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private AuthorityRepository authorityRepository;


   /* ModelMapper modelMapper = new ModelMapper();
    // user here is a prepopulated User instance
    UsersDTO usersDTO = modelMapper.map(user, UsersDTO.class);*/


    @Autowired
    public UsersService(UsersRepository usersRepository)
    {
        this.usersRepository=usersRepository;
        LoadUsers();


    }


    private void LoadUsers()
    {
        usersRepository.save(new Users("admin","{noop}pass1",true));
        usersRepository.save(new Users("user1","{noop}pass2",true));



    }


    public String addUser(Users user)
    {

        usersRepository.save(user);

        return user.toString();


    }

    public List<Users> getAllUsers()
    {


        return usersRepository.findAll();

    }

    public String deleteUser(@PathVariable Long id)
    {
        usersRepository.deleteById(id);

        return id+" is deleted";
    }







}
