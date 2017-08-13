package net.scilingo.board;

public class MoveMiddleMiddle implements Move {

	private final Board _gameBoard;
	private final Player _player;
	
	public MoveMiddleMiddle(Board board, Player player){
		this._gameBoard = board;
		this._player = player;
	}
	
	@Override
	public boolean move() {
		
		if(this._gameBoard.canMove(Row.MIDDLE, Column.MIDDLE)){
			this._gameBoard.placeMove(this._player.move(this), Row.MIDDLE, Column.MIDDLE);
			return true;
		}
		return false;
		
	}

	@Override 
	public String toString(){
		return "Move To Center";
	}

	@Override
	public Player madeBy() {
		return this._player;
	}
}
