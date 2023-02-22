package co.za.bike.race.bikerace.service;

import co.za.bike.race.bikerace.entity.Race;
import co.za.bike.race.bikerace.entity.Result;
import co.za.bike.race.bikerace.entity.Riders;
import co.za.bike.race.bikerace.exceptions.ResultsNotFoundException;
import co.za.bike.race.bikerace.pojo.BikeRacer;
import co.za.bike.race.bikerace.pojo.CurrentWeather;
import co.za.bike.race.bikerace.repository.RaceRepository;
import co.za.bike.race.bikerace.repository.ResultRepository;
import co.za.bike.race.bikerace.repository.RidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultService {

    @Autowired
    ResultRepository resultRepository;

    @Autowired
    RidersRepository ridersRepository;

    @Autowired
    RaceRepository raceRepository;

    @Autowired
    LiveWeatherService liveWeatherService;

    public List<BikeRacer> getResultsByRece(Long race_id){
        List<BikeRacer> bikeRacerList;
        try {
            List<Result> resultList = resultRepository.findByRaceid(race_id);
            bikeRacerList = getBikeRacerPojos(resultList);

        }catch (ResultsNotFoundException exc) {
                throw new ResultsNotFoundException(
                        HttpStatus.NOT_FOUND, "Results Not Found", exc);
            }
        return bikeRacerList;
    }

    public List<BikeRacer> getAllRaceResults(){
        List<BikeRacer> bikeRacerList = new ArrayList<>();
        try{
            List<Result> resultList =resultRepository.findAll();
            bikeRacerList = getBikeRacerPojos(resultList);

        }catch (ResultsNotFoundException exc) {
            throw new ResultsNotFoundException(
                    HttpStatus.NOT_FOUND, "Results Not Found", exc);
        }
        return bikeRacerList;
    }
    private List<BikeRacer> getBikeRacerPojos(List<Result> resultList) {
        List<BikeRacer> bikeRacerList = new ArrayList<>();
        try {
            resultList = resultList.stream().filter(r -> r.getRank() == 1 || r.getRank() == 2 || r.getRank() == 3).collect(Collectors.toList());
            resultList.forEach(r -> {
                BikeRacer bikeRacer = new BikeRacer();
                Optional<Riders> riders = ridersRepository.findById(r.getRiderid());
                riders.ifPresent(rider -> {
                    bikeRacer.setFirst_name(rider.getFisrt_name());
                    bikeRacer.setLast_name(rider.getLast_Name());
                });
                Optional<Race> races = raceRepository.findById(r.getRaceid());
                races.ifPresent(race -> {
                    bikeRacer.setRace_name(race.getRace_name());
                    bikeRacer.setPlace(race.getPlace());
                    bikeRacer.setCountry(race.getCountry());
                });
                bikeRacer.setRank(r.getRank());
                try {
                    bikeRacer.setCurrentWeather(getLiveWeather(bikeRacer.getPlace(), bikeRacer.getCountry()));
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
                bikeRacerList.add(bikeRacer);
            });
        }catch (ResultsNotFoundException exc) {
            throw new ResultsNotFoundException(
                    HttpStatus.NOT_FOUND, "Results Not Found", exc);
        }
        return bikeRacerList;
    }

    private CurrentWeather getLiveWeather(String place, String country) throws URISyntaxException, UnsupportedEncodingException {
        return liveWeatherService.getCurrentWeather(place, country);
    }


}
