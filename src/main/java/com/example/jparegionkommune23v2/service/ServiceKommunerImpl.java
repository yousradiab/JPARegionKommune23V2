package com.example.jparegionkommune23v2.service;

import com.example.jparegionkommune23v2.model.Kommune;
import com.example.jparegionkommune23v2.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceKommunerImpl implements ServiceKommuner {


    @Autowired
    KommuneRepository kommuneRepository;

    @Override
    public List<Kommune> getKommunerStartsWith(Character c) {
        List<Kommune> kommuner = kommuneRepository.findAll();
        return kommuner.stream().filter(kom -> kom.getNavn().charAt(0) == c).collect(Collectors.toList());
    }
}
