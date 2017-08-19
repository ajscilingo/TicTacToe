package net.scilingo.board;

import java.util.Stack;

import net.scilingo.board.state.*;

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

	private static GameState GameState;
	private static Player _playerOne;
	private static Player _playerTwo;

	// flag used to determine whether or not to call generatePlayers()
	// when GameFactory creates playerOne and playerTwo
	// Initial State is True
	private static boolean DoPlayersNeedToBeReGenerated = true;

	private static int CurrentNumOfMovesForAllPlayersInGame;

	// My Player Identifier
	// Player starts at one once added lines 22-23
	private int ID = 0;

	private Player(char symbol) {
		this._SYMBOL = symbol;
		this._moves = new Stack<Move>();

		// when new players are added reset this back to 0
		CurrentNumOfMovesForAllPlayersInGame = 0;

		// keep track of number of players
		_playerCount++;
		this.ID = _playerCount;
		this._name = new StringBuilder().append("Player ").append(this.ID).toString();
		GameState = null;
	}

	private static void generatePlayers() {

		// generate the first time otherwise mutate instance
		if (_playerOne == null)
			_playerOne = new Player(Constants.X_SYMBOL);
		else
			resetPlayer(_playerOne);

		// generate the first time otherwise mutate instance
		if (_playerTwo == null)
			_playerTwo = new Player(Constants.O_SYMBOL);
		else
			resetPlayer(_playerTwo);

		// Reset GameState
		GameState = null;

		// Reset Total Number of Moves
		CurrentNumOfMovesForAllPlayersInGame = 0;

		// UnSet Flag
		DoPlayersNeedToBeReGenerated = false;
	}

	static Player generatePlayerOne() {

		// check to see if generatePlayers needs to be called
		if (DoPlayersNeedToBeReGenerated)
			generatePlayers();

		return _playerOne;
	}

	static Player generatePlayerTwo() {
		// check to see if generatePlayers needs to be called
		if (DoPlayersNeedToBeReGenerated)
			generatePlayers();

		return _playerTwo;
	}

	public char move(Move move) {
		this._moves.push(move);

		switch (move.getClass().getSimpleName()) {

		case "MoveLowerLeft":
			this._lowerLeft = (MoveLowerLeft) move;
			CurrentNumOfMovesForAllPlayersInGame++;
			break;
		case "MoveLowerMiddle":
			this._lowerMiddle = (MoveLowerMiddle) move;
			CurrentNumOfMovesForAllPlayersInGame++;
			break;
		case "MoveLowerRight":
			CurrentNumOfMovesForAllPlayersInGame++;
			this._lowerRight = (MoveLowerRight) move;
			break;
		case "MoveMiddleLeft":
			this._middleLeft = (MoveMiddleLeft) move;
			CurrentNumOfMovesForAllPlayersInGame++;
			break;
		case "MoveMiddleMiddle":
			this._middleMiddle = (MoveMiddleMiddle) move;
			CurrentNumOfMovesForAllPlayersInGame++;
			break;
		case "MoveMiddleRight":
			this._middleRight = (MoveMiddleRight) move;
			CurrentNumOfMovesForAllPlayersInGame++;
			break;
		case "MoveUpperLeft":
			this._upperLeft = (MoveUpperLeft) move;
			CurrentNumOfMovesForAllPlayersInGame++;
			break;
		case "MoveUpperMiddle":
			this._upperMiddle = (MoveUpperMiddle) move;
			CurrentNumOfMovesForAllPlayersInGame++;
			break;
		case "MoveUpperRight":
			this._upperRight = (MoveUpperRight) move;
			CurrentNumOfMovesForAllPlayersInGame++;
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

	public boolean isGameOver() {
		
		// if GameState is already not null return
		if (Player.GameState != null)
			return true;
		
		Player.GameState = PlayerState.determineState(this);
		
		// check GameState again after being re-evaluated
		if (Player.GameState != null)
			DoPlayersNeedToBeReGenerated = true;
		
		return (Player.GameState != null);
	}

	public static GameState getGameState() {
		return Player.GameState;
	}

	public String getMoveHistory() {

		StringBuilder sb = new StringBuilder();

		for (Move m : _moves) {
			sb.append(m.toString()).append(" ").append(m.madeBy().toString()).append(Constants.NEWLINE);
		}

		return sb.toString();
	}

	@Override
	public String toString() {
		return this._name;
	}

	public static int getNumberOfPlayers() {
		return _playerCount;
	}

	public static int getNumberOfMoves() {
		return CurrentNumOfMovesForAllPlayersInGame;
	}

	protected static void resetPlayer(Player player) {

		// Reset cells
		player._upperLeft = null;
		player._upperMiddle = null;
		player._upperRight = null;

		player._middleLeft = null;
		player._middleMiddle = null;
		player._middleRight = null;

		player._lowerLeft = null;
		player._lowerMiddle = null;
		player._lowerRight = null;

		// Reset Moves
		player._moves.clear();
	}

	@Override
	protected void finalize() throws Throwable {
		_playerCount--;
		super.finalize();
	}
}
