package scilingo.net.board.state;

import scilingo.net.board.Player;

public class LeftColumnWin extends AbstractGameState {

	public LeftColumnWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String printState() {
		return new StringBuilder().append("Left Column Win By ").append(_player.toString()).toString();
	}

}
