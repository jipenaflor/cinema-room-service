package com.jipenaflor.cinema_room_service.controller;

import com.jipenaflor.cinema_room_service.dto.CinemaSeatsDTO;
import com.jipenaflor.cinema_room_service.service.SeatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seats")
public class SeatsController {

    private SeatsService seatsService;

    public SeatsController(SeatsService seatsService) {
        this.seatsService = seatsService;
    }

    @GetMapping
    public ResponseEntity<CinemaSeatsDTO> getCinemaSeats() {
        return seatsService.getCinemaSeats();
    }
}