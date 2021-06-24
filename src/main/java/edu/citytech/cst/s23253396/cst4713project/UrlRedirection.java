package edu.citytech.cst.s23253396.cst4713project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UrlRedirection {

    @GetMapping({"/", "/index", "/home", "/index.html", "/home.html"})
    public String getMainPage(Model model) {
        return "index";
    }

    @GetMapping({"/tic-tac-toe", "/tictactoe"})
    public RedirectView getTicTacToe() {
        return new RedirectView("tictactoe.html");
    }
}
