package pl.touk.ticketbookingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.touk.ticketbookingapp.model.dto.SeanceResponse;
import pl.touk.ticketbookingapp.service.SeanceService;

@RestController
@RequestMapping("/seances")
@RequiredArgsConstructor
public class SeanceController {

    private final SeanceService seanceService;

    @GetMapping("/{id}")
    public SeanceResponse getSeance(@PathVariable Long id) {
        return seanceService.getSeanceById(id);
    }


}
