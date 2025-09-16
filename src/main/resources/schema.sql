
create table stockBrokerageSimSQL1table1 (
    DateIndex date primary key,
    GE decimal(8,2)
    KO decimal(8,2)
    GOOGL decimal(8,2)
    AAPL decimal(8,2)
    MSFT decimal(8,2)
    AMZN decimal(8,2)
    NVDA decimal(8,2)
    AVGO decimal(8,2)
    COST decimal(8,2)
    META decimal(8,2)
    NFLX decimal(8,2)
    PEP decimal(8,2)
    TSLA decimal(8,2)
    PG decimal(8,2)
    CL decimal(8,2)
    XOM decimal(8,2)
    IBM decimal(8,2)
);

INSERT INTO stockBrokerageSimSQL1table1 (DateIndex, GE, KO, GOOGL, AAPL, MSFT, AMZN, NVDA, AVGO, COST, META, NFLX, PEP, TSLA, PG, CL, XOM, IBM)
SELECT DateIndex, GE, KO, GOOGL, AAPL, MSFT, AMZN, NVDA, AVGO, COST, META, NFLX, PEP, TSLA, PG, CL, XOM, IBM FROM CSVREAD('Stock-Brokerage-Simulator/cs_project_table_stockBrokerageSim1.csv', 'DateIndex, GE, KO, GOOGL, AAPL, MSFT, AMZN, NVDA, AVGO, COST, META, NFLX, PEP, TSLA, PG, CL, XOM, IBM');