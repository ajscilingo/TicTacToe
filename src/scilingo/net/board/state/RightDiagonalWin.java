package scilingo.net.board.state;

import scilingo.net.board.Player;

public class RightDiagonalWin extends AbstractGameState {

	public RightDiagonalWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String printState() {
		return new StringBuilder().append("Right Diagonal Win By ").append(_player.toString()).toString();

	}

}
