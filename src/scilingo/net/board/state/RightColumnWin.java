package scilingo.net.board.state;

import scilingo.net.board.Player;

public class RightColumnWin extends AbstractGameState {

	public RightColumnWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String printState() {
		return new StringBuilder().append("Right Column Win By ").append(_player.toString()).toString();
	}

}
