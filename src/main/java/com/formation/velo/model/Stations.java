package com.formation.velo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "Stations")
public class Stations implements Serializable {

    private static final long serialVersionUID = -767070904974486421L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double latitude;
    private Double longitude;
    private String status;
    private Integer bike_stands;
    private Integer availabe_bikes;
    private Integer availabe_bikes_stands;
    private String recordId;

    private String adress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stations)) return false;
        Stations stations = (Stations) o;
        return id.equals(stations.id) && Objects.equals(name, stations.name) && Objects.equals(latitude, stations.latitude) && Objects.equals(longitude, stations.longitude) && Objects.equals(status, stations.status) && Objects.equals(bike_stands, stations.bike_stands) && Objects.equals(availabe_bikes, stations.availabe_bikes) && Objects.equals(availabe_bikes_stands, stations.availabe_bikes_stands) && Objects.equals(recordId, stations.recordId) && Objects.equals(adress, stations.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latitude, longitude, status, bike_stands, availabe_bikes, availabe_bikes_stands, recordId, adress);
    }
}


