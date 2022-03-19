package net.scilingo.game;

import java.util.Scanner;

import net.scilingo.board.Board;
import net.scilingo.board.CellSelection;
import net.scilingo.board.tictactoe.TicTacToePlayer;
import net.scilingo.board.minesweeper.MinesweeperGameBoard;
import net.scilingo.board.minesweeper.MinesweeperGameFactory;

public class MinesweeperGame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2903022577605992749L;
	protected MinesweeperGameBoard _gameBoard;
	
	public MinesweeperGame() {
		_gameBoard = MinesweeperGameFactory.generateGameBoard();
	}
	
	public MinesweeperGame(int rows, int columns) {
		_gameBoard = MinesweeperGameFactory.generateGameBoard(rows, columns);
	}


}
