package com.james.springbootoauth2starter.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping("/hello")
    public String hello() {
        return "{\"Message\": \"Hello World!\"}";
    }

    @RequestMapping("/secure")
    public String secure() {
        return "{\"Message\": \"Secure!\"}";
    }
}
