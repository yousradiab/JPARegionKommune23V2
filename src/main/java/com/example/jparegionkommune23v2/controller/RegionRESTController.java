package com.example.jparegionkommune23v2.controller;

import com.example.jparegionkommune23v2.model.Region;
import com.example.jparegionkommune23v2.repository.KommuneRepository;
import com.example.jparegionkommune23v2.repository.RegionRepository;
import com.example.jparegionkommune23v2.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RegionRESTController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("getregioner")
    public List<Region> getRegioner() {
        List<Region> lstRegioner = apiServiceGetRegioner.getRegioner();
        return lstRegioner;
    }

    @GetMapping("regioner")
    public List<Region> regioner() {
        return regionRepository.findAll();
    }

    @DeleteMapping("/region/{kode}")
    public ResponseEntity<String> deleteRegion(@PathVariable String kode) {
        Optional<Region> reg1 = regionRepository.findById(kode);
        if (reg1.isPresent()) {
            kommuneRepository.deleteAll();
            regionRepository.deleteById(kode);
            return ResponseEntity.ok("Region delete");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Region not found id=" + kode);
        }
    }



}
