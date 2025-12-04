package com.jipenaflor.cinema_room_service.entity;

import java.util.Map;
import java.util.UUID;

public class Cinema {

    private int income;
    private int available;
    private int purchased;
    private Map<UUID, Seat> purchasedSeats;

    public Cinema(int income, int available, int purchased, Map<UUID, Seat> purchasedSeats) {
        this.income = income;
        this.available = available;
        this.purchased = purchased;
        this.purchasedSeats = purchasedSeats;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getPurchased() {
        return purchased;
    }

    public void setPurchased(int purchased) {
        this.purchased = purchased;
    }

    public Map<UUID, Seat> getPurchasedSeats() {
        return purchasedSeats;
    }

    public void setPurchasedSeats(Map<UUID, Seat> purchasedSeats) {
        this.purchasedSeats = purchasedSeats;
    }
}
