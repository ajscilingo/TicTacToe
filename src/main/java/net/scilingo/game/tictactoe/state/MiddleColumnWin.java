package net.scilingo.game.tictactoe.state;

import net.scilingo.board.Player;
import net.scilingo.board.tictactoe.Constants;

public class MiddleColumnWin extends AbstractGameState {

	public MiddleColumnWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Middle Column Win By ").append(_player.toString())
				.append(Constants.NEWLINE).append(super.printMoves()).toString();
	}

}
