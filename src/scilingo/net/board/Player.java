package scilingo.net.board;

import java.util.Stack;

public class Player {

	private final char _SYMBOL;
	private Stack<Move> _moves;
	private static int _playerCount = 0;
	
	// My Player Identifier
	private int ID = 0;
	
	public Player(char symbol){
		this._SYMBOL = symbol;
		this._moves = new Stack<Move>();
		
		// keep track of number of players
		_playerCount++;
		this.ID = _playerCount;
	}
	
	public char move(Move move){
		this._moves.push(move);
		return this._SYMBOL;
	}
	
	@Override
	public String toString(){
		return new StringBuilder().append("Player ").append(this.ID).toString();
	}
	
	public static int getNumberOfPlayers(){
		return _playerCount;
	}
	
}
