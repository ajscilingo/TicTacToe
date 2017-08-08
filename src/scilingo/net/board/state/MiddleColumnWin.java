package scilingo.net.board.state;

import scilingo.net.board.Player;

public class MiddleColumnWin implements WinningState {

	private Player _player;
	
	public MiddleColumnWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String wonBy() {
		return new StringBuilder().append("Middle Column Win By ").append(_player.toString()).toString();
	}

}
