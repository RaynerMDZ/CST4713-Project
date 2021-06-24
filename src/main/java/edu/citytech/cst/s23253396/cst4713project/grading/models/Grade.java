package edu.citytech.cst.s23253396.cst4713project.grading.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Grade {
    private Integer id;
    private Float[] scores;
    private String letterGrade;
    private Float gpa;
    private Float averageScore;

    public Grade(int id, Float[] scores) {
        this.id = id;
        this.scores = scores;
    }
}
