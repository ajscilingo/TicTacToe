package net.scilingo.board.tictactoe;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import net.scilingo.board.CellSelection;



public class TicTacToePlayerComputer extends TicTacToePlayerTwo {

	// Last Recorded move made by Player1
	private TicTacToeCellSelection _playerOnesLastMove;
	// List Of Optional Moves For Computer Player
	private Stack<CellSelection> _preferedMoves = new Stack<CellSelection>();
	private Set<CellSelection> _availableMoves = new HashSet<CellSelection>();
	
	TicTacToePlayerComputer() {
		super();
		resetAvailableMoves();
	}
	
	public CellSelection getNextMove() {
		
		CellSelection myNextPotentialMove = null;
		
		if(!this._preferedMoves.isEmpty()) {
			
			myNextPotentialMove = 	_preferedMoves.pop();
			
			while(!_availableMoves.contains(myNextPotentialMove)) {
				if(!_preferedMoves.isEmpty()) {
					myNextPotentialMove = _preferedMoves.pop();
				}
				else {
					myNextPotentialMove = pickFromAvailableCells();
				}
			}
		}
		else {
			myNextPotentialMove = pickFromAvailableCells();
		}
		
		// remove myNextPotentialMove from _availableMoves
		_availableMoves.remove(myNextPotentialMove);		
		return myNextPotentialMove;
	}
	
	void recordPlayerOnesMove(CellSelection cellSelection) {
		// record player1's last move
		this._playerOnesLastMove = (TicTacToeCellSelection)cellSelection;
		
		// Remove Player 1's cell selection from list of available moves
		_availableMoves.remove(cellSelection);
		
		// clear available moves if not empty
		if(!this._preferedMoves.isEmpty())
			this._preferedMoves.clear();
		
		// setup a list of available strategic moves
		this._preferedMoves.addAll(Arrays.asList(TicTacToeCellSelection.getAdjacentCells(this._playerOnesLastMove)));
		
		// shuffle possible moves
		Collections.shuffle(this._preferedMoves);
	}
	
	@Override
	protected void reset() {
		super.reset();
		resetAvailableMoves();
	}
	
	private void resetAvailableMoves() {
		_availableMoves.add(TicTacToeCellSelection.UPPER_LEFT);
		_availableMoves.add(TicTacToeCellSelection.UPPER_MIDDLE);
		_availableMoves.add(TicTacToeCellSelection.UPPER_RIGHT);
		_availableMoves.add(TicTacToeCellSelection.MIDDLE_LEFT);
		_availableMoves.add(TicTacToeCellSelection.MIDDLE_MIDDLE);
		_availableMoves.add(TicTacToeCellSelection.MIDDLE_RIGHT);
		_availableMoves.add(TicTacToeCellSelection.LOWER_LEFT);
		_availableMoves.add(TicTacToeCellSelection.LOWER_MIDDLE);
		_availableMoves.add(TicTacToeCellSelection.LOWER_RIGHT);
	}
	
	private CellSelection pickFromAvailableCells() {
		Iterator<CellSelection> availableMovesItr = _availableMoves.iterator();
		
		if(availableMovesItr.hasNext())
			return availableMovesItr.next();
		else
			return null;
	}
}
