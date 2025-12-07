package com.jipenaflor.cinema_room_service.config;

import com.jipenaflor.cinema_room_service.entity.Cinema;
import com.jipenaflor.cinema_room_service.entity.Seat;
import com.jipenaflor.cinema_room_service.properties.CinemaSeatsProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class CinemaConfig {

    private CinemaSeatsProperty cinemaSeatsProperty;

    public CinemaConfig(CinemaSeatsProperty cinemaSeatsProperty) {
        this.cinemaSeatsProperty = cinemaSeatsProperty;
    }

    @Bean
    public Cinema setCinema() {
        return new Cinema(0,
                cinemaSeatsProperty.getAvailable(),
                0, new HashMap<>());
    }

    @Bean
    public CinemaSeats setCinemaSeats() {
        return new CinemaSeats(cinemaSeatsProperty.getSize(),
                cinemaSeatsProperty.getRows(),
                cinemaSeatsProperty.getColumns(),
                cinemaSeatsProperty.getPriceHigh(),
                cinemaSeatsProperty.getPriceLow());
    }
}