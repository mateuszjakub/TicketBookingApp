package pl.touk.ticketbookingapp.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Movie {

    @OneToMany
    @JoinColumn(name = "moovie_id", updatable = false, insertable = false)
    List<Seance> seance;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private int duration;

}
