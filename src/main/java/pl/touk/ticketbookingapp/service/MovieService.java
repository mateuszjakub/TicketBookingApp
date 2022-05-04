package pl.touk.ticketbookingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.touk.ticketbookingapp.model.dto.MovieRequest;
import pl.touk.ticketbookingapp.model.dto.MovieResponse;
import pl.touk.ticketbookingapp.model.entity.Seance;
import pl.touk.ticketbookingapp.repository.SeanceRepository;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static org.springframework.data.domain.Sort.Order.asc;
import static org.springframework.data.domain.Sort.by;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final SeanceRepository seanceRepository;

    public List<MovieResponse> getMoviesByDate(MovieRequest movieRequest) {

        Sort movieTitleAscDateTimeAscSort = by(asc("movie.title"), asc("dateTime"));
        List<Seance> seances = seanceRepository.findSeanceByDateTimeBetween(movieRequest.getStartDate(), movieRequest.getEndDate(), movieTitleAscDateTimeAscSort);

        return seances.stream()
                .collect(Collectors.groupingBy(seance -> seance.getMovie().getTitle(), TreeMap::new, Collectors.toList()))
                .entrySet()
                .stream()
                .map(x -> new MovieResponse(x.getKey(), x.getValue().stream().map(Seance::getDateTime).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}
