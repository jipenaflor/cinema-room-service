package com.jipenaflor.cinema_room_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonPropertyOrder({
        "row", "column", "price"
})
public class Seat {

    private int row;
    private int column;
    private int price;
    private boolean isAvailable;

    public Seat() {
    }

    public Seat(int row, int col, int price, boolean isAvailable) {
        this.row = row;
        this.column = col;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @JsonIgnore
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}