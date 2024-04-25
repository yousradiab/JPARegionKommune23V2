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
    private RegionRepository regionRepository;

    @Test
    void testGetKommuner() {
        List<Kommune> kommuneList = kommuneRepository.findAll();
        assertNotEquals(0,kommuneList.size());
    }

    @Test
    void countKommuner() {
        assertEquals(99,kommuneRepository.count());
    }

    @Test
    void testGetKommuneDelSave(){
        Optional<Kommune> rosOpt = kommuneRepository.findByNavn("Roskilde");
        if(rosOpt.isPresent()){
            Kommune rosKommune = rosOpt.get();
            kommuneRepository.delete(rosKommune);
            assertEquals(98, kommuneRepository.count());
            kommuneRepository.save(rosKommune);
            assertEquals(99, kommuneRepository.count());

        }else {
            fail("Kommune not found");
        }
    }

    @Test
    void testRegionCount() {
        Optional<Region> region = regionRepository.findById("1081");
        if(region.isPresent()){
            Set<Kommune> setKom = region.get().getKommuner();
            assertEquals(11, setKom.size());

        } else {
            fail("Region not found");
        }
    }

    //teste man ikke kan indsætte samme kommune ind to gange
    //Laver nyt hashkode/equals i Kommune med alt insert og indsætter kode som primary key
    @Test
    void testSetKommune() {
        //Set er et interface, en liste der ikke kan være duplikationer i.
        Set<Kommune> setKom = new HashSet<>();
        Kommune k1 = new Kommune();
        k1.setKode("1");
        setKom.add(k1);
        Kommune k2 = new Kommune();
        k2.setKode("1");
        setKom.add(k2);
        assertEquals(1,setKom.size());

    }
}
