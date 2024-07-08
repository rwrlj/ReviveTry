package com.example.revivetry.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rwr
 * @date 2024.6.6
 */
@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @RequestMapping("/fh")
    public String helloWorld(){
        return "This is a test";
    }


}
