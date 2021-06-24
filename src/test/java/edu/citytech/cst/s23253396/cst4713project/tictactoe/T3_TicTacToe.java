package edu.citytech.cst.s23253396.cst4713project.tictactoe;

import edu.citytech.cst.s23253396.cst4713project.tictactoe.businessobject.TicTacToeBO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Row 3 Test")
public class T3_TicTacToe {

    @DisplayName("X: Find winner on line 1 in position (0, 1, 2)")
    @Test
    void T1() {

        final char[] moves = {
                'N', 'X', 'O',
                'X', 'O', 'N',
                'X', 'X', 'X'};

        var gameStatus = TicTacToeBO.isWinner(moves);

        char expected = 'X';
        char actual = gameStatus.getWhoWon();
        assertEquals(expected, actual);

    }

    @DisplayName("O: Find winner on line 1 in position (0, 1, 2)")
    @Test
    void T2() {

        final char[] moves = {
                'O', 'X', 'O',
                'N', 'X', 'N',
                'O', 'O', 'O'
        };

        var gameStatus = TicTacToeBO.isWinner(moves);

        char expected = 'O';
        char actual = gameStatus.getWhoWon();
        assertEquals(expected, actual);

    }
}
