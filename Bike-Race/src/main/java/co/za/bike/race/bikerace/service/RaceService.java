package co.za.bike.race.bikerace.service;

import co.za.bike.race.bikerace.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceService {

    @Autowired
    RaceRepository raceRepository;
}
