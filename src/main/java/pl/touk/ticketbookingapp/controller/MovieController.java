package pl.touk.ticketbookingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.touk.ticketbookingapp.model.dto.MovieRequest;
import pl.touk.ticketbookingapp.model.dto.MovieResponse;
import pl.touk.ticketbookingapp.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<MovieResponse> getMoviesByDate(MovieRequest movieRequest) {
        return movieService.getMoviesByDate(movieRequest);
    }

}
