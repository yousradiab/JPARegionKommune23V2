package com.example.jparegionkommune23v2.controller;

import com.example.jparegionkommune23v2.model.Region;
import com.example.jparegionkommune23v2.repository.KommuneRepository;
import com.example.jparegionkommune23v2.repository.RegionRepository;
import com.example.jparegionkommune23v2.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("region/{kode}")
    public ResponseEntity<Region> region(@PathVariable String kode) {
       Region region =  regionRepository.findById(kode).orElseThrow(
               () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "kode=" + kode + " NOT-FOUND"));
       return ResponseEntity.ok(region);
    }

    @PostMapping("/region")
    public ResponseEntity<Region> postEmployee(@RequestBody Region region) {
        regionRepository.save(region);
        return new ResponseEntity<>(region, HttpStatus.CREATED);
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
