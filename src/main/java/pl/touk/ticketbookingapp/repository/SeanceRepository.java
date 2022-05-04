package pl.touk.ticketbookingapp.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.touk.ticketbookingapp.model.entity.Seance;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {

    List<Seance> findSeanceByDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate, Sort sort);


}
