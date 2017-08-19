package net.scilingo.board;

public class MoveLowerLeft implements Move {

	private final Board _gameBoard;
	private final Player _player;
	private final boolean _gameOver;
	
	public MoveLowerLeft(Board board, Player player, Boolean gameOver) {
		this._gameBoard = board;
		this._player = player;
		this._gameOver = gameOver;
	}
	
	@Override
	public boolean move() {
		if(this._gameBoard.canMove(Row.LOWER, Column.LEFT, _gameOver)){
			this._gameBoard.placeMove(this._player.move(this), Row.LOWER, Column.LEFT);
			return true;
		}
		return false;
	}
	
	@Override 
	public String toString(){
		return "Move To Lower Left";
	}

	@Override
	public Player madeBy() {
		return this._player;
	}

}
