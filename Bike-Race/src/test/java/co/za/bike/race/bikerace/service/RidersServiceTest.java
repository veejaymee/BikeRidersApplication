package co.za.bike.race.bikerace.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.za.bike.race.bikerace.entity.Result;
import co.za.bike.race.bikerace.entity.Riders;
import co.za.bike.race.bikerace.repository.ResultRepository;
import co.za.bike.race.bikerace.repository.RidersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RidersServiceTest {

    @Mock
    private RidersRepository ridersRepository;

    @Mock
    private ResultRepository resultRepository;

    @InjectMocks
    private RidersService ridersService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetNotParicipatedRiders() {
        List<Riders> allRiders = new ArrayList<>();
        Riders rider1 = new Riders(1L);
        Riders rider3 = new Riders(2L);
        allRiders.add(rider1);
        allRiders.add(rider3);

        List<Riders> allRider = new ArrayList<>();
        Riders ride1 = new Riders(1L, "Vijaya", "V");

        List<Result> allResults = new ArrayList<>();
        Result result1 = new Result(2L);
        Result result2 = new Result(3L);
        Result result3 = new Result(4L);
        allResults.add(result1);
        allResults.add(result2);
        allResults.add(result3);

        when(ridersRepository.findAll()).thenReturn(allRiders);
        when(resultRepository.findAll()).thenReturn(allResults);
        when(ridersRepository.findById(1L)).thenReturn(Optional.of(ride1));

        List<Riders> expected = new ArrayList<>();
        expected.add(ride1);

        List<Riders> actual = ridersService.getNotParicipatedRiders();
        assertEquals(expected, actual);
    }
}
