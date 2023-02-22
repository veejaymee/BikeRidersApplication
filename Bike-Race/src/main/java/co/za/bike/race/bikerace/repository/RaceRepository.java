package co.za.bike.race.bikerace.repository;

import co.za.bike.race.bikerace.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {

}
