package com.jipenaflor.cinema_room_service.entity;

public class CinemaSeats {

    private Seat[][] seats;

    public CinemaSeats(int size, int priceHigh, int priceLow) {
        this.seats = setSeats(size, priceHigh, priceLow);
    }

    public Seat[][] getSeats() {
        return seats;
    }

    private Seat[][] setSeats(int size, int priceHigh, int priceLow) {
        Seat[][] seats = new Seat[size][size];
        for (int row = 0; row < size; row++) {
            int price = row < 4 ? priceHigh : priceLow;
            for (int col = 0; col < size; col++) {
                seats[row][col] = new Seat(row + 1, col + 1, price, true);
            }
        }
        return seats;
    }
}