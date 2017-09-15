package net.scilingo.game.tictactoe.state;

import net.scilingo.board.Constants;
import net.scilingo.board.Player;

public class TopRowWin extends AbstractGameState {

	public TopRowWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Top Row Win By ").append(_player.toString())
				.append(Constants.NEWLINE).append(Constants.NEWLINE).append(super.printMoves()).toString();
	}

	public String toHTML() {
		return new StringBuilder().append("Top Row Win By ").append(_player.toString())
				.append(Constants.HTML_LINE_BREAK).append(Constants.HTML_LINE_BREAK).append(super.printMoves(Constants.HTML_LINE_BREAK)).toString();
	}
}
