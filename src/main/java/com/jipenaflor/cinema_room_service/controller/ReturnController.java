package com.jipenaflor.cinema_room_service.controller;

import com.jipenaflor.cinema_room_service.dto.PurchaseResponseDTO;
import com.jipenaflor.cinema_room_service.dto.RefundRequestDTO;
import com.jipenaflor.cinema_room_service.service.TicketsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/return")
public class ReturnController {

    private TicketsService ticketsService;

    public ReturnController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    @PostMapping
    public ResponseEntity<PurchaseResponseDTO> refundTicket(@RequestBody RefundRequestDTO request) {
        return ticketsService.refundTicket(request);
    }
}
