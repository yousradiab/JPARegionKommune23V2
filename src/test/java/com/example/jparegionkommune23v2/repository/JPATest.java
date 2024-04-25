package com.example.jparegionkommune23v2.repository;


import com.example.jparegionkommune23v2.model.Kommune;
import com.example.jparegionkommune23v2.model.Region;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JPATest {

    @Autowired
    KommuneRepository kommuneRepository;

    @Autowired
    RegionRepository regionRepository;

    @Test
    void testGetKommuner() {
        List<Kommune> lst = kommuneRepository.findAll();
        assertNotEquals(0, lst.size());
    }


    @Test
    void countKommuner() {
        assertEquals(99, kommuneRepository.count());
    }


    @Test
    void testGetKommunerDelSave() {
        Optional<Kommune> rosOpt = kommuneRepository.findByNavn("Roskilde");
        if (rosOpt.isPresent()) {
            Kommune ros = rosOpt.get();
            kommuneRepository.delete(ros);
            assertEquals(98, kommuneRepository.count());
            kommuneRepository.save(ros);
            assertEquals(99, kommuneRepository.count());
        } else {
            fail("Vi fik ikke nogen Roskilde");
        }
    }

    @Test
    void testRegionCount() {
        Optional<Region> regOpt = regionRepository.findById("1081");
        if (regOpt.isPresent()) {
            Set<Kommune> setKom = regOpt.get().getKommuner();
            assertEquals(20, setKom.size());
        } else {
            fail("fandt ingen kommuner");
        }
    }

    @Test
    void testSetKommune() {
        Set<Kommune> setKom = new HashSet<>();
        Kommune k1 = new Kommune();
        k1.setKode("1");
        setKom.add(k1);
        Kommune k2 = new Kommune();
        k2.setKode("1");
        setKom.add(k2);
        assertEquals(1, setKom.size());
    }

}


