package pl.touk.ticketbookingapp.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Room {

    //    @OneToMany
//    @JoinColumn(name = "room_id", updatable = false, insertable = false)
//    List<Seance> seance;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int rowNo;
    private int seatNo;

    public Set<Seat> getSeats() {
        Set<Seat> seats = new HashSet<>();
        for (int i = 1; i <= rowNo; i++) {
            for (int j = 1; j <= seatNo; j++) {
                seats.add(new Seat(i, j));
            }
        }
        return seats;
    }
}
