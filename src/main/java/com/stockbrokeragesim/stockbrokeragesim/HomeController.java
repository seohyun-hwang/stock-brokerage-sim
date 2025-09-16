package com.stockbrokeragesim.stockbrokeragesim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/") // website root
    public String indexHTML() {
        return "index.html";
    }
}
