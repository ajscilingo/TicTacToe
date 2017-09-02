package net.scilingo.game.tictactoe.state;

import net.scilingo.board.Constants;
import net.scilingo.board.Player;

public class BottomRowWin extends AbstractGameState {
	
	public BottomRowWin(Player player) {
		this._player = player;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Bottom Row Win By ").append(_player.toString())
				.append(Constants.NEWLINE).append(super.printMoves()).toString();
	}

}
