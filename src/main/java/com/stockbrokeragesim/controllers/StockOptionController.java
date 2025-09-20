package com.stockbrokeragesim.controllers;
import com.stockbrokeragesim.models.StockOption;
import com.stockbrokeragesim.services.StockOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StockOptionController {
    @RequestMapping("/stock-display")
    public String returnStockDisplayHTML() {
        return "Hello World (stock-display.html)";
    }

    @Autowired
    StockOptionService stockOptionService;



    @PostMapping("/")
    public void addOrderDetails(@RequestBody StockOption stockOption) {
        stockOptionService.addStockOption(stockOption);
    }

    /*
    @PutMapping("/")
    public void updateStockOption(@RequestBody StockOption stockOption) {
        stockOptionService.updateStockOption(stockOption);
    }

    @DeleteMapping("/")
    public void deleteStockOption(@PathVariable int stockOptionId) {
        stockOptionService.deleteStockOption(stockOptionId);
    }
    */
}