package scilingo.net.board.state;

import scilingo.net.board.Player;

public class LeftDiagonalWin implements WinningState {

	private Player _player;
	
	public LeftDiagonalWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String wonBy() {
		return new StringBuilder().append("Left Diagonal Win By ").append(_player.toString()).toString();
	}

}
