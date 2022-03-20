package net.scilingo.board.tictactoe;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;



public class TicTacToePlayerComputer extends TicTacToePlayerTwo {

	// Last Recorded move made by Player1
	private TicTacToeCellSelection playerOnesLastMove;
	// List Of Optional Moves For Computer Player
	private final Stack<TicTacToeCellSelection> preferredMoves = new Stack<TicTacToeCellSelection>();
	private final Set<TicTacToeCellSelection> availableMoves = new HashSet<TicTacToeCellSelection>();
	
	TicTacToePlayerComputer() {
		super();
		resetAvailableMoves();
	}
	
	public TicTacToeCellSelection getNextMove() {
		
		TicTacToeCellSelection myNextPotentialMove = null;
		
		if(!this.preferredMoves.isEmpty()) {
			
			myNextPotentialMove = 	preferredMoves.pop();
			
			while(!availableMoves.contains(myNextPotentialMove)) {
				if(!preferredMoves.isEmpty()) {
					myNextPotentialMove = preferredMoves.pop();
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
		availableMoves.remove(myNextPotentialMove);
		return myNextPotentialMove;
	}
	
	void recordPlayerOnesMove(TicTacToeCellSelection cellSelection) {
		// record player1's last move
		this.playerOnesLastMove = cellSelection;
		
		// Remove Player 1's cell selection from list of available moves
		availableMoves.remove(cellSelection);
		
		// clear available moves if not empty
		if(!this.preferredMoves.isEmpty())
			this.preferredMoves.clear();
		
		// setup a list of available strategic moves
		this.preferredMoves.addAll(Arrays.asList(this.playerOnesLastMove.getAdjacentCells()));
		
		// shuffle possible moves
		Collections.shuffle(this.preferredMoves);
	}
	
	@Override
	protected void reset() {
		super.reset();
		resetAvailableMoves();
	}
	
	private void resetAvailableMoves() {
		availableMoves.add(TicTacToeCellSelection.UPPER_LEFT);
		availableMoves.add(TicTacToeCellSelection.UPPER_MIDDLE);
		availableMoves.add(TicTacToeCellSelection.UPPER_RIGHT);
		availableMoves.add(TicTacToeCellSelection.MIDDLE_LEFT);
		availableMoves.add(TicTacToeCellSelection.MIDDLE_MIDDLE);
		availableMoves.add(TicTacToeCellSelection.MIDDLE_RIGHT);
		availableMoves.add(TicTacToeCellSelection.LOWER_LEFT);
		availableMoves.add(TicTacToeCellSelection.LOWER_MIDDLE);
		availableMoves.add(TicTacToeCellSelection.LOWER_RIGHT);
	}
	
	private TicTacToeCellSelection pickFromAvailableCells() {
		Iterator<TicTacToeCellSelection> availableMovesItr = availableMoves.iterator();
		
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
