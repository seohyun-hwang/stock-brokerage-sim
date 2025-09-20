package com.stockbrokeragesim.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;
import java.util.ArrayList;


@Component
@Entity
public class StockOption {

    @Id
    private ArrayList<Double> stockPrices = new ArrayList<>();

    // 0 GE -- 1 KO -- 2 GOOGL -- 3 AAPL -- 4 MSFT -- 5 AMZN -- 6 NVDA -- 7 AVGO -- 8 COST -- 9 META -- 10 NFLX -- 11 PEP -- 12 TSLA -- 13 PG -- 14 CL -- 15 XOM -- 16 IBM
    public double getStockOption(int stockIndex) {
        return stockPrices.get(stockIndex);
    }
}