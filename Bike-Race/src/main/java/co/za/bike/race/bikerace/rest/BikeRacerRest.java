package co.za.bike.race.bikerace.rest;

import co.za.bike.race.bikerace.entity.Race;
import co.za.bike.race.bikerace.entity.Result;
import co.za.bike.race.bikerace.entity.Riders;
import co.za.bike.race.bikerace.pojo.BikeRacer;
import co.za.bike.race.bikerace.pojo.CurrentWeather;
import co.za.bike.race.bikerace.repository.RidersRepository;
import co.za.bike.race.bikerace.service.LiveWeatherService;
import co.za.bike.race.bikerace.service.ResultService;
import co.za.bike.race.bikerace.service.RidersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;


@RestController
public class BikeRacerRest {

    @Autowired
    ResultService resultService;

    @Autowired
    RidersService ridersService;

    @Autowired
    LiveWeatherService liveWeatherService;

    @Operation(summary = "Get Race result by its id, Id should be 100,101,102..etc")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Race Result for the 3 highest rank Riders ",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Riders.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Race not found",
                    content = @Content) })
    @GetMapping("/race/{race_id}")
    @ResponseBody
    public List<BikeRacer> getResultsBy_Rece(@PathVariable("race_id")  Long race_id){
        List<BikeRacer> bikeRacerList = resultService.getResultsByRece(race_id);
        return bikeRacerList;
    }

    @Operation(summary = "Get All Race results")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the All Race Result for the 3 highest rank Riders per Race",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Race.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Race not found",
                    content = @Content) })
    @GetMapping("/allRaceResults")
    @ResponseBody
    public List<BikeRacer> getAllRaceResults(){
        List<BikeRacer> bikeRacerList = resultService.getAllRaceResults();
        return bikeRacerList;
    }

    @Operation(summary = "Get not participated Riders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found not participated Riders in all Races",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Result.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Race not found",
                    content = @Content) })
    @GetMapping("/notParicipatedRiders")
    @ResponseBody
    public List<Riders> getNotParicipatedRiders(){
        List<Riders> notParicipatedRiders = ridersService.getNotParicipatedRiders();

        return notParicipatedRiders;
    }

    @Operation(summary = "Current weather integrated to the race results, But just verification purpose Service added here")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found current weather for the city",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Result.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Race not found",
                    content = @Content) })
    @GetMapping("/current-weather/{city}/{country}")
    @ResponseBody
    public CurrentWeather getCurrentWeather(@PathVariable(name="city") @NotBlank @Size(max = 20) String city,
                                            @PathVariable(name="country") @NotBlank @Size(max = 10) String country) throws URISyntaxException, UnsupportedEncodingException {
            CurrentWeather currentWeather = liveWeatherService.getCurrentWeather(city,country);

        return currentWeather;
    }

}
