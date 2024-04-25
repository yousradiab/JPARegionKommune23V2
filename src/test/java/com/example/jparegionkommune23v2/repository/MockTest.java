package com.example.jparegionkommune23v2.repository;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockTest {

    //denne fejlede
    @Test
    void testInLineMapFailed() {
        Map<Integer, String> mapMock = mock(Map.class);
        //mocker key value pair
        mapMock.put(1085, "Roskilde");
        String str = mapMock.get(1085);
        assertEquals("Roskilde", str);
    }


    //Forlarer noget om hvad der forventer ske når en condition er opfyldt.
    @Test
    void testInLineMapWhen() {
        Map<Integer, String> mapMock = mock(Map.class);
        //når der bliver sprugt om 1085, skal den returner roskilde.
        when(mapMock.get(1085)).thenReturn("Roskilde");
        String str = mapMock.get(1085);
        assertEquals("Roskilde", str);

    }

    @Test
    void testListThenThen() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());


    }
}
