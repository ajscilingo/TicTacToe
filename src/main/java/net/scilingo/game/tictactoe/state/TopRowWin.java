package net.scilingo.game.tictactoe.state;

import net.scilingo.board.Player;
import net.scilingo.board.tictactoe.Constants;

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
