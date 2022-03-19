package net.scilingo.game;

import java.io.Serializable;
import java.util.Scanner;

import net.scilingo.board.Board;
import net.scilingo.board.tictactoe.TicTacToeCellSelection;
import net.scilingo.board.tictactoe.TicTacToePlayer;

interface Game extends Serializable {

	TicTacToePlayer getCurrentPlayer();

	Board getGameBoard();
	
	Game play(Scanner sc);

	void checkForWin();

	boolean isGameOver();

	boolean playAgain(Scanner sc);

	boolean makeMove(TicTacToeCellSelection cellSelection);

}