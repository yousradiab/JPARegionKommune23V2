package com.example.jparegionkommune23v2.controller;

import com.example.jparegionkommune23v2.model.Kommune;
import com.example.jparegionkommune23v2.model.Region;
import com.example.jparegionkommune23v2.repository.KommuneRepository;
import com.example.jparegionkommune23v2.service.ApiServiceGetKommuner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("kommunepage")
    public ResponseEntity<List<Kommune>> getPageOfKommuner() {
        int page = 4;
        int size = 5;
        Pageable paging = PageRequest.of(page, size);
        Page<Kommune> pageKommune = kommuneRepository.findAll(paging);
        List<Kommune> lstKommuner = pageKommune.getContent();
        return new ResponseEntity<>(lstKommuner, HttpStatus.OK);
    }

    @GetMapping("/kommunepageparm")
    public ResponseEntity<Map<String, Object>> getPageOfKommuner(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable paging = PageRequest.of(page, size);
        Page<Kommune> pageKommune = kommuneRepository.findAll(paging);

        List<Kommune> kommuner = pageKommune.getContent();

        if (kommuner.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        Map<String, Object> response = new HashMap<>();
        response.put("kommuner", kommuner);
        response.put("currentPage", pageKommune.getNumber());
        response.put("totalItems", pageKommune.getTotalElements());
        response.put("totalPages", pageKommune.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
