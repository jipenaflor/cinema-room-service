package com.jipenaflor.cinema_room_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jipenaflor.cinema_room_service.entity.Seat;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "token", "ticket"
})
public class PurchaseResponseDTO {

    private UUID token;
    private Seat ticket;

    public PurchaseResponseDTO() {
    }

    public PurchaseResponseDTO(UUID token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }
}