package net.scilingo.board.tictactoe;

import net.scilingo.board.Player;

public class MoveUpperMiddle extends AbstractTicTacToeMove {

	
	public MoveUpperMiddle(TicTacToeGameBoard board){
		super(TicTacToeCellSelection.UPPER_MIDDLE, board);
	}
	
	@Override
	public boolean move(Player player, boolean gameOver) {
		return super.placeMove(player, Row.UPPER, Column.MIDDLE, gameOver);
	}
	
	@Override 
	public String toString(){
		return "Move To Upper Center";
	}

}
