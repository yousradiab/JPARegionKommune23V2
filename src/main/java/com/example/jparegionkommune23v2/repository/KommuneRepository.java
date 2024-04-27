package com.example.jparegionkommune23v2.repository;

import com.example.jparegionkommune23v2.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KommuneRepository extends JpaRepository<Kommune, String> {

    Optional<Kommune> findByNavn(String navn);
<<<<<<< HEAD
    //Optional<Kommune>findKommuneByHrefAndAndNavn(String navn, String href);
=======
    Optional<Kommune> findKommuneByNavnAndHref(String navn, String href);
>>>>>>> 664d19f8dfc315d1e4c83925de2426a25991053e

    void deleteAllByRegionKode(String kode);

}
