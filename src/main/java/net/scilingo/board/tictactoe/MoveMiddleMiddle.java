package net.scilingo.board.tictactoe;

public class MoveMiddleMiddle extends AbstractTicTacToeMove {
	
	public MoveMiddleMiddle(TicTacToeGameBoard board){
		super(TicTacToeCellSelection.MIDDLE_MIDDLE, board);
	}
	
	@Override
	public boolean move(TicTacToePlayer player, boolean gameOver) {
		return super.placeMove(player, Row.MIDDLE, Column.MIDDLE, gameOver);	
	}

	@Override 
	public String toString(){
		return "Move To Center";
	}
}
