package net.scilingo.game;

import java.util.Scanner;

import net.scilingo.board.Board;
import net.scilingo.board.CellSelection;
import net.scilingo.board.Player;
import net.scilingo.board.minesweeper.MinesweeperGameBoard;
import net.scilingo.board.minesweeper.MinesweeperGameFactory;

public class MinesweeperGame implements Game{

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
	
	@Override
	public Player getCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board getGameBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game play(Scanner sc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkForWin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean playAgain(Scanner sc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean makeMove(CellSelection cellSelection) {
		// TODO Auto-generated method stub
		return false;
	}

}
