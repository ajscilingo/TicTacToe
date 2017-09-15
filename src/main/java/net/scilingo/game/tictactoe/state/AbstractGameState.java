package net.scilingo.game.tictactoe.state;

import net.scilingo.board.Player;

abstract class AbstractGameState implements GameState {

	protected Player _player;

	public String printMoves() {
		return this._player.getMoveHistory();
	}
	
	public String printMoves(String format) {
		return this._player.getMoveHistory(format);
	}

}
