package com.jipenaflor.cinema_room_service.service;

import com.jipenaflor.cinema_room_service.config.CinemaSeats;
import com.jipenaflor.cinema_room_service.dto.PurchaseRequestDTO;
import com.jipenaflor.cinema_room_service.dto.PurchaseResponseDTO;
import com.jipenaflor.cinema_room_service.dto.RefundRequestDTO;
import com.jipenaflor.cinema_room_service.entity.Seat;
import com.jipenaflor.cinema_room_service.exception.InvalidPurchaseException;
import com.jipenaflor.cinema_room_service.exception.InvalidTokenException;
import com.jipenaflor.cinema_room_service.properties.CinemaSeatsProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class TicketsService {

    private CinemaSeats cinemaSeats;
    private CinemaSeatsProperty cinemaSeatsProperty;
    private CinemaService cinemaService;

    public TicketsService(CinemaSeatsProperty cinemaSeatsProperty,
                          CinemaService cinemaService,
                          CinemaSeats cinemaSeats) {
        this.cinemaSeatsProperty = cinemaSeatsProperty;
        this.cinemaSeats = cinemaSeats;
        this.cinemaService = cinemaService;
    }

    public ResponseEntity<PurchaseResponseDTO> purchaseTicket(PurchaseRequestDTO request) {
        if (!isValidRow(request.getRow()) || !isValidColumn(request.getColumn())) {
            throw new InvalidPurchaseException("The number of a row or a column is out of bounds!");
        }

        Seat purchasedSeat = findAvailableSeat(cinemaSeats.getSeats(),
                request.getRow(), request.getColumn());

        if (Objects.isNull(purchasedSeat)) {
            throw new InvalidPurchaseException("The ticket has been already purchased!");
        } else {
            Seat ticketDTO = new Seat();
            ticketDTO.setRow(purchasedSeat.getRow());
            ticketDTO.setColumn(purchasedSeat.getColumn());
            ticketDTO.setPrice(purchasedSeat.getPrice());

            PurchaseResponseDTO purchaseResponseDTO = new PurchaseResponseDTO();
            purchaseResponseDTO.setTicket(ticketDTO);

            UUID token = UUID.randomUUID();
            purchaseResponseDTO.setToken(token);

            cinemaService.addPurchase(token, purchasedSeat);

            return ResponseEntity.ok().body(purchaseResponseDTO);
        }
    }

    public ResponseEntity<PurchaseResponseDTO> refundTicket(RefundRequestDTO request) {
        if (cinemaService.isValidPurchase(request.getToken())) {
            Seat seat = cinemaService.getPurchasedSeat(request.getToken());
            seat.setAvailable(true);

            cinemaService.removePurchase(request.getToken(), seat);

            PurchaseResponseDTO purchaseResponseDTO = new PurchaseResponseDTO();
            purchaseResponseDTO.setTicket(seat);

            return ResponseEntity.ok().body(purchaseResponseDTO);
        } else {
            throw new InvalidTokenException("Wrong token!");
        }
    }

    private Seat findAvailableSeat(Seat[][] seats, int row, int col) {
        Seat[] seatRow = seats[row - 1];
        for (Seat seat: seatRow) {
            if (seat.getColumn() == (col) && seat.isAvailable()) {
                seat.setAvailable(false);
                return seat;
            }
        }
        return null;
    }

    private boolean isValidRow(int row) {
        return row > 0 && row <= cinemaSeatsProperty.getRows();
    }

    private boolean isValidColumn(int column) {
        return column > 0 && column <= cinemaSeatsProperty.getColumns();
    }
}