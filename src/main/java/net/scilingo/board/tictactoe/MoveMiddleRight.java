package net.scilingo.board.tictactoe;

import net.scilingo.board.Player;

public class MoveMiddleRight extends AbstractTicTacToeMove {
	
	public MoveMiddleRight(TicTacToeGameBoard board){
		super(TicTacToeCellSelection.MIDDLE_RIGHT, board);
	}
	
	@Override
	public boolean move(Player player, boolean gameOver) {
		return super.placeMove(player, Row.MIDDLE, Column.RIGHT, gameOver);
	}

	@Override 
	public String toString(){
		return "Move To Center Right";
	}
}
