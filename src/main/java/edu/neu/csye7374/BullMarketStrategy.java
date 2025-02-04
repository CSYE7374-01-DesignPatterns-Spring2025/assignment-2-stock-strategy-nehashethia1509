package edu.neu.csye7374;

public class BullMarketStrategy implements MarketStrategy {
    @Override
    public double calculateNewPrice(double currentPrice, double bid) {
        return currentPrice + (bid - currentPrice) * 1.5;
    }
}
