package net.scilingo.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.scilingo.board.Constants;
import net.scilingo.board.tictactoe.TicTacToeCellSelection;
import net.scilingo.board.tictactoe.TicTacToePlayer;
import net.scilingo.board.tictactoe.TicTacToeGameBoard;

public class TestRightDiagonalWin {

	private static Game ticTacToeGame;
	private static TicTacToeGameBoard ticTacToeGameBoard;
	
	@BeforeClass
	public static void setup() {
		ticTacToeGame = new TicTacToeGame();
		ticTacToeGameBoard = (TicTacToeGameBoard) ticTacToeGame.getGameBoard();
	}
	
	@AfterClass
	public static void after() {
		assertEquals(net.scilingo.game.tictactoe.state.RightDiagonalWin.class,  TicTacToePlayer.getGameState().getClass());
	}
	
	@Test
	public void TestMakeMoveUpperLeft() {
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getUpperLeftCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getUpperLeftCell());
	}
	
	@Test
	public void TestMakeMoveMiddleMiddle() {
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getMiddleMiddleCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getMiddleMiddleCell());
	}
	
	@Test
	public void TestMakeMoveLowerRight() {
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getLowerRightCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getLowerRightCell());
	}
	
}
