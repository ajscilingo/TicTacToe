package net.scilingo.board.tictactoe;

import net.scilingo.board.Move;

abstract class AbstractTicTacToeMove implements Move {

	protected TicTacToePlayer _player;
	protected final TicTacToeGameBoard _gameBoard;
	protected final TicTacToeCellSelection _cellSelection;
	
	AbstractTicTacToeMove(final TicTacToeCellSelection cellSelection, final TicTacToeGameBoard gameBoard){
		this._player = null;
		this._gameBoard = gameBoard;
		this._cellSelection = cellSelection;	
	}
	
	public String getDisplayName() {
		return new StringBuilder(this._cellSelection.ordinal()).append(".) ").append(this.toString()).toString();
	}
	
	boolean placeMove(final TicTacToePlayer player, final Row row, final Column col, final boolean gameOver) {
		if(this._gameBoard.canMove(row, col, gameOver)){
			this._player = player;
			this._gameBoard.placeMove(this._player.move(this), row, col);
			return true;
		}
		return false;
	}
	
	@Override
	public TicTacToePlayer madeBy() {
		return this._player;
	}
	
	@Override
	public TicTacToeCellSelection getDestinationCell() {
		return this._cellSelection;
	}

}
