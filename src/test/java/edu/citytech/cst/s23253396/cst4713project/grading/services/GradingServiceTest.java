package edu.citytech.cst.s23253396.cst4713project.grading.services;

import edu.citytech.cst.s23253396.cst4713project.grading.models.Grade;
import edu.citytech.cst.s23253396.cst4713project.grading.repositories.GradeRepository;
import edu.citytech.cst.s23253396.cst4713project.grading.util._FileReader;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Grading Service Test")
class GradingServiceTest {

    private final GradingService gradingService = new GradingService(new GradeRepository(new _FileReader()));
    private List<Grade> gradeList;
    private final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @BeforeEach
    void setUp() {
        this.gradeList = new ArrayList<>();
        this.gradeList.add(new Grade(1000, Arrays.array(79.0F, 78.0F, 75.0F, 75.0F, 70.0F), "C", 2.0F, 75.4F));
        this.gradeList.add(new Grade(1001, Arrays.array(86.0F, 87.0F, 90.0F, 83.0F, 87.0F), "B", 3.0F, 86.6F));
        this.gradeList.add(new Grade(1002, Arrays.array(89.0F, 88.0F, 86.0F, 81.0F, 80.0F), "B", 3.0F, 84.8F));
        this.gradeList.add(new Grade(1003, Arrays.array(54.0F, 59.0F, 53.0F, 57.0F, 54.0F), "F", 0.0F, 55.4F));
        this.gradeList.add(new Grade(1004, Arrays.array(56.0F, 50.0F, 52.0F, 53.0F, 59.0F), "F", 0.0F, 54.0F));
    }

    @DisplayName("Test for getGPA()")
    @Test
    void getGPA() {
        HashMap<Float, Float> GPAs = new HashMap<>();
        //  A
        GPAs.put(100f, 4f);
        GPAs.put(99f, 4f);
        GPAs.put(98f, 4f);
        GPAs.put(97f, 4f);
        GPAs.put(96f, 4f);
        GPAs.put(95f, 4f);
        GPAs.put(94f, 4f);
        GPAs.put(93f, 4f);

        //  A-
        GPAs.put(92f, 3.7f);
        GPAs.put(91f, 3.7f);
        GPAs.put(90f, 3.7f);

        //  B+
        GPAs.put(89f, 3.3f);
        GPAs.put(88f, 3.3f);
        GPAs.put(87f, 3.3f);

        //  B
        GPAs.put(86f, 3.0f);
        GPAs.put(85f, 3.0f);
        GPAs.put(84f, 3.0f);
        GPAs.put(83f, 3.0f);

        //  B-
        GPAs.put(82f, 2.7f);
        GPAs.put(81f, 2.7f);
        GPAs.put(80f, 2.7f);

        //  C+
        GPAs.put(79f, 2.3f);
        GPAs.put(78f, 2.3f);
        GPAs.put(77f, 2.3f);

        //  C
        GPAs.put(76f, 2f);
        GPAs.put(75f, 2f);
        GPAs.put(74f, 2f);
        GPAs.put(73f, 2f);

        //  C-
        GPAs.put(72f, 1.7f);
        GPAs.put(71f, 1.7f);
        GPAs.put(70f, 1.7f);

        //  D
        GPAs.put(69f, 1f);
        GPAs.put(68f, 1f);
        GPAs.put(67f, 1f);
        GPAs.put(66f, 1f);
        GPAs.put(65f, 1f);
        GPAs.put(64f, 1f);
        GPAs.put(63f, 1f);
        GPAs.put(62f, 1f);
        GPAs.put(61f, 1f);
        GPAs.put(60f, 1f);

        //  F
        GPAs.put(59f, 0f);
        GPAs.put(50f, 0f);
        GPAs.put(40f, 0f);
        GPAs.put(30f, 0f);
        GPAs.put(20f, 0f);
        GPAs.put(10f, 0f);

        GPAs.forEach((actual, expected) -> {
            assertEquals(expected, this.gradingService.getGPA(actual).getPoints());
        });
    }

    @DisplayName("Test for findAllGrades()")
    @Test
    void findAllGrades() {
        var expected = 140;
        var actual = this.gradingService.findAllGrades().size();
        assertEquals(expected, actual);
    }

    @DisplayName("Test for findGradesByLetterGrade()")
    @Test
    void findGradesByLetterGrade() {
        var expected = 2;
        var actual = this.gradingService.findGradesByLetterGrade("B", this.gradeList).size();
        assertEquals(expected, actual);
    }

    @DisplayName("Test for count()")
    @Test
    void count() {
        var expected = 5;
        var actual = this.gradingService.count(this.gradeList);
        assertEquals(expected, actual);
    }

    @DisplayName("Test for average()")
    @Test
    void average() {
        Float total = 0F;
        for (Grade grade : this.gradeList) {
            total += grade.getAverageScore();
        }

        var expected = this.formatTo2Digits((double) (total / this.gradeList.size()));
        var actual = this.gradingService.average(this.gradeList);
        assertEquals(expected, actual);
    }

    @DisplayName("Test for max()")
    @Test
    void max() {
        var expected = 86.6F;
        var actual = this.gradingService.max(this.gradeList);
        assertEquals(expected, actual);
    }

    @DisplayName("Test for min()")
    @Test
    void min() {
        var expected = 54.0F;
        var actual = this.gradingService.min(this.gradeList);
        assertEquals(expected, actual);
    }

    @DisplayName("Test for sum()")
    @Test
    void sum() {
        var expected = 356.2;
        var actual = this.gradingService.sum(this.gradeList);
        assertEquals(expected, actual);
    }

    @DisplayName("Test for averageGreaterThan90()")
    @Test
    void averageGreaterThan90() {
        var expected = 0.0D;
        var actual = this.gradingService.averageGreaterThan90(this.gradeList);
        assertEquals(expected, actual);
    }

    @DisplayName("Test for averageLessThanCGrade()")
    @Test
    void averageLessThanCGrade() {
        var expected = 61.6D;
        var actual = this.gradingService.averageLessThanCGrade(this.gradeList);
        assertEquals(expected, actual);
    }

    @DisplayName("Test for convertZeroToNa()")
    @Test
    void convertZeroToNa() {
        var expected = "N/A";
        var actual = this.gradingService.convertZeroToNa(0.00D);
        assertEquals(expected, actual);
    }

    private Double formatTo2Digits(Double number) {
        return Double.valueOf(decimalFormat.format(number));
    }
}