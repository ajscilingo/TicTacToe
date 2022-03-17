package net.scilingo.board.tictactoe;

import net.scilingo.game.tictactoe.state.*;

public class TicTacToePlayerState {

	static AbstractGameState determineState(TicTacToePlayer player) {

		
		// Top Row Win
		if(player.hasUpperLeft() && player.hasUpperMiddle() && player.hasUpperRight())
			return new TopRowWin(player);
		// Middle Row Win
		else if(player.hasMiddleLeft() && player.hasMiddleMiddle() && player.hasMiddleRight())
			return new MiddleRowWin(player);
		// Bottom Row Win
		else if(player.hasLowerLeft() && player.hasLowerMiddle() && player.hasLowerRight())
			return new BottomRowWin(player);
		// Left Column Win
		else if(player.hasUpperLeft() && player.hasMiddleLeft() && player.hasLowerLeft())
			return new LeftColumnWin(player);
		// Middle Column Win
		else if(player.hasUpperMiddle() && player.hasMiddleMiddle() && player.hasLowerMiddle())
			return new MiddleColumnWin(player);
		// Right Column Win
		else if(player.hasUpperRight() && player.hasMiddleRight() && player.hasLowerRight()) 
			return new RightColumnWin(player);
		// Right Diagonal Win
		else if(player.hasUpperLeft() && player.hasMiddleMiddle() && player.hasLowerRight()) 
			return new RightDiagonalWin(player);
		// Left Diagonal Win
		else if(player.hasLowerLeft() && player.hasMiddleMiddle() && player.hasUpperRight()) 
			return new LeftDiagonalWin(player);
		// Tied Game
		else if(TicTacToePlayer.getNumberOfMoves() > 8)
			return new TiedGame(player);
		// No Win
		else
			return null;
	}
	
}
