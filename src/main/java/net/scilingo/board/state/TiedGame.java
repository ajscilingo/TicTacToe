package net.scilingo.board.state;

import net.scilingo.board.Player;

public class TiedGame extends AbstractGameState {

	public TiedGame(Player player) {
		this._player = player;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Tied Game!").toString();
	}
	
}
