package net.scilingo.board.tictactoe;

import net.scilingo.board.Player;

public class MoveLowerRight extends AbstractTicTacToeMove {
	
	public MoveLowerRight(TicTacToeGameBoard board) {
		super(TicTacToeCellSelection.LOWER_RIGHT, board);
	}
	
	@Override
	public boolean move(Player player, boolean gameOver) {
		return super.placeMove(player, Row.LOWER, Column.RIGHT, gameOver);
	}
	
	@Override 
	public String toString(){
		return "Move To Lower Right";
	}
}
