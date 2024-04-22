package com.example.jparegionkommune23v2.controller;

import com.example.jparegionkommune23v2.model.Kommune;
import com.example.jparegionkommune23v2.model.Region;
import com.example.jparegionkommune23v2.repository.KommuneRepository;
import com.example.jparegionkommune23v2.service.ApiServiceGetKommuner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class KommuneRESTController {

    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;

    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("getkommuner")
    public List<Kommune> getKommuner() {
        List<Kommune> lstKommuner = apiServiceGetKommuner.getKommuner();
        return lstKommuner;
    }

    @GetMapping("kommuner")
    public List<Kommune> kommuner() {
        return kommuneRepository.findAll();
    }


    @GetMapping("kommune/{name}")
    public Kommune kommuneByName(@PathVariable String name) {
        return kommuneRepository.findByNavn(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Kommune med navn="+name));
    }

}
