package net.scilingo.game;

import java.util.Scanner;
import java.util.concurrent.CancellationException;

import net.scilingo.board.*;
import net.scilingo.board.state.TiedGame;

class Game {

	private boolean _gameOver;
	protected Player _currentPlayer;
	protected Player _player1;
	protected Player _player2;
	protected Board _gameBoard;
	
	public Game(){
		_player1 = GameFactory.generatePlayerOne();
		_player2 = GameFactory.generatePlayerTwo();
		_gameOver = false;
		_gameBoard = GameFactory.generateBoard();
		_currentPlayer = _player1;
	}
	
	public Player getCurrentPlayer(){
		if(_currentPlayer == null)
			return _player1;
		
		if(_currentPlayer.equals(_player1))
			return _player2;
		else
			return _player1;
	}
	
	public void play(){
		
		Scanner sc = new Scanner(System.in);
		
		while(!isGameOver()){
			showMenu();
			
			try {
				makeMove(Cell.values()[sc.nextInt()]);
			}
			catch(Exception e){
				// prevent user from changing on exception
				_currentPlayer = getCurrentPlayer();
				sc.nextLine();
			}
		}
		if(playAgain(sc))
			new Game().play();
		sc.close();
	}
	
	public void checkForWinOrTie(){
	
		if(_currentPlayer.isGameOver()){
			System.out.println(Player.getGameState().printState());
			_gameOver =  true;		
		}
			
	}
	
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
	
	private void showMenu(){
		
		StringBuilder sb = new StringBuilder();
		System.out.print(sb
		.append(_currentPlayer)
		.append(" Make move #")
		.append(Player.getNumberOfMoves() + 1)
		.append(Constants.NEWLINE)
		.append(Cell.UPPER_LEFT.ordinal()).append(".) Move To Upper Left")
		.append(Constants.NEWLINE)
		.append(Cell.UPPER_MIDDLE.ordinal()).append(".) Move To Upper Center")
		.append(Constants.NEWLINE)
		.append(Cell.UPPER_RIGHT.ordinal()).append(".) Move To Upper Right")
		.append(Constants.NEWLINE)
		.append(Cell.MIDDLE_LEFT.ordinal()).append(".) Move To Center Left")
		.append(Constants.NEWLINE)
		.append(Cell.MIDDLE_MIDDLE.ordinal()).append(".) Move To Center")
		.append(Constants.NEWLINE)
		.append(Cell.MIDDLE_RIGHT.ordinal()).append(".) Move To Center Right")
		.append(Constants.NEWLINE)
		.append(Cell.LOWER_LEFT.ordinal()).append(".) Move To Lower Left")
		.append(Constants.NEWLINE)
		.append(Cell.LOWER_MIDDLE.ordinal()).append(".) Move To Lower Center")
		.append(Constants.NEWLINE)
		.append(Cell.LOWER_RIGHT.ordinal()).append(".) Move To Lower Right")
		.append(Constants.NEWLINE)
		.toString());
	}
	
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
	
	public boolean makeMove(Cell m){
		
		boolean moveSuccess = false;
		
		if(!_gameOver) {
			
			switch (m) {
				case UPPER_LEFT:
					moveSuccess = new MoveUpperLeft(this._gameBoard, this._currentPlayer, this._gameOver).move();
					break;
				case UPPER_MIDDLE: 
					moveSuccess = new MoveUpperMiddle(this._gameBoard, this._currentPlayer, this._gameOver).move();	
					break;
				case UPPER_RIGHT: 
					moveSuccess = new MoveUpperRight(this._gameBoard, this._currentPlayer, this._gameOver).move();
					break;
				case MIDDLE_LEFT: 
					moveSuccess = new MoveMiddleLeft(this._gameBoard, this._currentPlayer, this._gameOver).move();
					break;
				case MIDDLE_MIDDLE: 
					moveSuccess = new MoveMiddleMiddle(this._gameBoard, this._currentPlayer, this._gameOver).move();
					break;
				case MIDDLE_RIGHT: 
					moveSuccess = new MoveMiddleRight(this._gameBoard, this._currentPlayer, this._gameOver).move();
					break;
				case LOWER_LEFT: 
					moveSuccess = new MoveLowerLeft(this._gameBoard, this._currentPlayer, this._gameOver).move();
					break;
				case LOWER_MIDDLE: 
					moveSuccess = new MoveLowerMiddle(this._gameBoard, this._currentPlayer, this._gameOver).move();
					break;
				case LOWER_RIGHT: 
					moveSuccess = new MoveLowerRight(this._gameBoard, this._currentPlayer, this._gameOver).move();
					break;
				default:
					break;
			}
			
			if(moveSuccess) {
				showBoard();
				checkForWinOrTie();
			}
			_currentPlayer = getCurrentPlayer();
		}
		return moveSuccess;
	}
}
