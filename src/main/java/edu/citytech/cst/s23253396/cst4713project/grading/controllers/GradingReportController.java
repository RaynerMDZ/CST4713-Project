package edu.citytech.cst.s23253396.cst4713project.grading.controllers;

import edu.citytech.cst.s23253396.cst4713project.grading.models.Grade;
import edu.citytech.cst.s23253396.cst4713project.grading.services.GradingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/grades")
public class GradingReportController {

    private final GradingService gradingService;

    public GradingReportController(GradingService gradingService) {
        this.gradingService = gradingService;
    }

    @GetMapping
    public String grade(@RequestParam(defaultValue = "All", value = "letterGrade") String letter, Model model) {

        letter = letter.replace(" ", "");

        List<Grade> grades;

        if (letter.equalsIgnoreCase("All")) {
            grades = this.gradingService.findAllGrades();
        } else {
            grades = this.gradingService.findGradesByLetterGrade(letter, this.gradingService.findAllGrades());
        }

        model.addAttribute("grades", grades);
        model.addAttribute("count", this.gradingService.count(grades));
        model.addAttribute("average", this.gradingService.convertZeroToNa(this.gradingService.average(grades)));
        model.addAttribute("max", this.gradingService.convertZeroToNa(this.gradingService.max(grades)));
        model.addAttribute("min", this.gradingService.convertZeroToNa(this.gradingService.min(grades)));
        model.addAttribute("sum", this.gradingService.convertZeroToNa(this.gradingService.sum(grades)));
        model.addAttribute("avgGreaterThan90", this.gradingService.convertZeroToNa(this.gradingService.averageGreaterThan90(grades)));
        model.addAttribute("avgLessThan70", this.gradingService.convertZeroToNa(this.gradingService.averageLessThanCGrade(grades)));
        model.addAttribute("title", letter);
        return "gradingReport/gradingReport";
    }
}
