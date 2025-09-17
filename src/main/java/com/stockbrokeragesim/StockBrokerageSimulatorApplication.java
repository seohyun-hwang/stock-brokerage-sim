// SpringBoot imports
package com.stockbrokeragesim;
import com.stockbrokeragesim.model.ConnectToSQL;
import com.stockbrokeragesim.repositories.SQL_ConnectionRepo;
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
		ApplicationContext appContext = SpringApplication.run(StockBrokerageSimulatorApplication.class, args); // connection to SpringBoot
		System.out.println("Welcome to my stock market brokerage simulator. Disclaimer: this program ignores dividends.");

		ConnectToSQL sql_connectionObject1 = appContext.getBean(ConnectToSQL.class);

		SQL_ConnectionRepo repo = appContext.getBean(SQL_ConnectionRepo.class);

	}

	public static void stockInteraction() {
		for (int halfSecondsPassed = 0; halfSecondsPassed < 46800; halfSecondsPassed++) { // 6.5 hours (09:30 - 16:00) = 46,800 half-seconds
			try {
				if (skipSwitch == 1) { // skip forward 1 day
					if (tableRowIndex_general < tableRowIndex_last) {
						tableRowIndex_general++;
						stockInteraction();
						break;
					}
					else {
						System.out.println("Reached the latest date: Friday, December 27, 2024!");
					}
				}
				else if (skipSwitch == -1) { // skip backward 1 day
					if (tableRowIndex_general > 0) {
						tableRowIndex_general--;
						stockInteraction();
						break;
					}
					else {
						System.out.println("Reached the earliest date: Monday, June 5, 1972!");
					}
				}
				else { // no skipping
					//short focusInteractionType = shareInteractionType.get();
					for (int i = 0; i < share_tickerSymbol.size(); i++) {
						switch (share_tickerSymbol.get(i).toLowerCase()) {
							case "ge":
								break;
							case "ko":
								break;
							case "googl":
								break;
							case "aapl":
								break;
							case "msft":
								break;
							case "amzn":
								break;
							case "nvda":
								break;
							case "avgo":
								break;
							case "cost":
								break;
							case "meta":
								break;
							case "nflx":
								break;
							case "pep":
								break;
							case "tsla":
								break;
							case "pg":
								break;
							case "cl":
								break;
							case "xom":
								break;
							case "ibm":
								break;
							default:
						}
					}


					if (focusInteractionType < 200) { // GTC order

					}
					else if (focusInteractionType < 300) { // day order

					}
					else { // not an order

					}

					if (focusInteractionType % 100 < 20) { // buy

					}
					else if (focusInteractionType % 100 < 30) { // sell

					}
					else if (focusInteractionType % 100 < 40) { // short

					}
					else { // buy-to-cover

					}

					focusPrice_rightNow = (Math.random() * (focusPrice * 0.25)) + (focusPrice * 0.75);
					Thread.sleep(500); // pause for 500 milliseconds until the next stock-price update (0.5 second)
				}
			} catch (InterruptedException e) {
				// Handle the InterruptedException if the thread is interrupted
				System.out.println("Thread interrupted during sleep.");
				Thread.currentThread().interrupt(); // Restore the interrupted status
			}
		}
	}


	@Override// JDBC template instance for database query
	public void run(final String... args) throws Exception {
		log.info("Datasource: " + dataSource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}
}