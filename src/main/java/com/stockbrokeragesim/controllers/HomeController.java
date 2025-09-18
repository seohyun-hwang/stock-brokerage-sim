package com.stockbrokeragesim.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/") // website root
    public String returnIndexHTML() {
        return "Hello World";
    }
}
