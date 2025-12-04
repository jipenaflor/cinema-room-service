package com.jipenaflor.cinema_room_service.controller;

import com.jipenaflor.cinema_room_service.dto.PurchaseRequestDTO;
import com.jipenaflor.cinema_room_service.dto.PurchaseResponseDTO;
import com.jipenaflor.cinema_room_service.service.TicketsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private TicketsService ticketsService;

    public PurchaseController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    @PostMapping
    public ResponseEntity<PurchaseResponseDTO> purchaseTicket(@RequestBody PurchaseRequestDTO request) {
        return ticketsService.purchaseTicket(request);
    }
}
