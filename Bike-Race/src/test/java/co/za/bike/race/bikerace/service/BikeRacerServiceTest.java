package co.za.bike.race.bikerace.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.za.bike.race.bikerace.entity.Race;
import co.za.bike.race.bikerace.entity.Result;
import co.za.bike.race.bikerace.entity.Riders;
import co.za.bike.race.bikerace.exceptions.ResultsNotFoundException;
import co.za.bike.race.bikerace.pojo.BikeRacer;
import co.za.bike.race.bikerace.repository.RaceRepository;
import co.za.bike.race.bikerace.repository.ResultRepository;
import co.za.bike.race.bikerace.repository.RidersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BikeRacerServiceTest {

    @InjectMocks
    private ResultService resultService;

    @InjectMocks
    LiveWeatherService liveWeatherService;

    @Mock
    private ResultRepository resultRepository;

    @Mock
    private RidersRepository ridersRepository;

    @Mock
    private RaceRepository raceRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetResultsByRece() {
        Long raceId = 100L;

        // Create a list of results to be returned by the mock repository
        List<Result> resultList = new ArrayList<>();
        resultList.add(new Result(1L, 2L, 100L, 3));
        resultList.add(new Result(2L, 3L, 100L, 1));

        Riders rider1 = new Riders(2, "Paul", "p");
        Race race = new Race(100L, "mountain_race", "Cape town", "South Africa");

        // Set up the mock repository to return the list of results
        when(resultRepository.findByRaceid(raceId)).thenReturn(resultList);
        when(ridersRepository.findById(2L)).thenReturn(Optional.of(rider1));
        when(raceRepository.findById(raceId)).thenReturn(Optional.of(race));

        // Call the method being tested
        List<BikeRacer> bikeRacerList = resultService.getResultsByRece(raceId);

        // Verify that the mock repository was called with the correct argument
        verify(resultRepository).findByRaceid(raceId);

        // Verify that the correct list of BikeRacers was returned
        assertEquals(2, bikeRacerList.size());
    }

}

