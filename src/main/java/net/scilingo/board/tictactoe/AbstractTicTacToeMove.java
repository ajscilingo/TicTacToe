package net.scilingo.board.tictactoe;

import net.scilingo.board.Move;

abstract class AbstractTicTacToeMove implements Move {

	protected TicTacToePlayer player;
	protected final TicTacToeGameBoard gameBoard;
	protected final TicTacToeCellSelection cellSelection;
	
	AbstractTicTacToeMove(final TicTacToeCellSelection cellSelection, final TicTacToeGameBoard gameBoard){
		this.player = null;
		this.gameBoard = gameBoard;
		this.cellSelection = cellSelection;
	}
	
	boolean placeMove(final TicTacToePlayer player, final Row row, final Column col, final boolean gameOver) {
		if(this.gameBoard.canMove(row, col, gameOver)){
			this.player = player;
			this.gameBoard.placeMove(this.player.move(this), row, col);
			return true;
		}
		return false;
	}
	
	@Override
	public TicTacToePlayer madeBy() {
		return this.player;
	}
	
	@Override
	public TicTacToeCellSelection getDestinationCell() {
		return this.cellSelection;
	}

}
