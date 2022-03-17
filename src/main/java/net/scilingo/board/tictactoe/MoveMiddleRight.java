package net.scilingo.board.tictactoe;

public class MoveMiddleRight extends AbstractTicTacToeMove {
	
	public MoveMiddleRight(TicTacToeGameBoard board){
		super(TicTacToeCellSelection.MIDDLE_RIGHT, board);
	}
	
	@Override
	public boolean move(TicTacToePlayer player, boolean gameOver) {
		return super.placeMove(player, Row.MIDDLE, Column.RIGHT, gameOver);
	}

	@Override 
	public String toString(){
		return "Move To Center Right";
	}
}
