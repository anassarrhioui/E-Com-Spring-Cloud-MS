package me.arrhioui.securityservice.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {


    @GetMapping("/test")
    public String test(){
        return "Hello world";
    }
}
