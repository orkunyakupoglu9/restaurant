package com.ba.Controllers;


import org.springframework.beans.factory.annotation.Value;
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

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${logging.level.org.hibernate.type}")
    private String hibernateType;


    @GetMapping("/server")
    public List<String> getServerInfo()
    {
        List<String> infoList=new ArrayList<>();
        infoList.add(serverPort);
        infoList.add(driver);
        infoList.add(ddlAuto);
        infoList.add(datasourceUrl);
        infoList.add(hibernateType);


        return infoList;

    }









}
