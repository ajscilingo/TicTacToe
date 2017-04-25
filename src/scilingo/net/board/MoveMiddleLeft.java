package scilingo.net.board;

public class MoveMiddleLeft implements Move {

	private Board _gameBoard;
	private Player _player;
	
	public MoveMiddleLeft(Board board, Player player) {
		this._gameBoard = board;
		this._player = player;
	}
	
	@Override
	public boolean move() {
		
		if(this._gameBoard.canMove(Row.MIDDLE, Column.LEFT)){
			this._gameBoard.placeMove(this._player.move(this), Row.MIDDLE, Column.LEFT);
			return true;
		}
		return false;
	}
	
	@Override 
	public String toString(){
		return "Move To Center Left";
	}

}
