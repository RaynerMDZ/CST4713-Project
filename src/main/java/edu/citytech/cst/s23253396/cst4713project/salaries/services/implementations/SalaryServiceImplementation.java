package edu.citytech.cst.s23253396.cst4713project.salaries.services.implementations;

import edu.citytech.cst.s23253396.cst4713project.grading.util._FileReader;
import edu.citytech.cst.s23253396.cst4713project.salaries.models.Salary;
import edu.citytech.cst.s23253396.cst4713project.salaries.repositories.SalaryRepository;
import edu.citytech.cst.s23253396.cst4713project.salaries.services.SalaryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryServiceImplementation implements SalaryService {

    private final SalaryRepository salaryRepository;
    private final _FileReader fileReader;
    private final String CSV_PATH = "src/main/resources/data/Salaries.csv";

    public SalaryServiceImplementation(SalaryRepository salaryRepository, _FileReader fileReader) {
        this.salaryRepository = salaryRepository;
        this.fileReader = fileReader;
    }

    @Override
    public List<Salary> getAllSalaries() {
//        List<String> list = this.fileReader.createListWithFileLines(this.CSV_PATH, 1);
//        return list.stream().map(this::mapToSalary).collect(Collectors.toList());
        return this.salaryRepository.findAll();
    }

    @Override
    public Optional<Salary> getSalaryById(String id) {
        return this.salaryRepository.findById(id);
    }

    @Override
    public List<Salary> getSalariesByCode(String code) {
        return this.salaryRepository.getSalariesByCode(code);
    }

    private Salary mapToSalary(String row) {
        String[] splitLine = row.split(",");
        return new Salary(splitLine[0], Double.valueOf(splitLine[1]), splitLine[2]);
    }
}
