package edu.citytech.cst.s23253396.cst4713project.tictactoe;

import edu.citytech.cst.s23253396.cst4713project.tictactoe.businessobject.TicTacToeBO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Row 1 Test")
public class T1_TicTacToe {

    @DisplayName("X: Find winner on line 1 in position (0, 1, 2)")
    @Test
    void T1() {

        final char[] moves = {
                'X', 'X', 'X',
                'N', 'O', 'O',
                'N', 'N', 'N'};

        var gameStatus = TicTacToeBO.isWinner(moves);

        char expected = 'X';
        char actual = gameStatus.getWhoWon();
        assertEquals(expected, actual);

    }

    @DisplayName("O: Find winner on line 1 in position (0, 1, 2)")
    @Test
    void T2() {

        final char[] moves = {
                'O', 'O', 'O',
                'N', 'O', 'O',
                'N', 'N', 'N'};

        var gameStatus = TicTacToeBO.isWinner(moves);

        char expected = 'O';
        char actual = gameStatus.getWhoWon();
        assertEquals(expected, actual);

    }

    @DisplayName("No winner was found")
    @Test
    void T3() {
        final char[] moves = {
                'X', 'O', 'O',
                'N', 'O', 'O',
                'N', 'N', 'N'};

        var gameStatus = TicTacToeBO.isWinner(moves);
        char expected = 'N';
        char actual = gameStatus.getWhoWon();
        assertEquals(expected, actual);
    }
}
