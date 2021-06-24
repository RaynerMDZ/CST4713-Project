package edu.citytech.cst.s23253396.cst4713project.salaries.services;

import edu.citytech.cst.s23253396.cst4713project.salaries.models.Salary;

import java.util.List;
import java.util.Optional;

public interface SalaryService {
    List<Salary> getAllSalaries();
    Optional<Salary> getSalaryById(String id);
    List<Salary> getSalariesByCode(String code);
}
