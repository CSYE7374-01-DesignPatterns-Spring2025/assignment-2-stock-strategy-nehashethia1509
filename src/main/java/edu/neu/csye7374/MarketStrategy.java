package edu.neu.csye7374;

public interface MarketStrategy {
    double calculateNewPrice(double currentPrice, double bid);
}
