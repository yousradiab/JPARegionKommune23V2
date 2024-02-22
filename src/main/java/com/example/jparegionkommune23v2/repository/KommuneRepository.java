package com.example.jparegionkommune23v2.repository;

import com.example.jparegionkommune23v2.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KommuneRepository extends JpaRepository<Kommune, String> {

    void deleteAllByRegionKode(String kode);

}
