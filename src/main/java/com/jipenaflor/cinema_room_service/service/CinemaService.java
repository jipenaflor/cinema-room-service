package com.jipenaflor.cinema_room_service.service;

import com.jipenaflor.cinema_room_service.dto.StatsDTO;
import com.jipenaflor.cinema_room_service.entity.Cinema;
import com.jipenaflor.cinema_room_service.entity.Seat;
import com.jipenaflor.cinema_room_service.exception.InvalidManagerPasswordException;
import com.jipenaflor.cinema_room_service.properties.CinemaSeatsProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class CinemaService {

    private Cinema cinema;
    private CinemaSeatsProperty cinemaSeatsProperty;

    public final static String PASSWORD = "super_secret";

    public CinemaService(CinemaSeatsProperty cinemaSeatsProperty) {
        this.cinemaSeatsProperty = cinemaSeatsProperty;
        this.cinema = new Cinema(0, cinemaSeatsProperty.getAvailable(),
                0, new HashMap<>());
    }

    public ResponseEntity<StatsDTO> getStats(String password) {
        if (PASSWORD.equals(password)) {
            StatsDTO stats = new StatsDTO();
            stats.setIncome(cinema.getIncome());
            stats.setAvailable(cinema.getAvailable());
            stats.setPurchased(cinema.getPurchased());
            return ResponseEntity.ok().body(stats);
        } else {
            throw new InvalidManagerPasswordException("The password is wrong!");
        }
    }

    public void addPurchase(UUID token, Seat purchasedSeat) {
        cinema.getPurchasedSeats().put(token, purchasedSeat);
        cinema.setIncome(cinema.getIncome() + purchasedSeat.getPrice());
        cinema.setPurchased(cinema.getPurchasedSeats().size());
        cinema.setAvailable(cinema.getAvailable() - 1);
    }

    public void removePurchase(UUID token, Seat purchasedSeat) {
        cinema.getPurchasedSeats().remove(token);
        cinema.setIncome(cinema.getIncome() - purchasedSeat.getPrice());
        cinema.setPurchased(cinema.getPurchasedSeats().size());
        cinema.setAvailable(cinema.getAvailable() + 1);
    }

    public boolean isValidPurchase(UUID token) {
        return cinema.getPurchasedSeats().containsKey(token);
    }

    public Seat getPurchasedSeat(UUID token) {
        return cinema.getPurchasedSeats().getOrDefault(token, null);
    }
}