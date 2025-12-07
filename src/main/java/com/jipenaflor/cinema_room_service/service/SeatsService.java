package com.jipenaflor.cinema_room_service.service;

import com.jipenaflor.cinema_room_service.config.CinemaSeats;
import com.jipenaflor.cinema_room_service.dto.CinemaSeatsDTO;
import com.jipenaflor.cinema_room_service.entity.Seat;
import com.jipenaflor.cinema_room_service.properties.CinemaSeatsProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SeatsService {

    private CinemaSeats cinemaSeats;

    public SeatsService(CinemaSeats cinemaSeats) {
        this.cinemaSeats = cinemaSeats;
    }

    public ResponseEntity<CinemaSeatsDTO> getCinemaSeats() {
        CinemaSeatsDTO cinemaSeatsDTO = new CinemaSeatsDTO();
        cinemaSeatsDTO.setRows(cinemaSeats.getRows());
        cinemaSeatsDTO.setColumns(cinemaSeats.getColumns());

        List<Seat> seats = listSeats(cinemaSeats.getSeats());
        cinemaSeatsDTO.setSeats(seats);

        return ResponseEntity.ok()
                .body(cinemaSeatsDTO);
    }

    private List<Seat> listSeats(Seat[][] seats) {
        return Arrays.stream(seats)
                .flatMap(Arrays::stream)
                .toList();
    }
}