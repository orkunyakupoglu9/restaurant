package com.ba.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("server.port")
@SuppressWarnings("unused")
public class PortConfiguration {

    private String port;

    @Profile("dev")
    @Bean
    public String changePortDev()
    {
        System.out.println("Port changed");

        return "Port is now 8081";

    }
    @Profile("production")
    @Bean
    public String changePortProduction()
    {
        System.out.println("Port changed");

        return "Port is now 8082";

    }










}
