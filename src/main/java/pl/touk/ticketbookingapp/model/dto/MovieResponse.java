package pl.touk.ticketbookingapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class MovieResponse implements Serializable {
    private String title;
    private List<LocalDateTime> dateTimes;
}
