package co.za.bike.race.bikerace.pojo;

import lombok.Data;

@Data
public class BikeRacer {
    private String first_name;
    private String last_name;
    private String race_name;
    private long rank;
    private String place;
    private String country;
    private String weather;
    private CurrentWeather currentWeather;

}
