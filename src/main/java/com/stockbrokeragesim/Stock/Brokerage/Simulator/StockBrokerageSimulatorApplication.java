// SpringBoot imports
package com.stockbrokeragesim.Stock.Brokerage.Simulator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Non-SpringBoot imports
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


@SpringBootApplication
public class StockBrokerageSimulatorApplication {

	static double dollarCash_inYoWallet = 100000.00; // starting off with $100K IN CASH IN YOUR WALLET :DD (perfectly realistic)

	static int tradingDaysPassed = 0; // since 01/01/1925
	static final int tradingDaysMaximum = 36524; // from 01/01/1925 to 12/31/2024: 36,524 days

	// info for currently-owned/-borrowed shares
	static ArrayList<String> sharePossessed_nameCode = new ArrayList<>();
	static ArrayList<Double> share_priceAtCollection = new ArrayList<>(); // the price of each share the moment it was bought/shorted
	static ArrayList<Boolean> isShareBought = new ArrayList<>(); // true: share is bought; false; share is shorted

	// info for currently-active orders
	static ArrayList<String> shareOrdered_nameCode = new ArrayList<>();
	static ArrayList<Integer> shareCount = new ArrayList<>();
	static ArrayList<Boolean> isOrderPermanent = new ArrayList<>(); // true: order is good-til-canceled; false: order expires after closest upcoming trading-day

	// info for display of currently-selected stock
	static ArrayList<Byte> chart_timeDivisionType = new ArrayList<>(); // 0: specific day; 1: specific week; 2: specific month; 3: specific year; 4: specific decade
	static ArrayList<Byte> chart_timeDivisionIndex = new ArrayList<>();
	static ArrayList<Double> stockPrice = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(StockBrokerageSimulatorApplication.class, args); // connection to SpringBoot

		System.out.println("Welcome to my stock market brokerage simulator. Disclaimer: this program ignores dividends.");


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

		userInteraction();

	}
	public static void userInteraction() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("");

	}


	// TIME PROGRESSION (forward/backward: 1 day, 2 days, 7 days, 30 days, 365 days, (2 * 365) days, (5 * 365 days))
	public static void moveTime(byte tradingDays_MovementOption, boolean isForward) {
		int tradingDays_movementCount;
		switch (tradingDays_MovementOption) {
			case 1:
				tradingDays_movementCount = 1;
				break;
			case 2:
				tradingDays_movementCount = 2;
				break;
			case 3:
				tradingDays_movementCount = 7;
				break;
			case 4:
				tradingDays_movementCount = 30;
				break;
			case 5:
				tradingDays_movementCount = 365;
				break;
			case 6:
				tradingDays_movementCount = 1825;
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + tradingDays_MovementOption);
		}
		if (isForward) {
			if ((tradingDaysPassed + tradingDays_MovementOption) <= tradingDaysMaximum) {
				tradingDaysPassed += tradingDays_movementCount;
			}
			else {
				System.out.println("You cannot move this many days as you would reach further out than Dec 31, 2024.");
			}
		}
		else {
			if ((tradingDaysPassed - tradingDays_MovementOption) >= 0) {
				tradingDaysPassed -= tradingDays_MovementOption;
			}
			else {
				System.out.println("You cannot move this many days as you would reach further back than Jan 01, 1925.");
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

		sharePrice = ;
	}
	public static void orderType_stopLoss() { // market-order once share price reaches a stop-price (i.e. a specific number)

		sharePrice = ;
	}
	public static void orderType_stopLimit() { // limit-order once share price reaches a stop-price (i.e. a specific number)

		sharePrice = ;
	}
	public static void orderType_trailingStop() { // stop-price moves with share price but only forwards (up if to sell; down if to buy)

		sharePrice = ;
	}


	// ORDER DURABILITY (day, good-til-canceled)

	public static void orderDurability_day() { // order expires after the closest upcoming trading-day
		isOrderPermanent.add(false);
	}
	public static void orderDurability_goodTilCanceled() { // order only expires when executed or canceled
		isOrderPermanent.add(true);
	}

}
