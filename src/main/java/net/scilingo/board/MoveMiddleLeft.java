package net.scilingo.board;

public class MoveMiddleLeft implements Move {

	private final Board _gameBoard;
	private final Player _player;
	private final boolean _gameOver;
	
	public MoveMiddleLeft(Board board, Player player, boolean gameOver) {
		this._gameBoard = board;
		this._player = player;
		this._gameOver = gameOver;
	}
	
	@Override
	public boolean move() {
		
		if(this._gameBoard.canMove(Row.MIDDLE, Column.LEFT, _gameOver)){
			this._gameBoard.placeMove(this._player.move(this), Row.MIDDLE, Column.LEFT);
			return true;
		}
		return false;
	}
	
	@Override 
	public String toString(){
		return "Move To Center Left";
	}

	@Override
	public Player madeBy() {
		return this._player;
	}

}
