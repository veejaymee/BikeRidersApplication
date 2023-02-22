package co.za.bike.race.bikerace.service;

import co.za.bike.race.bikerace.entity.Result;
import co.za.bike.race.bikerace.entity.Riders;
import co.za.bike.race.bikerace.pojo.BikeRacer;
import co.za.bike.race.bikerace.repository.ResultRepository;
import co.za.bike.race.bikerace.repository.RidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RidersService {

    @Autowired
    RidersRepository ridersRepository;

    @Autowired
    ResultRepository resultRepository;

    public List<Riders> getNotParicipatedRiders(){
        List<Riders> notParicipatedRiders = new ArrayList<>();
        List<Integer> riderIds = ridersRepository.findAll().stream().map(Riders::getId).map(Long::intValue).collect(Collectors.toList());
        List<Integer> resultsRidersIds = resultRepository.findAll().stream().map(Result::getRiderid).map(Long::intValue).collect(Collectors.toList());
        riderIds.removeAll(new HashSet<>(resultsRidersIds));
        riderIds.stream().forEach(r -> {
            Optional<Riders> riders = ridersRepository.findById(r.longValue());
            Riders rider = new Riders();
            riders.ifPresent(ri -> {
                rider.setId(ri.getId());
                rider.setFisrt_name(ri.getFisrt_name());
                rider.setLast_Name(ri.getLast_Name());
                notParicipatedRiders.add(rider);
            });
        });

        return notParicipatedRiders;

    }

}
