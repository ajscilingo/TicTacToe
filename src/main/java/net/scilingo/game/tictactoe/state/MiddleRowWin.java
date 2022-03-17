package net.scilingo.game.tictactoe.state;

import com.google.auto.service.AutoService;
import net.scilingo.board.Constants;
import net.scilingo.board.tictactoe.TicTacToePlayer;

@AutoService(Winnable.class)
public class MiddleRowWin extends AbstractGameState implements ToHtml, Winnable {
	
	public MiddleRowWin() {
	}
	
	@Override
	public String winnerMessage() {
		return new StringBuilder().append("Middle Row Win By ").append(player.toString())
				.append(Constants.NEWLINE).append(Constants.NEWLINE).append(super.printMoves()).toString();	
	}
	
	public String toHTML() {
		return new StringBuilder().append("Middle Row Win By ").append(player.toString())
				.append(Constants.HTML_LINE_BREAK).append(Constants.HTML_LINE_BREAK).append(super.printMoves(Constants.HTML_LINE_BREAK)).toString();
	}

	@Override
	public AbstractGameState isGameOver(TicTacToePlayer player) {
		if(player.hasMiddleLeft() && player.hasMiddleMiddle() && player.hasMiddleRight()){
			setPlayer(player);
			return this;
		}
		else
			return null;
	}
}
