package com.formation.velo.service;
import com.formation.velo.model.Parking;



import java.util.List;
import java.util.Optional;

public interface ParkingService {
    List<Parking> findAll();
    Optional<Parking>findById(Integer id);
    Parking save(Parking parking);
    void saveRecord();
    Optional<Parking> findBygrpIdentifiant(String grpIdentifiant);
    void deleteById(Integer id);

    void delete(Parking parking);

    void deleteAll(Parking parking);
}
