package net.scilingo.game.tictactoe.state;

import net.scilingo.board.Player;

public abstract class AbstractGameState {

	protected Player _player;

	public String printMoves() {
		return this._player.getMoveHistory();
	}
	
	public String printMoves(String format) {
		return this._player.getMoveHistory(format);
	}

}
