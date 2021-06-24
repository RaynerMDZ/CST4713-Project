package edu.citytech.cst.s23253396.cst4713project.grading.services;

import edu.citytech.cst.s23253396.cst4713project.grading.models.Grade;
import edu.citytech.cst.s23253396.cst4713project.grading.models.GradingPolicy;
import edu.citytech.cst.s23253396.cst4713project.grading.repositories.GradeRepository;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradingService {

    private final GradeRepository gradeRepository;

    public GradingService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public GradingPolicy getGPA(float score) {

        if (score < 60 && score > 100) return new GradingPolicy("0-60%", "F", 0f);

        if (score >= 93 && score <= 100) {
           return new GradingPolicy("93-100%", "A", 4.0f);
        }

        if (score >= 90 && score <= 92.9) {
            return new GradingPolicy("90-92.9%", "A-", 3.7f);
        }

        if (score >= 87 && score <= 89.9) {
            return new GradingPolicy("87-89.9%", "B+", 3.3f);
        }

        if (score >= 83 && score <= 86.9) {
            return new GradingPolicy("83-86.9%", "B", 3f);
        }

        if (score >= 80 && score <= 82.9) {
            return new GradingPolicy("80-82.9%", "B-", 2.7f);
        }

        if (score >= 77 && score <= 79.9) {
            return new GradingPolicy("77-79.9%", "C+", 2.3f);
        }

        if (score >= 73 && score <= 76.9) {
            return new GradingPolicy("73-76.9%", "C", 2f);
        }

        if (score >= 70 && score <= 72.9) {
            return new GradingPolicy("70-72.9%", "C-", 1.7f);
        }

        if (score >= 60 && score <= 69.9) {
            return new GradingPolicy("60-69.9%", "D", 1f);
        }

        return new GradingPolicy("0-60%", "F", 0f);
    }

    private Grade mapToGrade(Grade grade) {

        Float[] scores = grade.getScores();

        var total = 0f;
        for (var score : scores) {
            total = total + score;
        }

        var average = total / scores.length;
        var status = this.getGPA(average);

        grade.setLetterGrade(status.getGrade());
        grade.setAverageScore(average);
        grade.setGpa(status.getPoints());
        return grade;
    }

    public List<Grade> findAllGrades() {
        return this.gradeRepository.findAll()
                .stream()
                .map(this::mapToGrade)
                .collect(Collectors.toList());
    }

    public List<Grade> findGradesByLetterGrade(String letter, List<Grade> grades) {
        return grades
                .stream()
                .map(this::mapToGrade)
                .parallel()
                .filter(element -> element.getLetterGrade().equalsIgnoreCase(letter))
                .collect(Collectors.toList());
    }

    public Integer count(List<Grade> grades) {
        return grades.size();
    }

    public Double average(List<Grade> grades) {
        return grades
                .stream()
                .mapToDouble(Grade::getAverageScore)
                .parallel()
                .average()
                .stream()
                .map(number -> Math.round(number * 100.0) / 100.0)
                .findFirst()
                .orElse(0D);
    }

    public Float max(List<Grade> grades) {
        return grades
                .stream()
                .map(Grade::getAverageScore)
                .parallel()
                .max(Float::compare)
                .orElse(0f);
    }

    public Float min(List<Grade> grades) {
        return grades
                .stream()
                .map(Grade::getAverageScore)
                .parallel()
                .min(Float::compare)
                .orElse(0f);
    }

    public Double sum(List<Grade> grades) {
        double total = grades
                .stream()
                .mapToDouble(Grade::getAverageScore)
                .parallel()
                .sum();

        DecimalFormat df = new DecimalFormat("0.00");
        return Double.valueOf(df.format(total));
    }

    public Double averageGreaterThan90(List<Grade> grades) {
        return grades
                .stream()
                .filter(grade -> grade.getAverageScore() > 90)
                .parallel()
                .mapToDouble(Grade::getAverageScore)
                .average()
                .stream()
                .map(number -> Math.round(number * 100.0) / 100.0)
                .findFirst()
                .orElse(0D);
    }

    public Double averageLessThanCGrade(List<Grade> grades) {
        return grades
                .stream()
                .filter(grade -> grade.getAverageScore() < 76.9)
                .parallel()
                .mapToDouble(Grade::getAverageScore)
                .average()
                .stream()
                .map(number -> Math.round(number * 100.0) / 100.0)
                .findFirst()
                .orElse(0D);
    }

    public Object convertZeroToNa(Object number) {
        if (number.equals(0.00D) || number.equals(00.0F)) {
            return "N/A";
        }
        return number;
    }
}
