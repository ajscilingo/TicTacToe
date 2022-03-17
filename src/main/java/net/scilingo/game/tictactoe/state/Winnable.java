package net.scilingo.game.tictactoe.state;

import net.scilingo.board.tictactoe.TicTacToePlayer;

public interface Winnable {
    AbstractGameState isGameOver(TicTacToePlayer player);

    String winnerMessage();
}
