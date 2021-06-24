package edu.citytech.cst.s23253396.cst4713project.counter123.services.implementations;

import edu.citytech.cst.s23253396.cst4713project.counter123.models.Counter123;
import edu.citytech.cst.s23253396.cst4713project.counter123.repositories.Counter123Repository;
import edu.citytech.cst.s23253396.cst4713project.counter123.services.Counter123Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Counter 123 Service Implementation Test")
class Counter123ServiceImplementationTest {

    private final Counter123Service service = new Counter123ServiceImplementation(new Counter123Repository());

    @BeforeEach
    void setUp() {
    }

    @DisplayName("Test for countBy()")
    @Test
    void countBy() {
        List<Long> numbers = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 20L, 25L, 50L, 100L);
        for (Long number : numbers) {
            List<Counter123> expected = new ArrayList<>();
            if (number < 20L) {
                for (long i = 0; i <= 1000; i+=number) {
                    Counter123 counter123 = new Counter123();
                    counter123.setNumber(i);
                    counter123.setCssClass("n123-001");
                    expected.add(counter123);
                }
            } else {
                for (long i = 0; i <= 1000; i+=number) {
                    Counter123 counter123 = new Counter123();
                    counter123.setNumber(i);
                    counter123.setCssClass("n123-100");
                    expected.add(counter123);
                }
            }

            var actual = this.service.countBy(number);
            assertEquals(expected, actual);
        }
    }

    @DisplayName("Test for highlightEvenNumber()")
    @Test
    void highlightEvenNumbers() {
        List<Counter123> expected = new ArrayList<>();
        for (long i = 0; i <= 1000; i+=25) {
            if (i % 2 == 0) {
                Counter123 counter123 = new Counter123();
                counter123.setNumber(i);
                counter123.setCssClass("n123-100 highlight");
                expected.add(counter123);
            } else {
                Counter123 counter123 = new Counter123();
                counter123.setNumber(i);
                counter123.setCssClass("n123-100");
                expected.add(counter123);
            }
        }

        var actual = this.service.highlightEvenNumbers(this.service.countBy(25L));
        assertEquals(expected, actual);
    }

    @DisplayName("Test for highlightOddNumber()")
    @Test
    void highlightOddNumbers() {
        List<Counter123> expected = new ArrayList<>();
        for (long i = 0; i <= 1000; i+=25) {
            if (i % 2 == 1) {
                Counter123 counter123 = new Counter123();
                counter123.setNumber(i);
                counter123.setCssClass("n123-100 highlight");
                expected.add(counter123);
            } else {
                Counter123 counter123 = new Counter123();
                counter123.setNumber(i);
                counter123.setCssClass("n123-100");
                expected.add(counter123);
            }
        }

        var actual = this.service.highlightOddNumbers(this.service.countBy(25L));
        assertEquals(expected, actual);
    }

    @DisplayName("Test for highlightEveryFiveNumbers()")
    @Test
    void highlightEveryFiveNumbers() {
        List<Counter123> expected = new ArrayList<>();
        int count = 0;
        for (long i = 0; i <= 1000; i+=25) {
            if (count % 5 == 0) {
                Counter123 counter123 = new Counter123();
                counter123.setNumber(i);
                counter123.setCssClass("n123-100 highlight");
                expected.add(counter123);
            } else {
                Counter123 counter123 = new Counter123();
                counter123.setNumber(i);
                counter123.setCssClass("n123-100");
                expected.add(counter123);
            }
            count++;
        }

        var actual = this.service.highlightEveryFiveNumbers(this.service.countBy(25L));
        assertEquals(expected, actual);
    }

    @DisplayName("Test for highlightEveryTenNumbers()")
    @Test
    void highlightEveryTenNumbers() {
        List<Counter123> expected = new ArrayList<>();
        int count = 0;
        for (long i = 0; i <= 1000; i+=25) {
            if (count % 10 == 0) {
                Counter123 counter123 = new Counter123();
                counter123.setNumber(i);
                counter123.setCssClass("n123-100 highlight");
                expected.add(counter123);
            } else {
                Counter123 counter123 = new Counter123();
                counter123.setNumber(i);
                counter123.setCssClass("n123-100");
                expected.add(counter123);
            }
            count++;
        }

        var actual = this.service.highlightEveryTenNumbers(this.service.countBy(25L));
        assertEquals(expected, actual);
    }

    @DisplayName("Test for highlightNumbersThatContains8()")
    @Test
    void highlightNumbersThatContains8() {
        List<Counter123> expected = new ArrayList<>();
        for (long i = 0; i <= 1000; i+=25) {

            String number = String.valueOf(i);
            if (number.contains("8")) {
                Counter123 counter123 = new Counter123();
                counter123.setNumber(i);
                counter123.setCssClass("n123-100 highlight");
                expected.add(counter123);
            } else {
                Counter123 counter123 = new Counter123();
                counter123.setNumber(i);
                counter123.setCssClass("n123-100");
                expected.add(counter123);
            }
        }

        var actual = this.service.highlightNumbersThatContains8(this.service.countBy(25L));
        assertEquals(expected, actual);
    }
}