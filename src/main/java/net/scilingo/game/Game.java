package net.scilingo.game;

import java.util.Scanner;

import net.scilingo.board.Cell;
import net.scilingo.board.Player;
import net.scilingo.board.Board;

interface Game {

	Player getCurrentPlayer();

	Board getGameBoard();
	
	void play();

	void checkForWinOrTie();

	boolean isGameOver();

	boolean playAgain(Scanner sc);

	boolean makeMove(Cell m);

}