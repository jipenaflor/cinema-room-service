package com.jipenaflor.cinema_room_service.config;

import com.jipenaflor.cinema_room_service.entity.Seat;

public class CinemaSeats {

    private int size;
    private int rows;
    private int columns;
    private int priceHigh;
    private int priceLow;

    private Seat[][] seats;

    public CinemaSeats(int size, int rows, int columns, int priceHigh, int priceLow) {
        this.size = size;
        this.rows = rows;
        this.columns = columns;
        this.priceHigh = priceHigh;
        this.priceLow = priceLow;
        this.seats = setSeats(size, priceHigh, priceLow);
    }

    public Seat[][] getSeats() {
        return this.seats;
    }

    public Seat[][] setSeats(int size, int priceHigh, int priceLow) {
        Seat[][] seats = new Seat[size][size];
        for (int row = 0; row < size; row++) {
            int price = row < 4 ? priceHigh : priceLow;
            for (int col = 0; col < size; col++) {
                seats[row][col] = new Seat(row + 1, col + 1, price, true);
            }
        }
        return seats;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumn(int columns) {
        this.columns = columns;
    }

    public int getPriceHigh() {
        return priceHigh;
    }

    public void setPriceHigh(int priceHigh) {
        this.priceHigh = priceHigh;
    }

    public int getPriceLow() {
        return priceLow;
    }

    public void setPriceLow(int priceLow) {
        this.priceLow = priceLow;
    }
}