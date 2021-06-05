package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")
    private String sayHello() {
        return "Hello, from " + LocalDate.now();
    }
}
