package net.scilingo.board.tictactoe;

import java.util.Collections;
import java.util.Stack;

import net.scilingo.board.CellSelection;

public class TicTacToeGameFactory {
	
	private static TicTacToePlayer _playerOne;
	private static TicTacToePlayer _playerTwo;
	private static TicTacToePlayer _playerComputer;
	private static TicTacToeGameBoard _ticTacToeGameBoard;
	
	public static TicTacToePlayer generatePlayerOne() {
		// generate the first time otherwise mutate instance
		if(_playerOne == null)
			_playerOne = new TicTacToePlayerOne();
		else
			_playerOne.reset();
		
		return _playerOne;
	}
	
	public static TicTacToePlayer generatePlayerTwo() {
		// generate the first time otherwise mutate instance
		if(_playerTwo == null)
			_playerTwo = new TicTacToePlayerTwo();
		else
			_playerTwo.reset();
		
		return _playerTwo;
	}
	
	public static TicTacToePlayer generatePlayerComputer() {
		
		if(_playerComputer == null) {
			_playerComputer = new TicTacToePlayerComputer();
		}
		else 
			_playerComputer.reset();
		
		Stack<CellSelection> moves = ((TicTacToePlayerComputer) _playerComputer).getMoveList();
		resetMoveList(moves);
		
		if(_ticTacToeGameBoard == null)
			generateGameBoard();
		
		return _playerComputer;
	}
	
	public static TicTacToeGameBoard generateGameBoard() {
		if(_ticTacToeGameBoard == null)
			_ticTacToeGameBoard = new TicTacToeGameBoard();
		else
			_ticTacToeGameBoard.clearBoard();
		return _ticTacToeGameBoard;
	}
	
	private static void resetMoveList(Stack<CellSelection> moves) {
		
		moves.clear();
		moves.add(TicTacToeCellSelection.UPPER_LEFT);
		moves.add(TicTacToeCellSelection.UPPER_MIDDLE);
		moves.add(TicTacToeCellSelection.UPPER_RIGHT);
		
		moves.add(TicTacToeCellSelection.MIDDLE_LEFT);
		moves.add(TicTacToeCellSelection.MIDDLE_MIDDLE);
		moves.add(TicTacToeCellSelection.MIDDLE_RIGHT);
		
		moves.add(TicTacToeCellSelection.LOWER_LEFT);
		moves.add(TicTacToeCellSelection.LOWER_MIDDLE);
		moves.add(TicTacToeCellSelection.LOWER_RIGHT);
		
		Collections.shuffle(moves);
	}
}
