package net.scilingo.board;

public class MoveUpperLeft implements Move {

	private final Board _gameBoard;
	private final Player _player;
	
	public MoveUpperLeft(Board board, Player player){
		this._gameBoard = board;
		this._player = player;
	}
	
	@Override
	public boolean move() {
		
		if(this._gameBoard.canMove(Row.UPPER, Column.LEFT)){
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
