package net.scilingo.board.tictactoe;

public class TicTacToeGameFactory {
	
	private static TicTacToePlayer _playerOne;
	private static TicTacToePlayer _playerTwo;
	private static TicTacToePlayer _playerComputer;
	private static TicTacToeGameBoard _ticTacToeGameBoard;
	
	public static TicTacToePlayer generatePlayerOne() {
		// generate the first time otherwise mutate instance
		if(_playerOne == null) {
			
			_playerOne = new TicTacToePlayerOne();
		
			if(_playerComputer == null) {
				_playerComputer = new TicTacToePlayerComputer();
				((TicTacToePlayerOne)_playerOne).setComputerOpponent((TicTacToePlayerComputer)_playerComputer);
			}
			
		}
		else {
			_playerOne.reset();
			_playerComputer.reset();
		}
		
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
		
		if( ((TicTacToePlayerOne)_playerOne).getComputerOpponent() != null) {
			((TicTacToePlayerOne)_playerOne).getComputerOpponent().reset();
			return  ((TicTacToePlayerOne)_playerOne).getComputerOpponent();
		}
		else {
			_playerComputer = new TicTacToePlayerComputer();
			((TicTacToePlayerOne)_playerOne).setComputerOpponent((TicTacToePlayerComputer)_playerComputer);
			return _playerComputer;
		}
	}
	
	public static TicTacToeGameBoard generateGameBoard() {
		if(_ticTacToeGameBoard == null)
			_ticTacToeGameBoard = new TicTacToeGameBoard();
		else
			_ticTacToeGameBoard.clearBoard();
		return _ticTacToeGameBoard;
	}
}
