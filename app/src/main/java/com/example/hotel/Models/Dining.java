package com.example.hotel.Models;

public class Dining {
    private String diningId;
    private String title;
    private String description;
    private double price;

    public Dining() {}

    public Dining(String diningId, String title, String description, double price) {
        this.diningId = diningId;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    // Getters et Setters
    public String getDiningId() { return diningId; }
    public void setDiningId(String diningId) { this.diningId = diningId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
