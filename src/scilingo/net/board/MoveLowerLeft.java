package scilingo.net.board;

public class MoveLowerLeft implements Move {

	private Board _gameBoard;
	private Player _player;
	
	public MoveLowerLeft(Board board, Player player) {
		this._gameBoard = board;
		this._player = player;
	}
	
	@Override
	public boolean move() {
		if(this._gameBoard.canMove(Row.LOWER, Column.LEFT)){
			this._gameBoard.placeMove(this._player.move(this), Row.LOWER, Column.LEFT);
			return true;
		}
		return false;
	}
	
	@Override 
	public String toString(){
		return "Move To Lower Left";
	}

}
