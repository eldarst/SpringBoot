package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/getTeamFortune")
	public String teamFortune() {
		return "To coach " + coachName + " ";
	}
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
