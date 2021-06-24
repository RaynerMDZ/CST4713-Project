package edu.citytech.cst.s23253396.cst4713project.grading.repositories;

import edu.citytech.cst.s23253396.cst4713project.grading.models.Grade;
import edu.citytech.cst.s23253396.cst4713project.grading.util._FileReader;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for Grade Repository")
class GradeRepositoryTest {

    private final GradeRepository gradeRepository = new GradeRepository(new _FileReader());

    @BeforeEach
    void setUp() {
    }

    @DisplayName("Test for gradeMap()")
    @Test
    void gradeMap() {
        List<Grade> expected = new ArrayList<>();
        expected.add(new Grade(1000, Arrays.array(79.0F, 78.0F, 75.0F, 75.0F, 70.0F), null, null, null));
        expected.add(new Grade(1001, Arrays.array(86.0F, 87.0F, 90.0F, 83.0F, 87.0F), null, null, null));
        expected.add(new Grade(1002, Arrays.array(89.0F, 88.0F, 86.0F, 81.0F, 80.0F), null, null, null));
        expected.add(new Grade(1003, Arrays.array(54.0F, 59.0F, 53.0F, 57.0F, 54.0F), null, null, null));
        expected.add(new Grade(1004, Arrays.array(56.0F, 50.0F, 52.0F, 53.0F, 59.0F), null, null, null));

        List<Grade> actual = new ArrayList<>();
        actual.add(this.gradeRepository.gradeMap("1000, 79.0F, 78.0F, 75.0F, 75.0F, 70.0F"));
        actual.add(this.gradeRepository.gradeMap("1001, 86.0F, 87.0F, 90.0F, 83.0F, 87.0F"));
        actual.add(this.gradeRepository.gradeMap("1002, 89.0F, 88.0F, 86.0F, 81.0F, 80.0F"));
        actual.add(this.gradeRepository.gradeMap("1003, 54.0F, 59.0F, 53.0F, 57.0F, 54.0F"));
        actual.add(this.gradeRepository.gradeMap("1004, 56.0F, 50.0F, 52.0F, 53.0F, 59.0F"));

        assertEquals(expected, actual);
    }

    @DisplayName("Test for findAll()")
    @Test
    void findAll() {
        var expected = 140;
        var actual = this.gradeRepository.findAll().size();
        assertEquals(expected, actual);
    }
}