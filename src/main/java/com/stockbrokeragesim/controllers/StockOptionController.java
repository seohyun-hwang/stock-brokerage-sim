package com.stockbrokeragesim.controllers;
import com.stockbrokeragesim.model.StockOption;
import com.stockbrokeragesim.services.StockOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockOptionController {

    @Autowired
    StockOptionService stockOptionService;

    @GetMapping("/")
    public List<StockOption> getStockOptions() {
        return stockOptionService.getStockOptions();
    }

    @GetMapping("/")
    public StockOption getStockOptionById(int stockOptionId) {
        return stockOptionService.getStockOptionById(stockOptionId);
    }

    @PostMapping("/")
    public void addStockOption(@RequestBody StockOption stockOption) {
        stockOptionService.addStockOption(stockOption);
    }

    @PutMapping("/")
    public void updateStockOption(@RequestBody StockOption stockOption) {
        stockOptionService.updateStockOption(stockOption);
    }

    @DeleteMapping("/")
    public void deleteStockOption(@PathVariable int stockOptionId) {
        stockOptionService.deleteStockOption(stockOptionId);
    }
}