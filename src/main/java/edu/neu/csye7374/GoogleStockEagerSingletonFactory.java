package edu.neu.csye7374;

public class GoogleStockEagerSingletonFactory implements StockFactory {
    // Instance is created immediately when class loads
    private static final GoogleStockEagerSingletonFactory instance = new GoogleStockEagerSingletonFactory();
    
    private GoogleStockEagerSingletonFactory() {}
    
    public static GoogleStockEagerSingletonFactory getInstance() {
        return instance;  // Simply returns the pre-created instance
    }
    
    @Override
    public Stock createStock(String name, double price, String description) {
        return new GoogleStock(name, price, description);
    }
} 