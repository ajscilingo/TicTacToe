package scilingo.net.board.state;

import scilingo.net.board.Player;

public class TopRowWin extends AbstractGameState {

	public TopRowWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String printState() {
		return new StringBuilder().append("Top Row Win By ").append(_player.toString()).toString();
	}

}
