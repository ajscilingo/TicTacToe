package net.scilingo.board.tictactoe;

import java.util.Stack;

import net.scilingo.board.Constants;
import net.scilingo.board.Move;
import net.scilingo.game.tictactoe.state.*;

public abstract class AbstractTicTacToePlayer implements TicTacToePlayer {

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

	private static AbstractGameState _gameState;

	private static int _currentNumOfMovesForAllPlayersInGame;

	// My Player Identifier
	// Player starts at one once added lines 22-23
	private int id = 0;
	
	AbstractTicTacToePlayer(char symbol) {
		this._SYMBOL = symbol;
		this._moves = new Stack<Move>();

		// when new players are added reset this back to 0
		_currentNumOfMovesForAllPlayersInGame = 0;

		// keep track of number of players
		_playerCount++;
		this.id = _playerCount;
		this._name = new StringBuilder().append("Player ").append(this.id).toString();
		_gameState = null;
	}

	protected static void resetPlayersGameState() {

		// Reset GameState
		_gameState = null;

		// Reset Total Number of Moves
		_currentNumOfMovesForAllPlayersInGame = 0;
		
	}

	/* (non-Javadoc)
	 * @see net.scilingo.board.tictactoe.Player#move(net.scilingo.board.tictactoe.Move)
	 */
	@Override
	public char move(Move move) {
		this._moves.push(move);

		switch (move.getClass().getSimpleName()) {

		case "MoveLowerLeft":
			this._lowerLeft = (MoveLowerLeft) move;
			_currentNumOfMovesForAllPlayersInGame++;
			break;
		case "MoveLowerMiddle":
			this._lowerMiddle = (MoveLowerMiddle) move;
			_currentNumOfMovesForAllPlayersInGame++;
			break;
		case "MoveLowerRight":
			_currentNumOfMovesForAllPlayersInGame++;
			this._lowerRight = (MoveLowerRight) move;
			break;
		case "MoveMiddleLeft":
			this._middleLeft = (MoveMiddleLeft) move;
			_currentNumOfMovesForAllPlayersInGame++;
			break;
		case "MoveMiddleMiddle":
			this._middleMiddle = (MoveMiddleMiddle) move;
			_currentNumOfMovesForAllPlayersInGame++;
			break;
		case "MoveMiddleRight":
			this._middleRight = (MoveMiddleRight) move;
			_currentNumOfMovesForAllPlayersInGame++;
			break;
		case "MoveUpperLeft":
			this._upperLeft = (MoveUpperLeft) move;
			_currentNumOfMovesForAllPlayersInGame++;
			break;
		case "MoveUpperMiddle":
			this._upperMiddle = (MoveUpperMiddle) move;
			_currentNumOfMovesForAllPlayersInGame++;
			break;
		case "MoveUpperRight":
			this._upperRight = (MoveUpperRight) move;
			_currentNumOfMovesForAllPlayersInGame++;
			break;
		}

		return this._SYMBOL;
	}

	@Override
	public boolean hasLowerLeft() {
		return (_lowerLeft != null);
	}

	@Override
	public boolean hasLowerMiddle() {
		return (_lowerMiddle != null);
	}

	@Override
	public boolean hasLowerRight() {
		return (_lowerRight != null);
	}

	@Override
	public boolean hasMiddleLeft() {
		return (_middleLeft != null);
	}

	@Override
	public boolean hasMiddleMiddle() {
		return (_middleMiddle != null);
	}

	@Override
	public boolean hasMiddleRight() {
		return (_middleRight != null);
	}

	@Override
	public boolean hasUpperLeft() {
		return (_upperLeft != null);
	}

	@Override
	public boolean hasUpperMiddle() {
		return (_upperMiddle != null);
	}

	@Override
	public boolean hasUpperRight() {
		return (_upperRight != null);
	}

	/* (non-Javadoc)
	 * @see net.scilingo.board.tictactoe.Player#isGameOver()
	 */
	@Override
	public boolean isGameOver() {
		
		// if GameState is already not null return
		if (AbstractTicTacToePlayer._gameState != null)
			return true;
		
		AbstractTicTacToePlayer._gameState = TicTacToePlayerState.determineState(this);
		
		return (AbstractTicTacToePlayer._gameState != null);
	}

	public static AbstractGameState getGameState() {
		return AbstractTicTacToePlayer._gameState;
	}

	/* (non-Javadoc)
	 * @see net.scilingo.board.tictactoe.Player#getMoveHistory()
	 */
	@Override
	public String getMoveHistory(String format) {

		StringBuilder sb = new StringBuilder();

		for (Move m : _moves) {
			sb.append(m.toString()).append(" ").append(m.madeBy().toString()).append(format);
		}

		return sb.toString();
	}
	
	@Override
	public String getMoveHistory() {
		return getMoveHistory(Constants.NEWLINE);
	}

	@Override
	public String toString() {
		return this._name;
	}

	public static int getNumberOfPlayers() {
		return _playerCount;
	}

	public static int getNumberOfMoves() {
		return _currentNumOfMovesForAllPlayersInGame;
	}

	protected void reset() {
		
		// Reset cells
		this._upperLeft = null;
		this._upperMiddle = null;
		this._upperRight = null;

		this._middleLeft = null;
		this._middleMiddle = null;
		this._middleRight = null;

		this._lowerLeft = null;
		this._lowerMiddle = null;
		this._lowerRight = null;

		// Reset Moves
		this._moves.clear();
	}

	@Override
	protected void finalize() throws Throwable {
		_playerCount--;
		super.finalize();
	}
}
