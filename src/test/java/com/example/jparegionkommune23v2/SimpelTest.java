package com.example.jparegionkommune23v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

//unit test til at teste sorterings algoritme

@DisplayName("dagens første test")
public class SimpelTest {

    @Test
    void test() {
    if (3>4)
        fail("det går slet ikke");
    }

    @Test
    void test2() {
        assertEquals("ABC", "ABC");
    }

    @Test
    void testArr2() {
        int[] numbers = {12, 4, 1, 3};
        int[] expectedNumbers = {1,3,4,12};
        Arrays.sort(numbers);
        assertArrayEquals(expectedNumbers, numbers, "sortering af Array med tal");

    }
@DisplayName("Bruger fansy parameter test")
     @ParameterizedTest
    @MethodSource("sortNumbersArguments")

    void testArr(int[] numbers, int[] expectedNumbers) {
         Arrays.sort(numbers);
        assertArrayEquals(expectedNumbers, numbers, "sortering af Array med tal");
     }

     private static Stream<Arguments> sortNumbersArguments() {
         return Stream.of(

                Arguments.of(new int[]{1,2,3},IntStream.of(1,2,3).toArray()));


     }
     }


