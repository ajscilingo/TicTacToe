package net.scilingo.game.tictactoe.state;

import com.google.auto.service.AutoService;
import net.scilingo.board.Constants;
import net.scilingo.board.tictactoe.TicTacToePlayer;

@AutoService(Winnable.class)
public class MiddleColumnWin extends AbstractGameState implements ToHtml, Winnable {

	public MiddleColumnWin(){}
	
	@Override
	public String winnerMessage() {
		return new StringBuilder().append("Middle Column Win By ").append(player.toString())
				.append(Constants.NEWLINE).append(Constants.NEWLINE).append(super.printMoves()).toString();
	}

	public String toHTML() {
		return new StringBuilder().append("Middle Column Win By ").append(player.toString())
				.append(Constants.HTML_LINE_BREAK).append(Constants.HTML_LINE_BREAK).append(super.printMoves(Constants.HTML_LINE_BREAK)).toString();
	}

	@Override
	public AbstractGameState isGameOver(TicTacToePlayer player) {
		if(player.hasUpperMiddle() && player.hasMiddleMiddle() && player.hasLowerMiddle()){
			setPlayer(player);
			return this;
		}
		else
			return null;
	}
}
