package pl.touk.ticketbookingapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ReservationResponse implements Serializable {

    private BigDecimal totalAmount;
    private LocalDateTime expirationTime;
}
