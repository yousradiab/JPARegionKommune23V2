package com.example.jparegionkommune23v2.repository;

import com.example.jparegionkommune23v2.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, String> {
}
