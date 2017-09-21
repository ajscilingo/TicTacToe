package net.scilingo.board.tictactoe;


import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import net.scilingo.board.CellSelection;



public class TicTacToePlayerComputer extends TicTacToePlayerTwo {

	// Last Recorded move made by Player1
	private TicTacToeCellSelection _playerOnesLastMove;
	// List Of Optional Moves For Computer Player
	private Stack<CellSelection> _availableMoves = new Stack<CellSelection>();
	
	TicTacToePlayerComputer() {
		super();
	}
	
	public CellSelection getNextMove() {
		if(!this._availableMoves.isEmpty())
			return this._availableMoves.pop();
		else
			return null;
	}
	
	void recordPlayerOnesMove(CellSelection cellSelection) {
		// record player1's last move
		this._playerOnesLastMove = (TicTacToeCellSelection)cellSelection;
		
		// clear available moves if not empty
		if(!this._availableMoves.isEmpty())
			this._availableMoves.clear();
		
		// setup a list of available strategic moves
		this._availableMoves.addAll(Arrays.asList(TicTacToeCellSelection.getAdjacentCells(this._playerOnesLastMove)));
		
		// shuffle possible moves
		Collections.shuffle(this._availableMoves);
	}	
}
