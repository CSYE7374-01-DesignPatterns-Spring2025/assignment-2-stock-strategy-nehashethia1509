package edu.neu.csye7374;

public class GoogleStockFactory implements StockFactory {
    @Override
    public Stock createStock(String name, double price, String description) {
        return new GoogleStock(name, price, description);
    }
} 