package com.example.jparegionkommune23v2.repository;

import com.example.jparegionkommune23v2.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, String> {

    //@Query("delete k from Kommune k where k.region.kode = %?1")
    //void deleteAllByR findByBrandEndsWith(String brand);

}
