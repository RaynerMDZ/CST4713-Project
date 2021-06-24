package edu.citytech.cst.s23253396.cst4713project.tictactoe.controller;

import edu.citytech.cst.s23253396.cst4713project.tictactoe.businessobject.TicTacToeBO;
import edu.citytech.cst.s23253396.cst4713project.tictactoe.model.GameStatus;
import org.springframework.web.bind.annotation.*;

@RestController(value = "TicTacToeController")
@RequestMapping(value = "/api/v1/tic-tac-toe/")
@CrossOrigin(value = "*")
public class TicTacToeController {

    // localhost:8080/api/v1/tic-tac-toe/XXX???OOO
    @GetMapping(value = "{moves}")
    public GameStatus getStatus(@PathVariable(value = "moves") String moves) {
        return TicTacToeBO.isWinner(moves.toCharArray());
    }
}
