package net.scilingo.board;

public interface Player {

	char move(Move move);

	boolean isGameOver();

	String getMoveHistory();

}