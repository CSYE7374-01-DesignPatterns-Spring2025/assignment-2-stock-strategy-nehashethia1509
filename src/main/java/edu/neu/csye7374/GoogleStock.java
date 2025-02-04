package edu.neu.csye7374;

public class GoogleStock extends Stock {
    private double lastBid;
    
    public GoogleStock(String name, double price, String description) {
        super(name, price, description);
        this.lastBid = price;
    }
    
    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        this.lastBid = bidValue;
        double difference = bidValue - getPrice();

        //update the price by 50%
        double adjustmentFactor = 0.5;
        double newPrice = getPrice() + (adjustmentFactor * difference);

        setPrice(newPrice);
    }
    
    @Override
    public String getMetric() {
        // Calculate performance metric based on price movement
        double priceChange = getPrice() - lastBid;
        double percentageChange = (priceChange / lastBid) * 100;
        return String.format("%.2f%%", percentageChange);
    }
} 
