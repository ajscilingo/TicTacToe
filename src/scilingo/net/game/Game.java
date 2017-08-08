package scilingo.net.game;

import java.util.Scanner;
import scilingo.net.board.*;

class Game {

	private boolean _gameOver;
	protected Player _currentPlayer;
	protected Player _playerA;
	protected Player _playerB;
	protected Board _gameBoard;
	protected int _numberOfMoves;
	private final static char _x = 'X';
	private final static char _o = 'O';
	
	private static String _newLine = System.getProperty("line.separator");
	
	public Game(){
		_playerA = new Player(_x);
		_playerB = new Player(_o);
		_gameOver = false;
		_gameBoard = new Board();
	}
	
	
	private Player getCurrentPlayer(){
		if(_currentPlayer == null)
			return _playerA;
		
		if(_currentPlayer.equals(_playerA))
			return _playerB;
		else
			return _playerA;
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
			if(this._numberOfMoves > 8){
				System.out.println("Tie!");
				_gameOver = true;
			}
			else{
				if(_currentPlayer.hasWon()){
					System.out.println(_currentPlayer.getWonStatus().wonBy());
					_currentPlayer.getMoveHistory();
					_gameOver =  true;
				}
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
		.append(this._numberOfMoves)
		.append(_newLine)
		.append("1.) Move To Upper Left")
		.append(_newLine)
		.append("2.) Move To Upper Center")
		.append(_newLine)
		.append("3.) Move To Upper Right")
		.append(_newLine)
		.append("4.) Move To Center Left")
		.append(_newLine)
		.append("5.) Move To Center")
		.append(_newLine)
		.append("6.) Move To Center Right")
		.append(_newLine)
		.append("7.) Move To Lower Left")
		.append(_newLine)
		.append("8.) Move To Lower Center")
		.append(_newLine)
		.append("9.) Move To Lower Right")
		.append(_newLine)
		.toString());
	}
	
	public void makeMove(int m){
		switch (m) {
			case 1: this._numberOfMoves += (new MoveUpperLeft(this._gameBoard, this._currentPlayer).move() ? 1 : 0);
					break;
			case 2: this._numberOfMoves += (new MoveUpperMiddle(this._gameBoard, this._currentPlayer).move() ? 1 : 0);
					break;
			case 3: this._numberOfMoves += (new MoveUpperRight(this._gameBoard, this._currentPlayer).move() ? 1 : 0);
					break;
			case 4: this._numberOfMoves += (new MoveMiddleLeft(this._gameBoard, this._currentPlayer).move() ? 1 : 0);
					break;
			case 5: this._numberOfMoves += (new MoveMiddleMiddle(this._gameBoard, this._currentPlayer).move() ? 1 : 0);
					break;
			case 6: this._numberOfMoves += (new MoveMiddleRight(this._gameBoard, this._currentPlayer).move() ? 1 : 0);
					break;
			case 7: this._numberOfMoves += (new MoveLowerLeft(this._gameBoard, this._currentPlayer).move() ? 1 : 0);
					break;
			case 8: this._numberOfMoves += (new MoveLowerMiddle(this._gameBoard, this._currentPlayer).move() ? 1 : 0);
					break;
			case 9: this._numberOfMoves += (new MoveLowerRight(this._gameBoard, this._currentPlayer).move() ? 1 : 0);
					break;
			
		}
	}
}
