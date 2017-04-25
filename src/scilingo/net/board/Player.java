package scilingo.net.board;

import java.util.Stack;

public class Player {

	private final char _SYMBOL;
	private Stack<Move> _moves;
	private static int _playerCount = 0;
	private final String _name;
	
	// My Player Identifier
	// Player starts at one once added lines 22-23
	private int ID = 0;
	
	
	public Player(char symbol){
		this._SYMBOL = symbol;
		this._moves = new Stack<Move>();
		
		// keep track of number of players
		_playerCount++;
		this.ID = _playerCount;
		this._name = new StringBuilder().append("Player ").append(this.ID).toString();
	}
	
	public char move(Move move){
		this._moves.push(move);
		return this._SYMBOL;
	}
	
	@Override
	public String toString(){
		return this._name;
	}
	
	public static int getNumberOfPlayers(){
		return _playerCount;
	}
	
}
