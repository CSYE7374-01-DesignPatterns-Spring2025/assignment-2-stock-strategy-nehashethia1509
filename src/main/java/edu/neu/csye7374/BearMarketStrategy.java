package edu.neu.csye7374;

public class BearMarketStrategy implements MarketStrategy {
    @Override
    public double calculateNewPrice(double currentPrice, double bid) {

        return currentPrice + (bid - currentPrice) * 0.3;
    }
}
