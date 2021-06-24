package edu.citytech.cst.s23253396.cst4713project.tictactoe.businessobject;

import edu.citytech.cst.s23253396.cst4713project.tictactoe.model.GameStatus;

import java.util.Arrays;
import java.util.function.Predicate;

public class TicTacToeBO {

    static final int[][] winningMoves = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };
    public static final char PLACE_HOLDER = 'N';

    public static GameStatus isWinner(char[] moves) {

        Predicate<GameStatus> predicate = move ->
                moves[move.getP1()] == moves[move.getP2()]
                && moves[move.getP2()] == moves[move.getP3()]
                && moves[move.getP2()] != PLACE_HOLDER;


        var gameStatus = Arrays.stream(winningMoves)
                .map(GameStatus::new)
                .filter(predicate)
                .findFirst();

        if (gameStatus.isPresent()) {
            var status = gameStatus.get();
            status.setWhoWon(moves[status.getP1()]);
            return gameStatus.get();
        }

        return new GameStatus();

    }
}
