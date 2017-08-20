package net.scilingo.board.state;

import net.scilingo.board.Constants;
import net.scilingo.board.Player;

public class TopRowWin extends AbstractGameState {

	public TopRowWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Top Row Win By ").append(_player.toString())
				.append(Constants.NEWLINE).append(super.printMoves()).toString();
	}

}
