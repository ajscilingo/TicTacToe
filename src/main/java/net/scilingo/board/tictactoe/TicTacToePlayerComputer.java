package net.scilingo.board.tictactoe;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;



public class TicTacToePlayerComputer extends TicTacToePlayerTwo {

	// Last Recorded move made by Player1
	private TicTacToeCellSelection _playerOnesLastMove;
	// List Of Optional Moves For Computer Player
	private final Stack<TicTacToeCellSelection> _preferredMoves = new Stack<TicTacToeCellSelection>();
	private final Set<TicTacToeCellSelection> _availableMoves = new HashSet<TicTacToeCellSelection>();
	
	TicTacToePlayerComputer() {
		super();
		resetAvailableMoves();
	}
	
	public TicTacToeCellSelection getNextMove() {
		
		TicTacToeCellSelection myNextPotentialMove = null;
		
		if(!this._preferredMoves.isEmpty()) {
			
			myNextPotentialMove = 	_preferredMoves.pop();
			
			while(!_availableMoves.contains(myNextPotentialMove)) {
				if(!_preferredMoves.isEmpty()) {
					myNextPotentialMove = _preferredMoves.pop();
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
	
	void recordPlayerOnesMove(TicTacToeCellSelection cellSelection) {
		// record player1's last move
		this._playerOnesLastMove = cellSelection;
		
		// Remove Player 1's cell selection from list of available moves
		_availableMoves.remove(cellSelection);
		
		// clear available moves if not empty
		if(!this._preferredMoves.isEmpty())
			this._preferredMoves.clear();
		
		// setup a list of available strategic moves
		this._preferredMoves.addAll(Arrays.asList(this._playerOnesLastMove.getAdjacentCells()));
		
		// shuffle possible moves
		Collections.shuffle(this._preferredMoves);
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
	
	private TicTacToeCellSelection pickFromAvailableCells() {
		Iterator<TicTacToeCellSelection> availableMovesItr = _availableMoves.iterator();
		
		if(availableMovesItr.hasNext())
			return availableMovesItr.next();
		else
			return null;
	}
	
	@Override
	public String toString() {
		return "Computer Player";
	}
}
