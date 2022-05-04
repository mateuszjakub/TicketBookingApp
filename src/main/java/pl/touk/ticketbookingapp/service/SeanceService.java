package pl.touk.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.touk.ticketbookingapp.model.dto.SeanceResponse;
import pl.touk.ticketbookingapp.model.entity.Reservation;
import pl.touk.ticketbookingapp.model.entity.Seance;
import pl.touk.ticketbookingapp.model.entity.Seat;
import pl.touk.ticketbookingapp.repository.ReservationRepository;
import pl.touk.ticketbookingapp.repository.SeanceRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeanceService {

    private final SeanceRepository seanceRepository;
    private final ReservationRepository reservationRepository;

    public SeanceResponse getSeanceById(long id) {
        Seance seance = seanceRepository.findById(id).orElseThrow(() -> new RuntimeException("seance not found"));
        Set<Seat> allSeats = seance
                .getRoom()
                .getSeats();

        Set<Seat> bookedSeats = reservationRepository.findAllBySeanceId(id).stream()
                .map(Reservation::getSeats)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());

        allSeats.removeAll(bookedSeats);
        List<Seat> sortedSeats = allSeats.stream()
                .sorted(Comparator.comparing(Seat::getSeatRow).thenComparing(Seat::getSeat))
                .collect(Collectors.toList());

        return new SeanceResponse(seance.getRoom().getName(), sortedSeats);
    }


}
