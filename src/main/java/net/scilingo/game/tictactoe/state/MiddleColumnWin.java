package net.scilingo.game.tictactoe.state;

import net.scilingo.board.Constants;
import net.scilingo.board.Player;

public class MiddleColumnWin extends AbstractGameState {

	public MiddleColumnWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Middle Column Win By ").append(_player.toString())
				.append(Constants.NEWLINE).append(Constants.NEWLINE).append(super.printMoves()).toString();
	}

	public String toHTML() {
		return new StringBuilder().append("Middle Column Win By ").append(_player.toString())
				.append(Constants.HTML_LINE_BREAK).append(Constants.HTML_LINE_BREAK).append(super.printMoves(Constants.HTML_LINE_BREAK)).toString();
	}
	
}
