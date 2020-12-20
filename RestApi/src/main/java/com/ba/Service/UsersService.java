package com.ba.Service;

import com.ba.DTO.RoleDTO;
import com.ba.DTO.UsersDTO;
import com.ba.Entities.Authorities;
import com.ba.Entities.Role;
import com.ba.Entities.Users;
import com.ba.Repository.AuthorityRepository;
import com.ba.Repository.RoleRepository;
import com.ba.Repository.UsersRepository;
import com.ba.config.UserDetailsImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RoleRepository roleRepository;


    public List<RoleDTO> getAllRoles()
    {

        ModelMapper modelMapper = new ModelMapper();

        List<RoleDTO> roleDTOList=new ArrayList<>();


        List<Role> roleList= roleRepository.findAll();

        roleList.forEach(role -> {
            RoleDTO roleDto = modelMapper.map(role, RoleDTO.class);
            roleDTOList.add(roleDto);
        });


        return roleDTOList;

    }




    public String addUser(UsersDTO userDto)
    {


        ModelMapper modelMapper = new ModelMapper();

        Users user = modelMapper.map(userDto, Users.class);

        UserDetailsImpl userDetails=new UserDetailsImpl(user);

        userDetails.getPassword();
        userDetails.getUsername();
        userDetails.getAuthorities();


        String password=user.getPassword();

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        user.setPassword(encodedPassword);

        if(userDto.getRoles_id()!=null) {
            for (int i = 0; i < userDto.getRoles_id().length; i++) {

                Optional<Role> optionalRole = roleRepository.findById(userDto.getRoles_id()[i]);

                if (!optionalRole.isPresent()) {
                    return "no role";
                }

                Role role1 = optionalRole.get();


               // user.setRoles(Stream.of(role1).collect(Collectors.toSet()));
                user.getRoles().add(role1);


            }
        }
        usersRepository.save(user);


       // usersRepository.save(user);

        return userDto.toString();


    }

    public List<UsersDTO> getAllUsers()
    {

        ModelMapper modelMapper = new ModelMapper();

        List<UsersDTO> userDTOList=new ArrayList<>();


        List<Users> userList= usersRepository.findAll();

        userList.forEach(user -> {
            UsersDTO userDto = modelMapper.map(user, UsersDTO.class);
            userDTOList.add(userDto);
        });


        return userDTOList;

    }

    public String deleteUser(@PathVariable Long id)
    {
        usersRepository.deleteById(id);

        return id+" is deleted";
    }







}
