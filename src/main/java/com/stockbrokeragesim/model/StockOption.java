package com.stockbrokeragesim.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;
import java.util.ArrayList;


@Component
@Entity
public class StockOption {

    @Id
    private int stockOptionId;
    private ArrayList<Double> stockPrices = new ArrayList<>();


    //getters
    public int getStockOptionId() {
        return stockOptionId;
    }
    public double getStockOptionGE() {
        return stockPrices.get(0);
    }
    public double getStockOptionKO() {
        return stockPrices.get(1);
    }
    public double getStockOptionGOOGL() {
        return stockPrices.get(2);
    }
    public double getStockOptionAAPL() {
        return stockPrices.get(3);
    }
    public double getStockOptionMSFT() {
        return stockPrices.get(4);
    }
    public double getStockOptionAMZN() {
        return stockPrices.get(5);
    }
    public double getStockOptionNVDA() {
        return stockPrices.get(6);
    }
    public double getStockOptionAVGO() {
        return stockPrices.get(7);
    }
    public double getStockOptionCOST() {
        return stockPrices.get(8);
    }
    public double getStockOptionMETA() {
        return stockPrices.get(9);
    }
    public double getStockOptionNFLX() {
        return stockPrices.get(10);
    }
    public double getStockOptionPEP() {
        return stockPrices.get(11);
    }
    public double getStockOptionTSLA() {
        return stockPrices.get(12);
    }
    public double getStockOptionPG() {
        return stockPrices.get(13);
    }
    public double getStockOptionCL() {
        return stockPrices.get(14);
    }
    public double getStockOptionXOM() {
        return stockPrices.get(15);
    }
    public double getStockOptionIBM() {
        return stockPrices.get(16);
    }

    @Override
    public String toString() {
        return "StockOption{" +
                "stockOptionId=" + stockOptionId +
                ", stockPrices=" + stockPrices +
                '}';
    }
}

