package com.example.jparegionkommune23v2.service;


import com.example.jparegionkommune23v2.model.Kommune;

import java.util.List;

public interface ServiceKommuner {
    List<Kommune> getKommunerStartsWith(Character c);
}
