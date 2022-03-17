package net.scilingo.game.tictactoe.state;

import com.google.auto.service.AutoService;
import net.scilingo.board.Constants;
import net.scilingo.board.tictactoe.AbstractTicTacToePlayer;
import net.scilingo.board.tictactoe.TicTacToePlayer;

@AutoService(Winnable.class)
public class TiedGame extends AbstractGameState implements ToHtml, Winnable {

	public TiedGame() {}
	
	@Override
	public String winnerMessage() {
		return new StringBuilder().append("Tied Game!").toString();
	}
	
	public String toHTML() {
		return new StringBuilder().append(toString()).append(Constants.HTML_LINE_BREAK).toString();
	}

	@Override
	public AbstractGameState isGameOver(TicTacToePlayer player) {
		if(AbstractTicTacToePlayer.getNumberOfMoves() > 8)
			return this;
		else
			return null;
	}
}
