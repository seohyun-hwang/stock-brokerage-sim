package com.stockbrokeragesim;
import com.stockbrokeragesim.entities.OrderRequest;

public class StockService {

    public double getTodayPrice(String ticker) {
        double historicalPrice = jdbcTemplate.queryForObject(
                "SELECT " + ticker + " FROM stockBrokerageSimSQL1table1 WHERE id = ?",
                new Object[]{xxxxxx}, Double.class
        );

        // simulating within-day fluctuation
        return (Math.random() * (historicalPrice * 0.25)) + (historicalPrice * 0.75);
    }

    public void placeOrder(OrderRequest order) {
        // basic example logic
        if (/*buy-action selected*/) {
            double total = order.getPrice() * order.getQuantity();
            if (StockBrokerageSimulatorApplication.dollarCash_inYoWallet >= total) {
                StockBrokerageSimulatorApplication.dollarCash_inYoWallet -= total;
            }
        }


    }
}
