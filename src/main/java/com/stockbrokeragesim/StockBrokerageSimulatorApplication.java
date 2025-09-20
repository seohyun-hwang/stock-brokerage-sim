package com.stockbrokeragesim;
import java.util.ArrayList;

// SpringBoot imports
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@SpringBootApplication
@Component
public class StockBrokerageSimulatorApplication {

	static double dollarCash_inYoWallet = 100000.00; // starting off with $100K IN CASH IN YOUR WALLET :DD (perfectly realistic)
	static final short tableRowIndex_last = 13262; // ending on row 13,264 of the table as index 13,262

	static ArrayList<Short> shareInteractionType = new ArrayList<>();
	// xx1: market order; xx2: limit order; xx3: stop-loss order; xx4: stop-limit order; xx5: trailing-stop order
	// x1x: buy action; x2x: sell action; x3x: short action; x4x: buy-to-cover action
	// 1xx: good-til-canceled order; 2xx: day order: 3xx: already possessed (not an order)

    public static void main(String[] args) {
		// connection to SpringBoot
		SpringApplication.run(StockBrokerageSimulatorApplication.class, args);
		System.out.println("Welcome to my stock market brokerage simulator. Disclaimer: this program ignores dividends.");

	}
}