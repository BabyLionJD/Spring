package com.likelion.likelionspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @GetMapping("/hello/{name}")
    public String name(@PathVariable String name){
        return "hello " + name;
    }
}
