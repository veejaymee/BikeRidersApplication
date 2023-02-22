package co.za.bike.race.bikerace.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="race")
@Data
public class Race implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String race_name;
    private String place;
    private String country;

    public Race(long id, String race_name, String place, String country) {
        this.id = id;
        this.race_name = race_name;
        this.place = place;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return id == race.id && Objects.equals(race_name, race.race_name) && Objects.equals(place, race.place) && Objects.equals(country, race.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, race_name, place, country);
    }
}
