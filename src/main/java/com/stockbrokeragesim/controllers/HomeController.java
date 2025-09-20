package com.stockbrokeragesim.controllers;
import com.stockbrokeragesim.models.StockOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stockbrokeragesim.services.StockOptionService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {
    @RequestMapping("/") // website root
    public String returnIndexHTML() {
        return "Hello World (index.html)";
    }

    @Autowired
    StockOptionService stockOptionService;

    @GetMapping("/")
    public List<StockOption> getStockOptions() {
        return stockOptionService.getStockOptions();
    }
}

