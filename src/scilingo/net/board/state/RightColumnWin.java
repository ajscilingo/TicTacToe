package scilingo.net.board.state;

import scilingo.net.board.Player;

public class RightColumnWin implements WinningState {

	private Player _player;
	
	public RightColumnWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String wonBy() {
		return new StringBuilder().append("Right Column Win By ").append(_player.toString()).toString();
	}

}
