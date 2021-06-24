package edu.citytech.cst.s23253396.cst4713project.salaries.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "salary")
public class Salary {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "code", nullable = false)
    private String code;
}
