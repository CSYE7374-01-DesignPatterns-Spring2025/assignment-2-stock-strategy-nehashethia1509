package edu.neu.csye7374;

public class IBMStock extends Stock {
    private double lastBid;
    
    public IBMStock(String name, double price, String description) {
        super(name, price, description);
        this.lastBid = price;
    }
    
    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        this.lastBid = bidValue;
        // Simple price adjustment: new price is average of current price and bid
        setPrice((getPrice() + bidValue) / 2);
    }
    
    @Override
    public String getMetric() {
        // Calculate performance metric based on price movement
        double priceChange = getPrice() - lastBid;
        double percentageChange = (priceChange / lastBid) * 100;
        return String.format("%.2f%%", percentageChange);
    }
} 