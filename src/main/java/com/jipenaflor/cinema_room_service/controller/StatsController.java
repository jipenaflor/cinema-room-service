package com.jipenaflor.cinema_room_service.controller;

import com.jipenaflor.cinema_room_service.dto.StatsDTO;
import com.jipenaflor.cinema_room_service.service.CinemaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private CinemaService cinemaService;

    public StatsController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping
    public ResponseEntity<StatsDTO> getStats(@RequestParam(required = false) String password) {
        return cinemaService.getStats(password);
    }
}
