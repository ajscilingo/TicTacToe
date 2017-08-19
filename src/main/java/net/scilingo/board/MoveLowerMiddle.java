package net.scilingo.board;

public class MoveLowerMiddle implements Move {
	
	private final Board _gameBoard;
	private final Player _player;
	private final boolean _gameOver;
	
	public MoveLowerMiddle(Board board, Player player, boolean gameOver) {
		this._gameBoard = board;
		this._player = player;
		this._gameOver = gameOver;
	}
	
	@Override
	public boolean move() {
		
		if(this._gameBoard.canMove(Row.LOWER, Column.MIDDLE, _gameOver)){
			this._gameBoard.placeMove(this._player.move(this), Row.LOWER, Column.MIDDLE);
			return true;
		}
		return false;
	}
	
	@Override 
	public String toString(){
		return "Move To Lower Center";
	}

	@Override
	public Player madeBy() {
		return this._player;
	}
}
