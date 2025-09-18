// SpringBoot imports
package com.stockbrokeragesim;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

// Non-SpringBoot imports
import javax.sql.DataSource;
import java.util.ArrayList;


@SpringBootApplication
@Log
@Component
public class StockBrokerageSimulatorApplication implements CommandLineRunner {

	// -- SpringBoot configuration --
	private final DataSource dataSource;
	public StockBrokerageSimulatorApplication(final DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private static final Logger log = LoggerFactory.getLogger(StockBrokerageSimulatorApplication.class);


	// -- Non-SpringBoot configuration --

	static double dollarCash_inYoWallet = 100000.00; // starting off with $100K IN CASH IN YOUR WALLET :DD (perfectly realistic)

	static ArrayList<String> share_tickerSymbol = new ArrayList<>(); // NASDAQ abbreviation of company-name on the stock market
	static ArrayList<Double> share_priceAtCollection = new ArrayList<>(); // the price of each share the moment it was bought/shorted
	static ArrayList<Short> shareInteractionType = new ArrayList<>();
	// xx1: market order; xx2: limit order; xx3: stop-loss order; xx4: stop-limit order; xx5: trailing-stop order
	// x1x: buy action; x2x: sell action; x3x: short action; x4x: buy-to-cover action
	// 1xx: good-til-canceled order; 2xx: day order: 3xx: already possessed (not an order)
	static byte skipSwitch;
	static double focusPrice; // the price of a specific stock on a specific day

	// info for display of currently-selected stock
	static ArrayList<Byte> chart_timeDivisionType = new ArrayList<>(); // 0: specific day; 1: specific week; 2: specific month; 3: specific year; 4: specific decade
	static ArrayList<Byte> chart_timeDivisionIndex = new ArrayList<>();
	static ArrayList<Double> stockPrices = new ArrayList<>();
	static short tableRowIndex_general = 0; // starting from row 2 of the table as index 0
	static final short tableRowIndex_last = 13262; // ending on row 13,264 of the table as index 13,262


    public static void main(String[] args) {
		// connection to SpringBoot
		ApplicationContext appContext = SpringApplication.run(StockBrokerageSimulatorApplication.class, args);
		System.out.println("Welcome to my stock market brokerage simulator. Disclaimer: this program ignores dividends.");

	}

	public static void activatedFunction() {

	}


	@Override// JDBC template instance for database query
	public void run(final String... args) throws Exception {
		log.info("Datasource: " + dataSource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	};

}