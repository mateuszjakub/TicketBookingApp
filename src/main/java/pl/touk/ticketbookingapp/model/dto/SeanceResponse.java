package pl.touk.ticketbookingapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.touk.ticketbookingapp.model.entity.Seat;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class SeanceResponse implements Serializable {
    private String roomName;
    private List<Seat> availableSeats;

}
