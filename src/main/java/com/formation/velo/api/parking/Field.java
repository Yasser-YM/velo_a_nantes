package com.formation.velo.api.parking;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Field {
    @SerializedName("grp_disponible")
    private int grpDisponible;
    @SerializedName("grp_nom")
    private String grpNom;
    @SerializedName("grp_statut")
    private int grpStatut;
    @SerializedName("grp_identifiant")
    private String grpIdentifiant;
    private int disponibilite;
    private String idobj;
    @SerializedName("grp_complet")
    private int grpComplet;
    @SerializedName("grp_exploitation")
    private int grpExploitation;
    private Double [] location;


}
