package net.scilingo.board.tictactoe;

import net.scilingo.board.Player;

public class MoveMiddleLeft extends AbstractTicTacToeMove {

	
	public MoveMiddleLeft(TicTacToeGameBoard board) {
		super(TicTacToeCellSelection.MIDDLE_LEFT, board);
		
	}
	
	@Override
	public boolean move(Player player, boolean gameOver) {
		return super.placeMove(player, Row.MIDDLE, Column.LEFT, gameOver);
	}
	
	@Override 
	public String toString(){
		return "Move To Center Left";
	}

}
