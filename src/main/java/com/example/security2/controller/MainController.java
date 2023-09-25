package com.example.security2.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/test")
    public String test() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/static/signup_form.html");

        System.out.println(resource.getURI());
        return "test success";
    }

}
