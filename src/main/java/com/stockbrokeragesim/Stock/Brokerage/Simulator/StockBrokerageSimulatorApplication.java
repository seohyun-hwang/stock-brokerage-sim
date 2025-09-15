// SpringBoot imports
package com.stockbrokeragesim.Stock.Brokerage.Simulator;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

// Non-SpringBoot imports
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


@SpringBootApplication
@Log
public class StockBrokerageSimulatorApplication implements CommandLineRunner {

	// -- SpringBoot configuration --
	private final DataSource dataSource;


	// -- Non-SpringBoot configuration --

	static double dollarCash_inYoWallet = 100000.00; // starting off with $100K IN CASH IN YOUR WALLET :DD (perfectly realistic)

	// info for currently-owned/-borrowed shares
	static ArrayList<String> sharePossessed_tickerSymbol = new ArrayList<>();
	static ArrayList<Double> share_priceAtCollection = new ArrayList<>(); // the price of each share the moment it was bought/shorted
	static ArrayList<Boolean> isShareBought = new ArrayList<>(); // true: share is bought; false; share is shorted

	// info for currently-active orders
	static ArrayList<String> shareOrdered_tickerSymbol = new ArrayList<>();
	static ArrayList<Integer> shareCount = new ArrayList<>();
	static ArrayList<Boolean> isOrderPermanent = new ArrayList<>(); // true: order is good-til-canceled; false: order expires after closest upcoming trading-day

	// info for display of currently-selected stock
	static ArrayList<Byte> chart_timeDivisionType = new ArrayList<>(); // 0: specific day; 1: specific week; 2: specific month; 3: specific year; 4: specific decade
	static ArrayList<Byte> chart_timeDivisionIndex = new ArrayList<>();
	static ArrayList<Double> stockPrices = new ArrayList<>();
	static double stockPrice;

	// time info
	static short tradingDay_general = 1; // starting on Monday, January 4, 1960
	static final short tradingDay_last = 23734; // from Mon 01/04/1960 to Fri 12/27/2024: 23,734 days

	static short secondsPassed_general = 0;
	static final short secondsPassed_maximum = 23400; // 6.5 hours (09:30 - 16:00) = 23,400 seconds


	// additional
	static byte actionType; // buy/sell/short/buy-to-cover
	static Scanner scanner = new Scanner(System.in);

    public StockBrokerageSimulatorApplication(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
		SpringApplication.run(StockBrokerageSimulatorApplication.class, args); // connection to SpringBoot

		System.out.println("Welcome to my stock market brokerage simulator. Disclaimer: this program ignores dividends.");

		connectTo_SQL();
		userInteraction();

	}
	public static void connectTo_SQL() {
		try { // SQL connection
			String url = "jdbc:mysql://localhost:3306/stockBrokerageSimSQL1";
			String username = "root";
			String password = "";

			Connection connectionSQL = DriverManager.getConnection(url, username, password);
			Statement statementSQL = connectionSQL.createStatement();
			ResultSet resultSetSQL = statementSQL.executeQuery("select * from student");

			connectionSQL.close(); // closing the SQL connection
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public static void userInteraction() {

		System.out.println("");

	}


	// STOCK ACCESS
	public static void accessStock() {

	}
	public static void moveThroughTradingDay(int stockPrice_previousDay, int stockPrice_thisDay) {
		secondsPassed_general = 0;

		float stockPrice_incrementPerSecond = ((float) stockPrice_thisDay - (float) stockPrice_previousDay) / secondsPassed_maximum;
		float stockPrice_rightNow = stockPrice_previousDay;

		while (secondsPassed_general < secondsPassed_maximum) {
			stockPrice = ((double) (stockPrice_rightNow)) * (2 * Math.random() * Math.random());

			stockPrice_rightNow += stockPrice_incrementPerSecond;
			secondsPassed_general++;
		}
		stockPrice_rightNow = stockPrice_thisDay;
		skipDay(true);
	}

	// TIME SETTINGS
	// skip 1 trading-day forward or return 1 trading-day backward
	public static void skipDay(boolean isForward) {
        if (isForward) {
			if (tradingDay_general < tradingDay_last) {
				tradingDay_general++;

				if (tradingDay_general % 7 == 6) { // if the day is Saturday
					tradingDay_general += 2;
				} else if (tradingDay_general % 7 == 0) { // if the day is Sunday
					tradingDay_general++;
				}
			}
			else {
				System.out.println("Reached the latest date: Friday, December 27, 2024!");
			}
		}
		else { // !isForward
			if (tradingDay_general > 1) {
				tradingDay_general--;

				if (tradingDay_general % 7 == 6) { // if the day is Saturday
					tradingDay_general--;
				} else if (tradingDay_general % 7 == 0) { // if the day is Sunday
					tradingDay_general -= 2;
				}
			}
			else {
				System.out.println("Reached the earliest date: Monday, January 4, 1960!");
			}
		}
	}


	// ACTION TYPES (buy, sell, short, buy-to-cover)

	public static void actionType_buy() { // purchase a share
		dollarCash_inYoWallet -= sharePrice;
		share_nameCode.add();
		share_priceAtCollection.add();
		isShareBought.add(true);

		switch (orderType) {
			case
		}
	}
	public static void actionType_sell() { // sell an already-owned share
		if (isShareOwned) {
			dollarCash_inYoWallet += sharePrice;
		}

		switch (orderType) {
			case
		}
	}

	public static void actionType_short() { // borrow and immediately sell a share at current price with a promise to pay back later
		share_nameCode.add();
		share_priceAtCollection.add();
		isShareBought.add(false);

		switch (orderType) {
			case
		}
	}
	public static void actionType_buyToCover() { // pay back for shorted share at current price
		if (!isShareOwned) {
			dollarCash_inYoWallet += sharePrice - shortPrice;
		}

		switch (orderType) {
			case
		}
	}

	// ORDER TYPES (market, limit, stop-loss, stop-limit, trailing-stop)

	public static void orderType_market() { // buy/sell immediately at best available price

		sharePrice = ;
	}
	public static void orderType_limit() { // buy/sell only at a specific or better price
		int limitPrice;

		sharePrice = ;
	}
	public static void orderType_stopLoss() { // market-order once share price reaches a stop-price (i.e. a specific number)
		int stopPrice;

		sharePrice = ;
	}
	public static void orderType_stopLimit() { // limit-order once share price reaches a stop-price (i.e. a specific number)
		int stopPrice;

		sharePrice = ;
	}
	public static void orderType_trailingStop() { // stop-price moves with share price but only forwards (up if to sell; down if to buy)
		int stopPrice;

		sharePrice = ;
	}


	// ORDER DURABILITY (day, good-til-canceled)

	public static void orderDurability_day() { // order expires after the closest upcoming trading-day
		isOrderPermanent.add(false);
	}
	public static void orderDurability_goodTilCanceled() { // order only expires when executed or canceled
		isOrderPermanent.add(true);
	}

	@Override // JDBC template instance for database query
	public void run(final String... args) throws Exception {
		log.info("Datasource: " + dataSource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}
}
