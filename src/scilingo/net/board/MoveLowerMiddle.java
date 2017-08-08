package scilingo.net.board;

public class MoveLowerMiddle implements Move {
	
	private final Board _gameBoard;
	private final Player _player;
	
	public MoveLowerMiddle(Board board, Player player) {
		this._gameBoard = board;
		this._player = player;
	}
	
	@Override
	public boolean move() {
		
		if(this._gameBoard.canMove(Row.LOWER, Column.MIDDLE)){
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