package com.example.jparegionkommune23v2.repository;

import com.example.jparegionkommune23v2.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KommuneRepository extends JpaRepository<Kommune, String> {

    Optional<Kommune> findByNavn(String navn);
    //Optional<Kommune>findKommuneByHrefAndAndNavn(String navn, String href);

    void deleteAllByRegionKode(String kode);

}
