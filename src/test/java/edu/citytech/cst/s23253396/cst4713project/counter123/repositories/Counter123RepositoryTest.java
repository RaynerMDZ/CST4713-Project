package edu.citytech.cst.s23253396.cst4713project.counter123.repositories;

import edu.citytech.cst.s23253396.cst4713project.counter123.models.Counter123;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Counter 123 Repository Test")
class Counter123RepositoryTest {

    private final Counter123Repository repository = new Counter123Repository();

    @BeforeEach
    void setUp() {
    }

    @DisplayName("Test for countByUserNumber()")
    @Test
    void countByDynamic() {
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

            var actual = this.repository.countByUserNumber(number);
            assertEquals(expected, actual);
        }
    }
}