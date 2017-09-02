package net.scilingo.board.tictactoe;

import net.scilingo.board.Player;

public class MoveUpperLeft extends AbstractTicTacToeMove {

	
	public MoveUpperLeft(TicTacToeGameBoard board){
		super(TicTacToeCellSelection.UPPER_LEFT, board);
	}
	
	@Override
	public boolean move(Player player, boolean gameOver) {
		return super.placeMove(player, Row.UPPER, Column.LEFT, gameOver);
	}
	
	@Override 
	public String toString(){
		return "Move To Upper Left";
	}
	
}
