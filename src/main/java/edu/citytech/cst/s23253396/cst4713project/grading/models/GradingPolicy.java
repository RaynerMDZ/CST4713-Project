package edu.citytech.cst.s23253396.cst4713project.grading.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GradingPolicy {
    private String definition;
    private String grade;
    private Float points;
}
