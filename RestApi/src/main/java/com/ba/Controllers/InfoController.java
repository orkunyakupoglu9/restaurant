package com.ba.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/info")
public class InfoController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.datasource.driverClassName}")
    private String driver;


    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${logging.level.org.hibernate.type}")
    private String hibernateType;

    @Value("${spring.profiles.active:Unknown}")
    private String profile_active;

    @Value("${spring.application.name}")
    private String profile;




    @Autowired
    Environment env;



    @GetMapping("/server")
    public List<String> getServerInfo()
    {
        List<String> infoList=new ArrayList<>();

        infoList.add(profile);
        infoList.add(serverPort);
        infoList.add(driver);
        infoList.add(datasourceUrl);
        infoList.add(hibernateType);


        return infoList;

    }
    /*@GetMapping("/mode")
    public String showProfile()
    {

       env.getActiveProfiles();




return "sa";


    }*/





}
