package edu.neu.csye7374;

public class MicrosoftStockFactory implements StockFactory {
    @Override
    public Stock createStock(String name, double price, String description) {
        return new MicrosoftStock(name, price, description);
    }
} 