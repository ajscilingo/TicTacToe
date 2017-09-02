package net.scilingo.board.tictactoe;

import net.scilingo.board.Player;

public class MoveLowerLeft extends AbstractTicTacToeMove {
	
	public MoveLowerLeft(TicTacToeGameBoard board) {
		super(TicTacToeCellSelection.LOWER_LEFT, board);
	}
	
	@Override
	public boolean move(Player player, boolean gameOver) {		
		return super.placeMove(player, Row.LOWER, Column.LEFT, gameOver);
	}
	
	@Override 
	public String toString(){
		return "Move To Lower Left";
	}

}
