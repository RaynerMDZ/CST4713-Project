package edu.citytech.cst.s23253396.cst4713project.abccounter.controllers;

import edu.citytech.cst.s23253396.cst4713project.abccounter.models.Abc;
import edu.citytech.cst.s23253396.cst4713project.abccounter.models.form.AbcForm;
import edu.citytech.cst.s23253396.cst4713project.abccounter.services.AbcCounterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AbcController {

    private final AbcCounterService abcCounterService;

    public AbcController(AbcCounterService abcCounterService) {
        this.abcCounterService = abcCounterService;
    }

    @GetMapping("/abcd")
    public String getAbcDynamic(@ModelAttribute(value = "AbcForm") AbcForm abcForm, Model model) {
        List<Abc> alphabet = new ArrayList<>();

        if (abcForm.getDisplayMode() != null) {
            alphabet = this.abcCounterService.selectAlphabetMode(abcForm.getDisplayMode());
        }

        abcForm.setMessage(new Date().toString());
        model.addAttribute("abcForm", abcForm);
        model.addAttribute("alphabet", alphabet);

        return "abcCounter/boulet/abcCounter";
    }

    @GetMapping("/abc")
    public String getAlphabet() {
        return "abcCounter/boulet/alphabets";
    }
}
