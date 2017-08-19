package net.scilingo.board;

public class MoveUpperLeft implements Move {

	private final Board _gameBoard;
	private final Player _player;
	private final boolean _gameOver;
	
	public MoveUpperLeft(Board board, Player player, boolean gameOver){
		this._gameBoard = board;
		this._player = player;
		this._gameOver = gameOver;
	}
	
	@Override
	public boolean move() {
		
		if(this._gameBoard.canMove(Row.UPPER, Column.LEFT, _gameOver)){
			this._gameBoard.placeMove(_player.move(this), Row.UPPER, Column.LEFT);
			return true;
		}
		return false;
		
	}
	
	@Override 
	public String toString(){
		return "Move To Upper Left";
	}

	@Override
	public Player madeBy() {
		return this._player;
	}
	
}
