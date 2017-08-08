package scilingo.net.board.state;

import scilingo.net.board.Player;

public class BottomRowWin implements WinningState {

	private Player _player;
	
	public BottomRowWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String wonBy() {
		return new StringBuilder().append("Bottom Row Win By ").append(_player.toString()).toString();
	}

}
