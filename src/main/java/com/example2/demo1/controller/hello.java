package com.example2.demo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @RequestMapping("/hello")
    public String index() {
        return  "Hello Spring boot";
    }
}
