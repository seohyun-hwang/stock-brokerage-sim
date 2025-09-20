package com.stockbrokeragesim.services;

import com.stockbrokeragesim.models.StockOption;
import com.stockbrokeragesim.repositories.StockOptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockOptionService {

    @Autowired
    StockOptionRepo stockOptionRepo;

    List<StockOption> stockOptions = new ArrayList<>();

    public List<StockOption> getStockOptions() {
        return stockOptionRepo.findAll(); // returning the list of stock options
    }


    public StockOption getStockOptionById(int stockOptionId) {
        return stockOptionRepo.findById(stockOptionId).orElse(new StockOption());
    }

    public void addStockOption(StockOption stockOption) {
        stockOptionRepo.save(stockOption);
    }

    public void updateStockOption(StockOption stockOption) {
        stockOptionRepo.save(stockOption);
    }

    public void deleteStockOption(int stockOptionId) {
        stockOptionRepo.deleteById(stockOptionId);
    }
}
