package com.jipenaflor.cinema_room_service.dto;

public class StatsDTO {

    private int income;
    private int available;
    private int purchased;

    public StatsDTO() {
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
}
