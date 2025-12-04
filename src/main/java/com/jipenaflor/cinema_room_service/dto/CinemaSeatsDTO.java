package com.jipenaflor.cinema_room_service.dto;

import com.jipenaflor.cinema_room_service.entity.Seat;

import java.util.List;

public class CinemaSeatsDTO {

    private int rows;
    private int columns;
    private List<Seat> seats;

    public CinemaSeatsDTO() {
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

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}