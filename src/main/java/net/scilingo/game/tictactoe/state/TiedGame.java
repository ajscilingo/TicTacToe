package net.scilingo.game.tictactoe.state;

import net.scilingo.board.Constants;
import net.scilingo.board.Player;

public class TiedGame extends AbstractGameState implements ToHtml {

	public TiedGame(Player player) {
		this._player = player;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Tied Game!").toString();
	}
	
	public String toHTML() {
		return new StringBuilder().append(toString()).append(Constants.HTML_LINE_BREAK).toString();
	}
}
