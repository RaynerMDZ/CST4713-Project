package edu.citytech.cst.s23253396.cst4713project.abcocunter;

import edu.citytech.cst.s23253396.cst4713project.abccounter.services.AbcCounterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ABC Test")
public class T1_Abc {

    private final AbcCounterService abcCounterService = new AbcCounterService();

    @DisplayName("1st ABC Test")
    @Test
    void T1() {

        int actual = this.abcCounterService.getAbcUppercase().size();
        int expected = 26;
        assertEquals(expected, actual);
    }

    @DisplayName("Testing for last character of Z")
    @Test
    void T2() {

        var list = this.abcCounterService.getAbcUppercase();
        char actual = list.get(25).getLetter();
        char expected = 'Z';
        assertEquals(expected, actual);
    }

    @DisplayName("isVowel test for 'a")
    @Test
    void T3() {
        var even = new ArrayList<>();
        var odd = new ArrayList<>();
        var numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers
                .forEach(number -> {
                    if (number % 2 == 0) {
                        even.add(number);
                    } else {
                        odd.add(number);
                    }
                });


    }
}
