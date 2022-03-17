package net.scilingo.game.tictactoe.state;

import net.scilingo.board.tictactoe.TicTacToePlayer;

public abstract class AbstractGameState {

	protected TicTacToePlayer _player;

	public String printMoves() {
		return this._player.getMoveHistory();
	}
	
	public String printMoves(String format) {
		return this._player.getMoveHistory(format);
	}

}
