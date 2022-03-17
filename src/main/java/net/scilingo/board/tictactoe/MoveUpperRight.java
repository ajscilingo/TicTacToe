package net.scilingo.board.tictactoe;

public class MoveUpperRight extends AbstractTicTacToeMove {
	
	public MoveUpperRight(TicTacToeGameBoard board){
		super(TicTacToeCellSelection.UPPER_RIGHT, board);
	}
	
	@Override
	public boolean move(TicTacToePlayer player, boolean gameOver) {
		return super.placeMove(player, Row.UPPER, Column.RIGHT, gameOver);
	}
	
	@Override
	public String toString(){
		return "Move To Upper Right";
	}

}
