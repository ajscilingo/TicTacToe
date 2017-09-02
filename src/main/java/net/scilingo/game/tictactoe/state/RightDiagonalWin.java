package net.scilingo.game.tictactoe.state;

import net.scilingo.board.Constants;
import net.scilingo.board.Player;

public class RightDiagonalWin extends AbstractGameState {

	public RightDiagonalWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Right Diagonal Win By ").append(_player.toString())
				.append(Constants.NEWLINE).append(super.printMoves()).toString();

	}

}
