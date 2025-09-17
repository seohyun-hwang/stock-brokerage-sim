package com.stockbrokeragesim.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/") // website root
    public String returnIndexHTML(Model model) {
        model.addAttribute("stockTickerSymbol","");
        return "index";
    }
}
