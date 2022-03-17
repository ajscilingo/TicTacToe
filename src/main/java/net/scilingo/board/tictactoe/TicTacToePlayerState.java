package net.scilingo.board.tictactoe;

import net.scilingo.game.tictactoe.state.*;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TicTacToePlayerState {

	static AbstractGameState determineState(AbstractTicTacToePlayer player) {

		AbstractGameState gameState = null;
		ServiceLoader<Winnable> loader = ServiceLoader.load(Winnable.class);
		Iterator<Winnable> winnableIterator = loader.iterator();
		do{
			gameState = winnableIterator.next().isGameOver(player);
		} while(winnableIterator.hasNext() && gameState == null);
		return gameState;
	}
	
}
