package de.jonashackt.springboot2exe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springboot2exe")
public class Controller {

    public static final String RESPONSE = "Hello crazy Windows User!";
    
    @RequestMapping(path="/hello", method=RequestMethod.GET)
    public String helloWorld() {
        System.out.println("Rocking REST!");
    	return RESPONSE;
    }
}
