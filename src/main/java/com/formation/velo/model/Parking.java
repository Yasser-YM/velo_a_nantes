package com.formation.velo.model;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Parkings")
public class Parking implements Serializable {
    private static final long serialVersionUID = -767070904974486428L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer grpDisponible;
    private String grpNom;
    private Integer grpStatut;
    private String grpIdentifiant;
    private Integer disponibilite;
    private String idobj;
    private Integer grpComplet;
    private Integer grpExploitation;
    public Double latitude;
    public Double longitude;

    private String recordId;

}
