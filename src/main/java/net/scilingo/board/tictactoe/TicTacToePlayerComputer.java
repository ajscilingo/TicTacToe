package net.scilingo.board.tictactoe;


import java.util.Stack;
import net.scilingo.board.CellSelection;



public class TicTacToePlayerComputer extends TicTacToePlayerTwo {

	// List Of Moves For Computer Player
	private Stack<CellSelection> moveList = new Stack<CellSelection>();
	
	TicTacToePlayerComputer() {
		super();
	}
	
	Stack<CellSelection> getMoveList(){
		return moveList;
	}
	
	public CellSelection getNextMove() {
		if(!moveList.isEmpty())
			return moveList.pop();
		else
			return null;
	}
}
