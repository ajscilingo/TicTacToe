package net.scilingo.board.state;

import net.scilingo.board.Player;

public class RightDiagonalWin extends AbstractGameState {

	public RightDiagonalWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String printState() {
		return new StringBuilder().append("Right Diagonal Win By ").append(_player.toString()).toString();

	}

}
