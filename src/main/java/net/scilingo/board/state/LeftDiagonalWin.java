package net.scilingo.board.state;

import net.scilingo.board.Constants;
import net.scilingo.board.Player;

public class LeftDiagonalWin extends AbstractGameState {
	
	public LeftDiagonalWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Left Diagonal Win By ").append(_player.toString())
				.append(Constants.NEWLINE).append(super.printMoves()).toString();
	}

}
