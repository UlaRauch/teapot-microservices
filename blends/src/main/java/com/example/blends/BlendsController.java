package com.example.blends;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlendsController {

    @GetMapping("/")
    public String index() {
        return "Hello!";
    }
}
