package scilingo.net.game;

import java.util.Scanner;
import scilingo.net.board.*;

class Game {

	private boolean _gameOver;
	protected Player _currentPlayer;
	protected Player _player1;
	protected Player _player2;
	protected Board _gameBoard;
	
	public Game(){
		_player1 = new Player(Constants.X_SYMBOL);
		_player2 = new Player(Constants.O_SYMBOL);
		_gameOver = false;
		_gameBoard = new Board();
	}
	
	
	private Player getCurrentPlayer(){
		if(_currentPlayer == null)
			return _player1;
		
		if(_currentPlayer.equals(_player1))
			return _player2;
		else
			return _player1;
	}
	
	public void play(){
		
		Scanner sc = new Scanner(System.in);
		
		while(!_gameOver){
			// set the current player
			_currentPlayer = getCurrentPlayer();
			showMenu();
			try {
				makeMove(sc.nextInt());
			}
			catch(Exception e){
				// prevent user from changing on exception
				_currentPlayer = getCurrentPlayer();
				sc.nextLine();
			}
			showBoard();
			checkForWinOrTie();
		}
		
		sc.close();
	}
	
	private void checkForWinOrTie(){
	
		if(_currentPlayer.isGameOver()){
			System.out.println(_currentPlayer.getGameState().printState());
			if(_currentPlayer.getGameState().printMoves() != null)
				System.out.println(_currentPlayer.getGameState().printMoves());
			_gameOver =  true;		
		}
			
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
		.append("1.) Move To Upper Left")
		.append(Constants.NEWLINE)
		.append("2.) Move To Upper Center")
		.append(Constants.NEWLINE)
		.append("3.) Move To Upper Right")
		.append(Constants.NEWLINE)
		.append("4.) Move To Center Left")
		.append(Constants.NEWLINE)
		.append("5.) Move To Center")
		.append(Constants.NEWLINE)
		.append("6.) Move To Center Right")
		.append(Constants.NEWLINE)
		.append("7.) Move To Lower Left")
		.append(Constants.NEWLINE)
		.append("8.) Move To Lower Center")
		.append(Constants.NEWLINE)
		.append("9.) Move To Lower Right")
		.append(Constants.NEWLINE)
		.toString());
	}
	
	public void makeMove(int m){
		switch (m) {
			case 1: 
				new MoveUpperLeft(this._gameBoard, this._currentPlayer).move();
				break;
			case 2: 
				new MoveUpperMiddle(this._gameBoard, this._currentPlayer).move();	
				break;
			case 3: 
				new MoveUpperRight(this._gameBoard, this._currentPlayer).move();
				break;
			case 4: 
				new MoveMiddleLeft(this._gameBoard, this._currentPlayer).move();
				break;
			case 5: 
				new MoveMiddleMiddle(this._gameBoard, this._currentPlayer).move();
				break;
			case 6: 
				new MoveMiddleRight(this._gameBoard, this._currentPlayer).move();
				break;
			case 7: 
				new MoveLowerLeft(this._gameBoard, this._currentPlayer).move();
				break;
			case 8: 
				new MoveLowerMiddle(this._gameBoard, this._currentPlayer).move();
				break;
			case 9: 
				new MoveLowerRight(this._gameBoard, this._currentPlayer).move();
				break;
			default:
				break;
		}
	}
}
