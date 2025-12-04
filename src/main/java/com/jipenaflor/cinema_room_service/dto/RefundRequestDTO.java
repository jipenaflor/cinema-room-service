package com.jipenaflor.cinema_room_service.dto;

import java.util.UUID;

public class RefundRequestDTO {

    private UUID token;

    public RefundRequestDTO() {
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}