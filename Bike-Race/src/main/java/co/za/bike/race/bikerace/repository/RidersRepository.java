package co.za.bike.race.bikerace.repository;

import co.za.bike.race.bikerace.entity.Riders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RidersRepository extends JpaRepository<Riders, Long> {


}
