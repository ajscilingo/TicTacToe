package scilingo.net.board.state;

import scilingo.net.board.Player;

public class TiedGame extends AbstractGameState {

	public TiedGame(Player player) {
		this._player = player;
	}
	
	@Override
	public String printState() {
		return new StringBuilder().append("Tied Game!").toString();
	}

	@Override
	public String printMoves() {
		return null;
	}
	
}
