package com.jipenaflor.cinema_room_service.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("cinema.seats")
public class CinemaSeatsProperty {

    private int rows;
    private int columns;
    private int size;
    private int available;
    private int priceHigh;
    private int priceLow;

    public CinemaSeatsProperty() {
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

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}