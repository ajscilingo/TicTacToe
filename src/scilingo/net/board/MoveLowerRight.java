package scilingo.net.board;

public class MoveLowerRight implements Move {

	private Board _gameBoard;
	private Player _player;
	
	public MoveLowerRight(Board board, Player player) {
		this._gameBoard = board;
		this._player = player;
	}
	
	@Override
	public boolean move() {
		
		if(this._gameBoard.canMove(Row.LOWER, Column.RIGHT)){
			this._gameBoard.placeMove(this._player.move(this), Row.LOWER, Column.RIGHT);
			return true;
		}
		return false;
	}
	
	@Override 
	public String toString(){
		return "Move To Lower Right";
	}

}
