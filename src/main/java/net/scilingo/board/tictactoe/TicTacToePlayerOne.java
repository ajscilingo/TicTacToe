package net.scilingo.board.tictactoe;

class TicTacToePlayerOne extends TicTacToePlayer {
	
	TicTacToePlayerOne(){
		super(Constants.X_SYMBOL);
	}
	
	@Override
	protected void reset() {
		super.reset();
		
		// resets game state
		// only one of the players needs to initiate this on reset
		// as this is static "shared memory" between all player objects.
		resetPlayersGameState();
	}
}
