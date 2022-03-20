package net.scilingo.board;

abstract public class AbstractGameBoard {

	protected final char [][] gameBoard;
	protected final int rows;
	protected final int cols;

	AbstractGameBoard(){
		rows = 3;
		cols = 3;
		gameBoard = new char[rows][cols];
	}

	protected AbstractGameBoard(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		gameBoard = new char[rows][cols];
	}
}
