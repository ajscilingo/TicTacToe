package scilingo.net.board.state;

import scilingo.net.board.Player;

public class BottomRowWin extends AbstractGameState {
	
	public BottomRowWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String printState() {
		return new StringBuilder().append("Bottom Row Win By ").append(_player.toString()).toString();
	}

}
