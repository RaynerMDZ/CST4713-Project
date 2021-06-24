package edu.citytech.cst.s23253396.cst4713project.counter123.controllers;

import edu.citytech.cst.s23253396.cst4713project.counter123.models.Counter123;
import edu.citytech.cst.s23253396.cst4713project.counter123.models.Counter123Form;
import edu.citytech.cst.s23253396.cst4713project.counter123.services.implementations.Counter123ServiceImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Counter123Controller {

    private final Counter123ServiceImplementation service;

    public Counter123Controller(Counter123ServiceImplementation service) {
        this.service = service;
    }

    @GetMapping("/numberD123")
    public String getCounter123(@ModelAttribute(value = "number") String number,
                                @ModelAttribute(value = "highlight") String highlight,
                                @ModelAttribute(value = "counter123Form") Counter123Form counter123Form,
                                Model model) {

        List<Counter123> counter123List = new ArrayList<>();

        if (number != null) {
            if (!number.equalsIgnoreCase("")) {
                counter123List = this.service.countBy(Long.valueOf(number));

                if (highlight != null) {
                    if (!highlight.equalsIgnoreCase("")) {
                        counter123List = this.service.selectTypeOfHighlight(highlight, counter123List);
                    }
                }
            }
        }

        model.addAttribute("numbers", counter123List);
        model.addAttribute("counter123Form", counter123Form);
        return "counter123/index";
    }

    @GetMapping("/number123")
    public String getStaticPage() {
        return "counter123/indexStatic";
    }
}
