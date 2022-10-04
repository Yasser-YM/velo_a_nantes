package com.formation.velo.service;

import com.formation.velo.model.Stations;

import java.util.List;
import java.util.Optional;

public interface StationService {
    List<Stations> findAll();
    Optional<Stations> findById(Integer id);
    Stations save(Stations Station);

    void deleteById(Integer id);

    void delete(Stations Station);
}
