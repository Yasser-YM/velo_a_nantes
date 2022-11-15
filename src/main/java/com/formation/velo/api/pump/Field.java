package com.formation.velo.api.pump;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.joda.time.DateTime;

import java.util.Date;

@Getter
public class Field {
    @SerializedName("ville")
    private String ville;
    @SerializedName("pop")
    private String pop;
    @SerializedName("reg_name")
    private String regName;
    @SerializedName("com_arm_code")
    private String comArmCode;
    @SerializedName("dep_name")
    private String depName;
    @SerializedName("com_code")
    private String comCode;
    @SerializedName("epci_name")
    private String epciName;
    @SerializedName("dep_code")
    private int depCode;
    @SerializedName("services_service")
    private String servicesService;
    @SerializedName("horaires_automate_24_24")
    private String horaires_automate;
    @SerializedName("prix_maj")
    private Date prixMaj;
    @SerializedName("id")
    private int id;
    @SerializedName("reg_code")
    private int regCode;
    @SerializedName("adresse")
    private String adresse;
    @SerializedName("geom")
    private double[] geom;
    @SerializedName("epci_code")
    private String epciCode;
    @SerializedName("cp")
    private String cp;
    @SerializedName("prix_valeur")
    private double prixValeur;
}
