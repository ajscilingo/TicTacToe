package scilingo.net.board.state;

import scilingo.net.board.Player;

public class TopRowWin implements WinningState {

	private Player _player;
	
	public TopRowWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String wonBy() {
		return new StringBuilder().append("Top Row Win By ").append(_player.toString()).toString();
	}

}
