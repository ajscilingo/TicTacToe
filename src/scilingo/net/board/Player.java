package scilingo.net.board;

import java.util.Stack;

import scilingo.net.board.state.*;

public class Player {

	private final char _SYMBOL;
	private Stack<Move> _moves;
	private static int _playerCount = 0;
	private final String _name;
	
	private MoveLowerLeft _lowerLeft = null;
	private MoveLowerMiddle _lowerMiddle = null;
	private MoveLowerRight _lowerRight = null;
	
	private MoveMiddleLeft _middleLeft = null;
	private MoveMiddleMiddle _middleMiddle = null;
	private MoveMiddleRight _middleRight = null;
	
	private MoveUpperLeft _upperLeft = null;
	private MoveUpperMiddle _upperMiddle = null;
	private MoveUpperRight _upperRight = null;
	
	private WinningState _wonState = null;
	
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
		
		switch( move.getClass().getSimpleName() ) {
		
		case "MoveLowerLeft":
			this._lowerLeft = (MoveLowerLeft) move;
			break;
		case "MoveLowerMiddle":
			this._lowerMiddle = (MoveLowerMiddle) move;
			break;
		case "MoveLowerRight" :
			this._lowerRight = (MoveLowerRight) move;
			break;
		case "MoveMiddleLeft" :
			this._middleLeft = (MoveMiddleLeft) move;
			break;
		case "MoveMiddleMiddle" :
			this._middleMiddle = (MoveMiddleMiddle) move;
			break;
		case "MoveMiddleRight" :
			this._middleRight = (MoveMiddleRight) move;
			break;
		case "MoveUpperLeft" : 
			this._upperLeft = (MoveUpperLeft) move;
			break;
		case "MoveUpperMiddle" :
			this._upperMiddle = (MoveUpperMiddle) move;
			break;
		case "MoveUpperRight" :
			this._upperRight = (MoveUpperRight) move;
			break;
		}
		
		return this._SYMBOL;
	}
	
	public boolean hasLowerLeft() {
		return (_lowerLeft != null);
	}
	
	public boolean hasLowerMiddle() {
		return (_lowerMiddle != null);
	}
	
	public boolean hasLowerRight() {
		return (_lowerRight != null);
	}
	
	public boolean hasMiddleLeft() {
		return (_middleLeft != null);
	}
	
	public boolean hasMiddleMiddle() {
		return (_middleMiddle != null);
	}
	
	public boolean hasMiddleRight() {
		return (_middleRight != null);
	}
	
	public boolean hasUpperLeft() {
		return (_upperLeft != null);
	}
	
	public boolean hasUpperMiddle() {
		return (_upperMiddle != null);
	}
	
	public boolean hasUpperRight() {
		return (_upperRight != null);
	}
	
	public boolean hasWon() {
		
		// Top Row Win
		if(this.hasUpperLeft() && this.hasUpperMiddle() && this.hasUpperRight()) {
			_wonState = new TopRowWin(this);
		}
		// Middle Row Win
		else if(this.hasMiddleLeft() && this.hasMiddleMiddle() && this.hasMiddleRight()) {
			_wonState = new MiddleRowWin(this);
		}
		// Bottom Row Win
		else if(this.hasLowerLeft() && this.hasLowerMiddle() && this.hasLowerRight()) {
			_wonState = new BottomRowWin(this);
		}
		// Left Column Win
		else if(this.hasUpperLeft() && this.hasMiddleLeft() && this.hasLowerLeft()) {
			_wonState = new LeftColumnWin(this);
		}
		// Middle Column Win
		else if(this.hasUpperMiddle() && this.hasMiddleMiddle() && this.hasLowerMiddle()) {
			_wonState = new MiddleColumnWin(this);
		}
		// Right Column Win
		else if(this.hasUpperRight() && this.hasMiddleRight() && this.hasLowerRight()) {
			_wonState = new RightColumnWin(this);
		}
		// Right Diagonal Win
		else if(this.hasUpperLeft() && this.hasMiddleMiddle() && this.hasLowerRight()) {
			_wonState = new RightDiagonalWin(this);
		}
		// Left Diagonal Win
		else if(this.hasLowerLeft() && this.hasMiddleMiddle() && this.hasUpperRight()) {
			_wonState = new LeftDiagonalWin(this);
		}
		
		return (_wonState != null);
	}
	
	public WinningState getWonStatus() {
		return _wonState;
	}
	
	public void getMoveHistory() {
		
		for(Move m : _moves) {
			System.out.println(new StringBuilder().append(m.toString()).append(" ").append(m.madeBy().toString()).toString());
		}
	}
	
	
	@Override
	public String toString(){
		return this._name;
	}
	
	public static int getNumberOfPlayers(){
		return _playerCount;
	}
	
}
