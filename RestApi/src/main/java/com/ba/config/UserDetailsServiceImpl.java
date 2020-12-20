package com.ba.config;


import com.ba.Entities.Users;
import com.ba.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user=usersRepository.getUsersByUsername(username);

        if(user==null){

            throw new UsernameNotFoundException("could not find username");


        }

        return new UserDetailsImpl(user);




    }
}
