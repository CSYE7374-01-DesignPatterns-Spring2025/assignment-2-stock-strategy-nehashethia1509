package edu.neu.csye7374;

public class IBMStockFactory implements StockFactory {
    @Override
    public Stock createStock(String name, double price, String description) {
        return new IBMStock(name, price, description);
    }
} 