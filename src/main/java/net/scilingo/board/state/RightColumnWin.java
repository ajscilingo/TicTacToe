package net.scilingo.board.state;

import net.scilingo.board.Constants;
import net.scilingo.board.Player;

public class RightColumnWin extends AbstractGameState {

	public RightColumnWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Right Column Win By ").append(_player.toString())
				.append(Constants.NEWLINE).append(super.printMoves()).toString();
	}

}
