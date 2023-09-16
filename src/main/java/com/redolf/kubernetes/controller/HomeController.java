package com.redolf.kubernetes.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home(){
        return "Welcome to my application";
    }

    @GetMapping("/{name}")
    @ResponseBody
    public String welcome(@PathVariable String name){
        return "Welcome to my application "+name;
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout(){
        return "Logging out from system!";
    }


    @GetMapping("/login")
    @ResponseBody
    public String login(){
        return "Logging in into system!";
    }

}
