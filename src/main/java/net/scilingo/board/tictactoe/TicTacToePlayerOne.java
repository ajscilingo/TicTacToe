package net.scilingo.board.tictactoe;

import net.scilingo.board.Constants;
import net.scilingo.board.Move;

class TicTacToePlayerOne extends AbstractTicTacToePlayer {
	
	private TicTacToePlayerComputer computerPlayer = null;
	
	TicTacToePlayerOne(){
		super(Constants.X_SYMBOL);
	}
	
	TicTacToePlayerOne(TicTacToePlayerComputer computerPlayer){
		this();
		this.computerPlayer = computerPlayer;
	}
	
	void setComputerOpponent(TicTacToePlayerComputer computerPlayer) {
		this.computerPlayer = computerPlayer;
	}
	
	TicTacToePlayerComputer getComputerOpponent() {
		return this.computerPlayer;
	}
	
	@Override
	protected void reset() {
		super.reset();
		
		// resets game state
		// only one of the players needs to initiate this on reset
		// as this is static "shared memory" between all player objects.
		resetPlayersGameState();
	}
	
	@Override
	public char move(Move move) {
		char x = super.move(move);
		
		// record move for computer player 
		// if computer player not null
		
		if(this.computerPlayer != null)
			this.computerPlayer.recordPlayerOnesMove(move.getDestinationCell());
		
		return x;
	}

	@Override
	public String toString() {
		return "Player 1";
	}
}
