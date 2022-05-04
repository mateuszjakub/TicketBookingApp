package pl.touk.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.touk.ticketbookingapp.model.dto.ReservationRequest;
import pl.touk.ticketbookingapp.model.dto.ReservationResponse;
import pl.touk.ticketbookingapp.model.entity.Reservation;
import pl.touk.ticketbookingapp.model.entity.Room;
import pl.touk.ticketbookingapp.model.entity.Seance;
import pl.touk.ticketbookingapp.model.entity.Seat;
import pl.touk.ticketbookingapp.repository.ReservationRepository;
import pl.touk.ticketbookingapp.repository.SeanceRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private static final long EXPIRATION_PERIOD = 15;
    private final SeanceRepository seanceRepository;
    private final ReservationRepository reservationRepository;

    @Transactional
    public ReservationResponse getReservationResponse(ReservationRequest reservationRequest) {
        Seance seance = seanceRepository.findById(reservationRequest.getSeanceId()).orElseThrow();
        LocalDateTime expirationTime = seance.getDateTime().minusMinutes(EXPIRATION_PERIOD);
        checkReservationTime(expirationTime);
        checkSeatRange(reservationRequest, seance.getRoom());
        checkSeatAvailibility(seance, reservationRequest);

        BigDecimal totalAmount = reservationRequest.getTicketType()
                .getPrice()
                .multiply(BigDecimal.valueOf(reservationRequest.getSeats().size()));
        Reservation reservation = ReservationMapper.map(reservationRequest);
        reservationRepository.save(reservation);
        checkSingleSeatBetween(reservationRequest, seance);
        return new ReservationResponse(totalAmount, expirationTime);
    }

    private void checkSingleSeatBetween(ReservationRequest reservationRequest, Seance seance) {
        Set<Seat> bookedSeats = getBookedSeats(seance);
        Set<Seat> wantedSeats = reservationRequest.getSeats();

        for (Seat wantedSeat : wantedSeats) {
            Seat nextSeat = new Seat(wantedSeat.getSeatRow(), wantedSeat.getSeat() + 1);
            Seat seatAfterNextSeat = new Seat(wantedSeat.getSeatRow(), wantedSeat.getSeat() + 2);
            Seat previousSeat = new Seat(wantedSeat.getSeatRow(), wantedSeat.getSeat() - 1);
            Seat seatBeforePreviousSeat = new Seat(wantedSeat.getSeatRow(), wantedSeat.getSeat() - 2);
            if (!bookedSeats.contains(nextSeat) && bookedSeats.contains(seatAfterNextSeat) ||
                    !bookedSeats.contains(previousSeat) && bookedSeats.contains(seatBeforePreviousSeat)) {
                throw new IllegalStateException("cannot be single place left over between two reserved seats");
            }
        }


    }

    private void checkSeatAvailibility(Seance seance, ReservationRequest reservationRequest) {
        Set<Seat> bookedSeats = getBookedSeats(seance);
        boolean isAnySeatOccupied = bookedSeats.stream().anyMatch(bookedSeat -> reservationRequest.getSeats().contains(bookedSeat));
        if (isAnySeatOccupied) {
            throw new IllegalStateException("Seat is occupied");
        }
    }

    private Set<Seat> getBookedSeats(Seance seance) {
        return reservationRepository.findAllBySeanceId(seance.getId())
                .stream()
                .map(Reservation::getSeats)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    private void checkSeatRange(ReservationRequest reservationRequest, Room room) {
        reservationRequest.getSeats()
                .forEach(seat -> {
                    if (room.getRowNo() < seat.getSeatRow() || room.getSeatNo() < seat.getSeat()) {
                        throw new IllegalStateException("Seat out of range");
                    }
                });
    }

    private void checkReservationTime(LocalDateTime expirationTime) {
        if (LocalDateTime.now().isAfter(expirationTime)) {
            throw new IllegalStateException(String.format("reservation is allowed only %s minutes before seance", EXPIRATION_PERIOD));
        }
    }


}
