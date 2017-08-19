package net.scilingo.board;

public class MoveLowerRight implements Move {

	private final Board _gameBoard;
	private final Player _player;
	private final boolean _gameOver;
	
	public MoveLowerRight(Board board, Player player, boolean gameOver) {
		this._gameBoard = board;
		this._player = player;
		this._gameOver = gameOver;
	}
	
	@Override
	public boolean move() {
		
		if(this._gameBoard.canMove(Row.LOWER, Column.RIGHT, _gameOver)){
			this._gameBoard.placeMove(this._player.move(this), Row.LOWER, Column.RIGHT);
			return true;
		}
		return false;
	}
	
	@Override 
	public String toString(){
		return "Move To Lower Right";
	}

	@Override
	public Player madeBy() {
		return this._player;
	}

}
