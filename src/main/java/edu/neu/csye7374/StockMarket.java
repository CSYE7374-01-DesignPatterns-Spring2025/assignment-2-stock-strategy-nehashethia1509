package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;
    private List<Stock> stocks;

    // Private constructor for Singleton
    private StockMarket() {
        stocks = new ArrayList<>();
    }

    // Lazy initialization of Singleton
    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public void showAllStocks() {
        if (stocks.isEmpty()) {
            System.out.println("No stocks in the market");
            return;
        }

        for (Stock stock : stocks) {
            System.out.println(stock);
            System.out.println("Performance Metric: " + stock.getMetric());
            System.out.println("-------------------");
        }
    }

    public static void demo() {
        System.out.println("============ Stock Market Demo ============");

        // Get the stock market instance
        StockMarket market = StockMarket.getInstance();

        // Create factories
        StockFactory regularIBMFactory = new IBMStockFactory();
        StockFactory regularGoogleFactory = new GoogleStockFactory();
        StockFactory regularMicrosoftFactory = new MicrosoftStockFactory();

        // Get singleton factories
        StockFactory singletonIBMFactory = IBMStockLazySingletonFactory.getInstance();
        StockFactory singletonGoogleFactory = GoogleStockEagerSingletonFactory.getInstance();
        StockFactory singletonMicrosoftFactory = MicrosoftStockLazySingletonFactory.getInstance();

        // Create different types of stocks using factories
        Stock googleStock = singletonGoogleFactory.createStock("Google", 200, "Google Cloud Stock");
        googleStock.setMarketStrategy(new BullMarketStrategy());
        Stock microsoftStock = singletonMicrosoftFactory.createStock("Microsoft", 350.00, "Microsoft Corporation Stock");
        microsoftStock.setMarketStrategy(new BearMarketStrategy());

        // Add stocks to market
        market.addStock(googleStock);
        market.addStock(microsoftStock);

        // Display initial state
        System.out.println("\nInitial Stock Market State:");
        market.showAllStocks();

        // Demonstrate trading with bids
        System.out.println("\nTrading Demonstration:");

        System.out.println("\n========== Google Stock ==========");
        System.out.println("Implementing Bull Market Strategy");
        // Place bids for Google stock
        String[] googleBids = {"289.50", "267.75", "378.90", "300.25", "178.80", "338.00"};

        for (String bid : googleBids) {
            System.out.println("\nPlacing bid: " + bid);
            googleStock.setBid(Double.parseDouble(bid));
            System.out.println("Updated Google Stock:");
            System.out.println(googleStock);
            System.out.println("--------------------------------");
        }

        System.out.println("\n========== Microsoft Stock ==========");
        System.out.println("Implementing Bear Market Strategy");
        // Place bids for Microsoft stock
        String[] microsoftBids = {"110.50", "220.95", "209.90", "286.25", "372.80", "293.00"};

        for (String bid : microsoftBids) {
            System.out.println("\nPlacing bid: " + bid);
            microsoftStock.setBid(Double.parseDouble(bid));
            System.out.println("Updated Microsoft Stock:");
            System.out.println(microsoftStock);
            System.out.println("--------------------------------");
        }

        // Show final market state
        System.out.println("\nFinal Stock Market State:");
        market.showAllStocks();

        System.out.println("\n========== Demo Complete ==========");
    }
}
