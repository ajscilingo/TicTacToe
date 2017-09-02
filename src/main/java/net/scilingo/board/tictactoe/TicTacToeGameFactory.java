package net.scilingo.board.tictactoe;

public class TicTacToeGameFactory {
	
	private static TicTacToePlayer _playerOne;
	private static TicTacToePlayer _playerTwo;
	
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
	
	public static TicTacToeGameBoard generateGameBoard() {
		return TicTacToeGameBoard.generateTicTacToeGameBoard();
	}
}
