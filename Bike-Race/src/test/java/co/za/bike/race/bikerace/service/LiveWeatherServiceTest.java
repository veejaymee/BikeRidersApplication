package co.za.bike.race.bikerace.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URISyntaxException;

import co.za.bike.race.bikerace.pojo.CurrentWeather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class LiveWeatherServiceTest {

    @InjectMocks
    LiveWeatherService liveWeatherService;
    @Mock
    private CurrentWeather currentWeather;

    @InjectMocks
    ResultService resultService;

    @BeforeEach
    public void setUp() {
        currentWeather = new CurrentWeather("Clear",new BigDecimal(20),new BigDecimal(19.96),new BigDecimal(7.72));
    }

    @Test
    public void testGetLiveWeather() throws URISyntaxException, UnsupportedEncodingException {
        String place = "Cape Town";
        String country = "South Africa";

        when(liveWeatherService.getCurrentWeather(place, country)).thenReturn(currentWeather);

        CurrentWeather actualCurrentWeather = resultService.liveWeatherService.getCurrentWeather(place, country);

        assertEquals(currentWeather, actualCurrentWeather);
    }
}

