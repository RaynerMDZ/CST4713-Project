package edu.citytech.cst.s23253396.cst4713project.salaries.controller;

import edu.citytech.cst.s23253396.cst4713project.salaries.services.SalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalaryController {

    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/salaries")
    public String getIndex(Model model) {

        model.addAttribute("salaries", this.salaryService.getAllSalaries());
        return "salaries/index";
    }
}
