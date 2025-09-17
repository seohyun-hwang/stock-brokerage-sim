package com.stockbrokeragesim.controllers;

import com.stockbrokeragesim.StockService;
import com.stockbrokeragesim.entities.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ResourceBundle;


public class StockController {
    @Autowired
    private StockService stockService;

    // getting today's price for selected stock
    public ResponseEntity<Double> getTodayPrice(@PathVariable String ticker) {
        double price = stockService.getTodayPrice(ticker);
        return ResponseEntity.ok(price);
    }

    // placing an order
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest order) {
        stockService.placeOrder(order);
        return ResponseEntity.ok("Order successful!");
    }
}
