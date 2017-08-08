package scilingo.net.board;

public class MoveMiddleRight implements Move {

	private final Board _gameBoard;
	private final Player _player;
	
	public MoveMiddleRight(Board board, Player player){
		this._gameBoard = board;
		this._player = player;
	}
	
	@Override
	public boolean move() {
		
		if(this._gameBoard.canMove(Row.MIDDLE, Column.RIGHT)){
			this._gameBoard.placeMove(this._player.move(this), Row.MIDDLE, Column.RIGHT);
			return true;
		}
		return false;
	}

	@Override 
	public String toString(){
		return "Move To Center Right";
	}

	@Override
	public Player madeBy() {
		return this._player;
	}
}
