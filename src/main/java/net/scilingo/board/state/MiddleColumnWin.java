package net.scilingo.board.state;

import net.scilingo.board.Player;

public class MiddleColumnWin extends AbstractGameState {

	public MiddleColumnWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String printState() {
		return new StringBuilder().append("Middle Column Win By ").append(_player.toString()).toString();
	}

}
