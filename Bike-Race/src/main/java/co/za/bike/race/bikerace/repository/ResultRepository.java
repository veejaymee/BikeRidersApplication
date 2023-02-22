package co.za.bike.race.bikerace.repository;

import co.za.bike.race.bikerace.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findByRaceid(Long race_id);
    List<Result> findByRank(Long rank);
}
