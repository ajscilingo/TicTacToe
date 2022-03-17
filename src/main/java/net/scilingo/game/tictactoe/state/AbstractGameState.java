package net.scilingo.game.tictactoe.state;

import net.scilingo.board.tictactoe.TicTacToePlayer;

public abstract class AbstractGameState {

	protected TicTacToePlayer player;

	public TicTacToePlayer getPlayer() {
		return player;
	}

	public void setPlayer(TicTacToePlayer player) {
		this.player = player;
	}

	public String printMoves() {
		return player.getMoveHistory();
	}
	
	public String printMoves(String format) {
		return player.getMoveHistory(format);
	}

}
