package com.redolf.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    private String home(){
        return "{ home: Welcome to my application }";
    }

    @GetMapping("/{name}")
    public String welcome(@PathVariable String name){
        return "Welcome to my application "+name;
    }

    @GetMapping("/logout")
    public String logout(){
        return "Logging out from system!";
    }


    @GetMapping("/login")
    public String login(){
        return "Logging in into system!";
    }

}
