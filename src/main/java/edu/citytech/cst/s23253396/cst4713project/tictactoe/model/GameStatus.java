package edu.citytech.cst.s23253396.cst4713project.tictactoe.model;

import edu.citytech.cst.s23253396.cst4713project.tictactoe.businessobject.TicTacToeBO;
import lombok.Data;

@Data
public class GameStatus {

    private int p1;
    private int p2;
    private int p3;
    private Character whoWon;

    public GameStatus(int[] moves) {
        this.p1 = moves[0];
        this.p2 = moves[1];
        this.p3 = moves[2];
    }

    public GameStatus() {
        this.p1 = 0;
        this.p2 = 0;
        this.p3 = 0;
        this.whoWon = TicTacToeBO.PLACE_HOLDER;
    }
}
