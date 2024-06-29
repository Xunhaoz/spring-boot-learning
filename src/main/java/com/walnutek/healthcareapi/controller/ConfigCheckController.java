package com.walnutek.healthcareapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigCheckController {

    @Autowired
    private Environment env;

    @GetMapping("/configCheck")
    public String checkConfig() {
        String mapperLocations = env.getProperty("mybatis-plus.mapper-locations");
        return "mybatis-plus.mapper-locations: " + mapperLocations;
    }
}