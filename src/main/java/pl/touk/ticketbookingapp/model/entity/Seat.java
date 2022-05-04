package pl.touk.ticketbookingapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = {"seatRow", "seat"})
public class Seat {
    @Min(1)
    @NonNull
    private int seatRow;
    @NonNull
    @Min(1)
    private int seat;

}
