package com.jipenaflor.cinema_room_service.service;

import com.jipenaflor.cinema_room_service.dto.CinemaSeatsDTO;
import com.jipenaflor.cinema_room_service.dto.PurchaseRequestDTO;
import com.jipenaflor.cinema_room_service.dto.PurchaseResponseDTO;
import com.jipenaflor.cinema_room_service.entity.CinemaSeats;
import com.jipenaflor.cinema_room_service.entity.Seat;
import com.jipenaflor.cinema_room_service.exception.InvalidPurchaseException;
import com.jipenaflor.cinema_room_service.properties.CinemaSeatsProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class SeatsService {

    private CinemaSeatsProperty cinemaSeatsProperty;
    private CinemaSeats cinemaSeats;

    public SeatsService(CinemaSeatsProperty cinemaSeatsProperty) {
        this.cinemaSeatsProperty = cinemaSeatsProperty;
        this.cinemaSeats = new CinemaSeats(cinemaSeatsProperty.getSize(),
                cinemaSeatsProperty.getPriceHigh(), cinemaSeatsProperty.getPriceLow());
    }

    public ResponseEntity<CinemaSeatsDTO> getCinemaSeats() {
        CinemaSeatsDTO cinemaSeatsDTO = new CinemaSeatsDTO();
        cinemaSeatsDTO.setRows(cinemaSeatsProperty.getRows());
        cinemaSeatsDTO.setColumns(cinemaSeatsProperty.getColumns());

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