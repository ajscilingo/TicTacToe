package net.scilingo.game;

import java.io.Serializable;
import java.util.Scanner;

import net.scilingo.board.Board;
import net.scilingo.board.Player;
import net.scilingo.board.CellSelection;

interface Game extends Serializable {

	Player getCurrentPlayer();

	Board getGameBoard();
	
	void play();

	void checkForWin();

	boolean isGameOver();

	boolean playAgain(Scanner sc);

	boolean makeMove(CellSelection cellSelection);

}