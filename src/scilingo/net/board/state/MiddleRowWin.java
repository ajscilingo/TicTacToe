package scilingo.net.board.state;

import scilingo.net.board.Player;

public class MiddleRowWin implements WinningState {

	private Player _player;
	
	public MiddleRowWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String wonBy() {
		return new StringBuilder().append("Middle Row Win By ").append(_player.toString()).toString();
	}

}
