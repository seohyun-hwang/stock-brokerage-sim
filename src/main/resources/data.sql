INSERT INTO stockOption (id, GE, KO, GOOGL, AAPL, MSFT, AMZN, NVDA, AVGO, COST, META, NFLX, PEP, TSLA, PG, CL, XOM, IBM)
AS SELECT id, GE, KO, GOOGL, AAPL, MSFT, AMZN, NVDA, AVGO, COST, META, NFLX, PEP, TSLA, PG, CL, XOM, IBM FROM CSVREAD('com.stockbrokeragesim/cs_project_table_stockBrokerageSim1.csv');
