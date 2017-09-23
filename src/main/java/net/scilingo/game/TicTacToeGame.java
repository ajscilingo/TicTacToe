package net.scilingo.game;

import java.util.Scanner;

import net.scilingo.board.*;
import net.scilingo.board.tictactoe.*;
import net.scilingo.game.tictactoe.state.GameState;

public class TicTacToeGame implements Game {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1401219477193635111L;
	private boolean _gameOver;
	protected Player _currentPlayer;
	protected Player _player1;
	protected Player _player2;
	protected Player _playerHuman;
	protected Player _playerComputer;
	protected TicTacToeGameBoard _gameBoard;
	
	public TicTacToeGame(){
		_gameBoard = TicTacToeGameFactory.generateGameBoard();
		_player1 = TicTacToeGameFactory.generatePlayerOne();
		_player2 = TicTacToeGameFactory.generatePlayerTwo();
		_playerHuman = null;
		_playerComputer = null;
		_gameOver = false;
		_currentPlayer = _player1;
	}
	
	public TicTacToeGame(boolean humanPlayer)
	{
		this();
		
		if(!humanPlayer) {
			_playerComputer = TicTacToeGameFactory.generatePlayerComputer();
			_player2 = _playerComputer;
			
		}
		else {
			_playerHuman = _player2;
		}
		
	}
	
	public void determinePlayerTwo(Scanner sc) {
		while(_player2 == null) {
			showPlayerMenu();
			
			try {
				int playerSelection = sc.nextInt();
				
				if(playerSelection == Constants.TWO_PLAYER) {
					_playerHuman = TicTacToeGameFactory.generatePlayerTwo();
					_player2 = _playerHuman;
				}
				else if(playerSelection == Constants.ONE_PLAYER) {
					_playerComputer = TicTacToeGameFactory.generatePlayerComputer();
					_player2 = _playerComputer;
				}
				else {
					System.out.println(Constants.ONE_OR_TWO_PLAYERS_MSG);
				}
			}
			catch(Exception e){
				System.out.println(Constants.INVALID_PLAYER_SELECTION_MSG);
				sc.next();
			}
		}
		
	}
	
	/* (non-Javadoc)
	 * @see net.scilingo.game.Game#getCurrentPlayer()
	 */
	@Override
	public Player getCurrentPlayer(){
		if(_currentPlayer == null)
			return _player1;
		
		if(_currentPlayer.equals(_player1))
			return _player2;
		else
			return _player1;
	}
	
	public TicTacToePlayerComputer getComputerPlayer() {
		if(_player2.equals(_playerComputer))
			return (TicTacToePlayerComputer) _playerComputer;
		else
			return null;
	}
	
	/* (non-Javadoc)
	 * @see net.scilingo.game.Game#play()
	 */
	@Override
	public void play(){
		
		// set _player2 to null again for determining what it should be
		_player2 = null;
		
		Scanner sc = new Scanner(System.in);
		determinePlayerTwo(sc);
		
		while(!isGameOver()){
			
			if( _currentPlayer.equals(_player1) || _currentPlayer.equals(_playerHuman) )
			{
				
				showMoveMenu();
				
				try {
					makeMove(TicTacToeCellSelection.values()[sc.nextInt()]);
				}
				catch(Exception e){
					// prevent user from changing on exception
					_currentPlayer = getCurrentPlayer();
					sc.nextLine();
				}
			}
			else if(_currentPlayer.equals(_playerComputer)) {
				
				TicTacToePlayerComputer computerPlayer = (TicTacToePlayerComputer) _playerComputer;
				
				try {
					while(makeMove(computerPlayer.getNextMove()) == false){
						System.out.println("Space Already Occupied Trying Again");
						_currentPlayer = getCurrentPlayer();
					}
				}
				catch(Exception e){
					System.err.println(e.getMessage());
				}
			}
		
		}
		if(playAgain(sc))
			new TicTacToeGame().play();
		sc.close();
	}
	
	/* (non-Javadoc)
	 * @see net.scilingo.game.Game#checkForWinOrTie()
	 */
	@Override
	public void checkForWin(){
	
		if(_currentPlayer.isGameOver()){
			System.out.println(TicTacToePlayer.getGameState());
			_gameOver =  true;		
		}
			
	}
	
	public String getGameState(){
		
		GameState gameState = TicTacToePlayer.getGameState();
		
		if(gameState != null)
			return gameState.toString();
		else
			return "";
	}
	
	public String getGameStateHTML() {
		
		GameState gameState = TicTacToePlayer.getGameState();
		
		if(gameState != null)
			return gameState.toHTML();
		else
			return "";
	}
	
	
	/* (non-Javadoc)
	 * @see net.scilingo.game.Game#isGameOver()
	 */
	@Override
	public boolean isGameOver() {
		return _gameOver;
	}
	
	
	private void showBoard(){
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.print(this._gameBoard);
		System.out.println(" ");
		System.out.println(" ");
	}
	
	private void showPlayerMenu() {
		StringBuilder sb = new StringBuilder();
		System.out.println(sb
		.append("Choose Number Of Players:")
		.append(Constants.NEWLINE)
		.append("1 Player")
		.append(Constants.NEWLINE)
		.append("2 Player")
		.toString());
	}
	
	private void showMoveMenu(){
		
		StringBuilder sb = new StringBuilder();
		System.out.print(sb
		.append(_currentPlayer)
		.append(" Make move #")
		.append(TicTacToePlayer.getNumberOfMoves() + 1)
		.append(Constants.NEWLINE)
		.append(TicTacToeCellSelection.UPPER_LEFT.ordinal()).append(".) Move To Upper Left")
		.append(Constants.NEWLINE)
		.append(TicTacToeCellSelection.UPPER_MIDDLE.ordinal()).append(".) Move To Upper Center")
		.append(Constants.NEWLINE)
		.append(TicTacToeCellSelection.UPPER_RIGHT.ordinal()).append(".) Move To Upper Right")
		.append(Constants.NEWLINE)
		.append(TicTacToeCellSelection.MIDDLE_LEFT.ordinal()).append(".) Move To Center Left")
		.append(Constants.NEWLINE)
		.append(TicTacToeCellSelection.MIDDLE_MIDDLE.ordinal()).append(".) Move To Center")
		.append(Constants.NEWLINE)
		.append(TicTacToeCellSelection.MIDDLE_RIGHT.ordinal()).append(".) Move To Center Right")
		.append(Constants.NEWLINE)
		.append(TicTacToeCellSelection.LOWER_LEFT.ordinal()).append(".) Move To Lower Left")
		.append(Constants.NEWLINE)
		.append(TicTacToeCellSelection.LOWER_MIDDLE.ordinal()).append(".) Move To Lower Center")
		.append(Constants.NEWLINE)
		.append(TicTacToeCellSelection.LOWER_RIGHT.ordinal()).append(".) Move To Lower Right")
		.append(Constants.NEWLINE)
		.toString());
	}
	
	/* (non-Javadoc)
	 * @see net.scilingo.game.Game#playAgain(java.util.Scanner)
	 */
	@Override
	public boolean playAgain(Scanner sc) {
		System.out.println(Constants.PLAY_AGAIN_MSG);
		String response = sc.next().toUpperCase();
		
		boolean stopLooping = ( Constants.YES.equals(response) || Constants.Y.equals(response) || Constants.N.equals(response) || Constants.NO.equals(response) );
		
		while(!stopLooping) {
			System.out.println(Constants.PLAY_AGAIN_MSG);
			response = sc.next().toUpperCase();
			stopLooping = ( Constants.YES.equals(response) || Constants.Y.equals(response) || Constants.N.equals(response) || Constants.NO.equals(response) );
		}
		
		if(Constants.YES.equals(response) || Constants.Y.equals(response))
			return true;
		else 
			return false;
			
	}
	
	/* (non-Javadoc)
	 * @see net.scilingo.game.Game#makeMove(net.scilingo.board.Cell)
	 */
	@Override
	public boolean makeMove(CellSelection cellSelection){
		
		boolean moveSuccess = false;
		
		TicTacToeCellSelection ticTacToeCellSelection = (TicTacToeCellSelection) cellSelection;
		
		if(!_gameOver) {
			
			switch (ticTacToeCellSelection) {
				case UPPER_LEFT:
					moveSuccess = new MoveUpperLeft(this._gameBoard).move(this._currentPlayer, this._gameOver);
					break;
				case UPPER_MIDDLE: 
					moveSuccess = new MoveUpperMiddle(this._gameBoard).move(this._currentPlayer, this._gameOver);	
					break;
				case UPPER_RIGHT: 
					moveSuccess = new MoveUpperRight(this._gameBoard).move(this._currentPlayer, this._gameOver);
					break;
				case MIDDLE_LEFT: 
					moveSuccess = new MoveMiddleLeft(this._gameBoard).move(this._currentPlayer, this._gameOver);
					break;
				case MIDDLE_MIDDLE: 
					moveSuccess = new MoveMiddleMiddle(this._gameBoard).move(this._currentPlayer, this._gameOver);
					break;
				case MIDDLE_RIGHT: 
					moveSuccess = new MoveMiddleRight(this._gameBoard).move(this._currentPlayer, this._gameOver);
					break;
				case LOWER_LEFT: 
					moveSuccess = new MoveLowerLeft(this._gameBoard).move(this._currentPlayer, this._gameOver);
					break;
				case LOWER_MIDDLE: 
					moveSuccess = new MoveLowerMiddle(this._gameBoard).move(this._currentPlayer, this._gameOver);
					break;
				case LOWER_RIGHT: 
					moveSuccess = new MoveLowerRight(this._gameBoard).move(this._currentPlayer, this._gameOver);
					break;
				default:
					break;
			}
			
			if(moveSuccess) {
				showBoard();
				checkForWin();
			}
			_currentPlayer = getCurrentPlayer();
		}
		return moveSuccess;
	}

	@Override
	public Board getGameBoard() {
		return _gameBoard;
	}
}
