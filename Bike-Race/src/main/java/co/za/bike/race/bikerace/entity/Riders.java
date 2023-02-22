package co.za.bike.race.bikerace.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "riders")
@Data
public class Riders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String fisrt_name;
    private String last_Name;

    public Riders() {
    }

    public Riders(long id) {
        this.id = id;
    }

    public Riders(long id, String fisrt_name, String last_Name) {
        this.id = id;
        this.fisrt_name = fisrt_name;
        this.last_Name = last_Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Riders riders = (Riders) o;
        return id == riders.id && Objects.equals(fisrt_name, riders.fisrt_name) && Objects.equals(last_Name, riders.last_Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fisrt_name, last_Name);
    }

    @Override
    public String toString() {
        return "Riders{" +
                "id=" + id +
                ", fisrt_name='" + fisrt_name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                '}';
    }
}
