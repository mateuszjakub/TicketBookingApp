package pl.touk.ticketbookingapp.service;

import pl.touk.ticketbookingapp.model.dto.ReservationRequest;
import pl.touk.ticketbookingapp.model.entity.Reservation;

public class ReservationMapper {

    public static Reservation map(ReservationRequest reservationRequest) {
        return Reservation.builder()
                .seanceId(reservationRequest.getSeanceId())
                .ticket(reservationRequest.getTicketType())
                .firstName(reservationRequest.getFirstName())
                .secondName(reservationRequest.getSecondName())
                .seats(reservationRequest.getSeats())
                .build();
    }

}
