package net.scilingo.board.state;

import net.scilingo.board.Player;

public class MiddleRowWin extends AbstractGameState {
	
	public MiddleRowWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String printState() {
		return new StringBuilder().append("Middle Row Win By ").append(_player.toString()).toString();
	}

}
