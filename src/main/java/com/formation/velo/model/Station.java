package com.formation.velo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "Stations")
public class Station implements Serializable {

    private static final long serialVersionUID = -767070904974486421L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double latitude;
    private Double longitude;
    private String status;
    private Integer bikeStands;
    private Integer availabeBikes;
    private Integer availabeBikesStands;
    private String recordId;

    private String address;


}


