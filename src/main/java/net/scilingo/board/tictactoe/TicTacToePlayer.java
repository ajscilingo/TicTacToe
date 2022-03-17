package net.scilingo.board.tictactoe;

import net.scilingo.board.Move;

public interface TicTacToePlayer {

	char move(Move move);

	boolean isGameOver();

	String getMoveHistory();
	
	String getMoveHistory(String format);

	boolean hasLowerLeft();

	boolean hasLowerMiddle();

	boolean hasLowerRight();

	boolean hasMiddleLeft();

	boolean hasMiddleMiddle();

	boolean hasMiddleRight();

	boolean hasUpperLeft();

	boolean hasUpperMiddle();

	boolean hasUpperRight();


}