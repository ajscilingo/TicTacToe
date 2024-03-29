package net.scilingo.board;

import net.scilingo.board.tictactoe.TicTacToePlayer;

public interface Move {

	public boolean move(TicTacToePlayer player, boolean gameOver);
	public TicTacToePlayer madeBy();
	public String getDisplayName();
	public CellSelection getDestinationCell();
	
}
