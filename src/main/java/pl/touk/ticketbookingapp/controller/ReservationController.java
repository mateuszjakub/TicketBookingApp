package pl.touk.ticketbookingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.touk.ticketbookingapp.model.dto.ReservationRequest;
import pl.touk.ticketbookingapp.model.dto.ReservationResponse;
import pl.touk.ticketbookingapp.service.ReservationService;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ReservationResponse createReservation(@RequestBody @Validated ReservationRequest reservationRequest) {

        return reservationService.getReservationResponse(reservationRequest);
    }
}
