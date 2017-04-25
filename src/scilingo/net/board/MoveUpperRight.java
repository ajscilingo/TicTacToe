package scilingo.net.board;

public class MoveUpperRight implements Move {

	private Board _gameBoard;
	private Player _player;
	
	public MoveUpperRight(Board board, Player player){
		this._gameBoard = board;
		this._player = player;
	}
	
	@Override
	public boolean move() {
		
		if(this._gameBoard.canMove(Row.UPPER, Column.RIGHT)){
			this._gameBoard.placeMove(this._player.move(this), Row.UPPER, Column.RIGHT);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Move To Upper Right";
	}

}
