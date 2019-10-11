package net.scilingo.board.tictactoe;

import net.scilingo.board.Constants;

class TicTacToePlayerTwo extends TicTacToePlayer {
	
	TicTacToePlayerTwo(){
		super(Constants.O_SYMBOL);
	}
	
	@Override
	public String toString() {
		return "Player 2";
	}
}
