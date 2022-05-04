package pl.touk.ticketbookingapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long seanceId;
    @Enumerated(value = EnumType.STRING)
    private Ticket ticket;
    @Pattern(regexp = "^[A-ZĄĆĘŁŃŚŻŹ][a-ząćęłńśżź]*")
    @Size(min = 3, message = "{validation.name.size.too_short}")
    private String firstName;
    @Pattern(regexp = "^([A-ZĄĆĘŁŃŚŻŹ][a-ząćęłńśżź]*)([-][A-ZĄĆĘŁŃŚŻŹ][a-ząćęłńśżź]*)?")
    @Size(min = 3, message = "{validation.surname.size.too_short}")
    private String secondName;
    @ElementCollection
    private Set<Seat> seats;


}
