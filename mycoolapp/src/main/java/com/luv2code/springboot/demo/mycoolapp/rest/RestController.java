package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")
    private String sayHello() {
        return "Hello, from " + LocalDate.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Ran a hard 5k!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day";
    }
}
