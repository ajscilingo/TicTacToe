package scilingo.net.board.state;

import scilingo.net.board.Player;

public class RightDiagonalWin implements WinningState {

	private Player _player;
	
	public RightDiagonalWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String wonBy() {
		return new StringBuilder().append("Right Diagonal Win By ").append(_player.toString()).toString();

	}

}
