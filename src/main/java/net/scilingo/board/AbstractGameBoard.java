package net.scilingo.board;

abstract public class AbstractGameBoard implements Board {

	protected final char [][] _gameBoard;
	protected final int _rows;
	protected final int _cols;
	
	// Default Constructor
	AbstractGameBoard(){
		_rows = 1;
		_cols = 1;
		_gameBoard = new char[_rows][_cols];
	}
	
	// Custom Constructor
	protected AbstractGameBoard(int rows, int cols) {
		this._rows = rows;
		this._cols = cols;
		_gameBoard = new char[rows][cols];
	}
}
