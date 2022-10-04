package com.formation.velo.repository;

import com.formation.velo.model.Stations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Stations, Integer> {
}
