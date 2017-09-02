package net.scilingo.board;

abstract public class AbstractGameBoard implements Board {

	protected final char [][] _gameBoard;
	protected final int rows;
	protected final int cols;
	
	// Default Constructor
	AbstractGameBoard(){
		rows = 1;
		cols = 1;
		_gameBoard = new char[rows][cols];
	}
	
	// Custom Constructor
	protected AbstractGameBoard(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		_gameBoard = new char[rows][cols];
	}
}
