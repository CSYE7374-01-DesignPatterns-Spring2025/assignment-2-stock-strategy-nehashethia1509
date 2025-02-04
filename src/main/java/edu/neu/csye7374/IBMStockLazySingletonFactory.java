package edu.neu.csye7374;

public class IBMStockLazySingletonFactory implements StockFactory {
    private static IBMStockLazySingletonFactory instance;
    
    private IBMStockLazySingletonFactory() {}
    
    public static synchronized IBMStockLazySingletonFactory getInstance() {
        if (instance == null) {
            instance = new IBMStockLazySingletonFactory();
        }
        return instance;
    }
    
    @Override
    public Stock createStock(String name, double price, String description) {
        return new IBMStock(name, price, description);
    }
} 