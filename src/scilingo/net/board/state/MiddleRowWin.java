package scilingo.net.board.state;

import scilingo.net.board.Player;

public class MiddleRowWin extends AbstractGameState {
	
	public MiddleRowWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String printState() {
		return new StringBuilder().append("Middle Row Win By ").append(_player.toString()).toString();
	}

}
