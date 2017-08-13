package net.scilingo.board.state;

import net.scilingo.board.Player;

abstract class AbstractGameState implements GameState {

	protected Player _player;
	
	@Override
	public String printState() {
		return null;
	}

	@Override
	public String printMoves() {
		return this._player.getMoveHistory();
	}

}
