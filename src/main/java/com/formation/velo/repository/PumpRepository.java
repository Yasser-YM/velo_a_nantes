package com.formation.velo.repository;

import com.formation.velo.model.Pump;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PumpRepository extends JpaRepository<Pump, Integer> {
}
