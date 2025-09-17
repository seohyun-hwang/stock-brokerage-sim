package com.stockbrokeragesim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/") // website root
    public String returnIndexHTML() {
        return "index.html";
    }
}
