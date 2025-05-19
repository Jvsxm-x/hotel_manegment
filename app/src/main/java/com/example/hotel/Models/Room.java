package com.example.hotel.Models;
public class Room {
    private String roomId;
    private String type;
    private double price;
    private boolean isAvailable;

    public Room() {}

    public Room(String roomId, String type, double price, boolean isAvailable) {
        this.roomId = roomId;
        this.type = type;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Getters et Setters
    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}
