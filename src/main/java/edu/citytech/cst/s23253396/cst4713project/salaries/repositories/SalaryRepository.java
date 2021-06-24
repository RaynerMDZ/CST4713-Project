package edu.citytech.cst.s23253396.cst4713project.salaries.repositories;

import edu.citytech.cst.s23253396.cst4713project.salaries.models.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, String> {
    List<Salary> getSalariesByCode(String code);
}
