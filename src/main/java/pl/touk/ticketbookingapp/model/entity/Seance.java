package pl.touk.ticketbookingapp.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Seance {

    @ManyToOne
    Room room;
    @ManyToOne
    Movie movie;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "seance_date_time")
    private LocalDateTime dateTime;
}
