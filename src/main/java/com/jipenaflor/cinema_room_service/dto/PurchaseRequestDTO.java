package com.jipenaflor.cinema_room_service.dto;

public class PurchaseRequestDTO {

    private int row;
    private int column;

    public PurchaseRequestDTO() {
    }

    public PurchaseRequestDTO(int row, int column) {
        this.row = row;
        this.column = column;
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
}