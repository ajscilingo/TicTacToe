package scilingo.net.board.state;

import scilingo.net.board.Player;

public class LeftColumnWin implements WinningState {

	private Player _player;
	
	public LeftColumnWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String wonBy() {
		return new StringBuilder().append("Left Column Win By ").append(_player.toString()).toString();
	}

}
