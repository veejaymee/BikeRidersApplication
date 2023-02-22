package co.za.bike.race.bikerace.entity;

import co.za.bike.race.bikerace.pojo.CurrentWeather;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "result")
@Data
public class Result implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private long riderid;
    private long raceid;
    private long rank;


    public Result() {
    }

    public Result(long riderid) {
        this.riderid = riderid;
    }

    public Result(long riderid, long raceid) {
        this.riderid = riderid;
        this.raceid = raceid;
    }

    public Result(long id, long riderid, long raceid, long rank) {
        this.id = id;
        this.riderid = riderid;
        this.raceid = raceid;
        this.rank = rank;
    }
}
