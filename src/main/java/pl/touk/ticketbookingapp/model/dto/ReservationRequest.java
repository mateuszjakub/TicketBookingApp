package pl.touk.ticketbookingapp.model.dto;

import lombok.Data;
import pl.touk.ticketbookingapp.model.entity.Seat;
import pl.touk.ticketbookingapp.model.entity.Ticket;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class ReservationRequest {

    private long seanceId;
    @Valid
    private Set<Seat> seats;
    @Pattern(regexp = "^[A-ZĄĆĘŁŃŚŻŹ][a-ząćęłńśżź]*")
    @Size(min = 3, message = "{validation.name.size.too_short}")
    private String firstName;
    @Pattern(regexp = "^([A-ZĄĆĘŁŃŚŻŹ][a-ząćęłńśżź]*)([-][A-ZĄĆĘŁŃŚŻŹ][a-ząćęłńśżź]*)?")
    @Size(min = 3, message = "{validation.surname.size.too_short}")
    private String secondName;
    private Ticket ticketType;

}
