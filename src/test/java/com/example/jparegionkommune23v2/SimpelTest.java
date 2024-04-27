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

<<<<<<< HEAD
//unit test til at teste sorterings algoritme

@DisplayName("dagens første test")
=======
@DisplayName("Dagens første test")
>>>>>>> 664d19f8dfc315d1e4c83925de2426a25991053e
public class SimpelTest {

    @Test
    void test() {
<<<<<<< HEAD
    if (3>4)
        fail("det går slet ikke");
    }

=======
        if (3>4)
        fail("det går slet ikke");
    }


>>>>>>> 664d19f8dfc315d1e4c83925de2426a25991053e
    @Test
    void test2() {
        assertEquals("ABC", "ABC");
    }

<<<<<<< HEAD
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


=======

    @Test
    void testArr2() {
        int[] numbers = {12, 3, 4, 1};
        int[] excpected = {1,3,4,12};
        Arrays.sort(numbers);
        assertArrayEquals(excpected, numbers, "Sortering af 4 tal");
    }

    @DisplayName("Bruger fanzy param test")
    @ParameterizedTest
    @MethodSource("sortnumbersArguments")
    void testArr(int[] numbers, int[] expected) {
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers, "Sortering af 4 tal");
    }

    private static Stream<Arguments> sortnumbersArguments2() {
        return Stream.of(
                Arguments.of(IntStream.of(1,2,3).toArray(), IntStream.of(1,2,3).toArray()),
                        Arguments.of(IntStream.of(7,1,2,3).toArray(), IntStream.of(1,2,13,7).toArray()),
                        Arguments.of(IntStream.of(1,2,45,3).toArray(), IntStream.of(1,2,3,45).toArray()));
    }

    private static Stream<Arguments> sortnumbersArguments() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, IntStream.of(1,2,3).toArray()),
                Arguments.of(new int[]{1,2,3}, IntStream.of(1,2,3).toArray()));

    }

}
>>>>>>> 664d19f8dfc315d1e4c83925de2426a25991053e
