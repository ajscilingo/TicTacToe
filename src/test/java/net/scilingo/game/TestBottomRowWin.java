package net.scilingo.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.scilingo.board.Cell;
import net.scilingo.board.Constants;
import net.scilingo.board.Player;

public class TestBottomRowWin {
	private static Game ticTacToeGame;
	
	@BeforeClass
	public static void setup() {
		ticTacToeGame = new Game();
	}
	
	@AfterClass
	public static void after() {
		assertTrue(ticTacToeGame.isGameOver());
		assertEquals(net.scilingo.board.state.BottomRowWin.class, Player.getGameState().getClass());
	}
	
	@Test
	public void TestMakeMoveLowerLeft() {
		
		ticTacToeGame.makeMove(Cell.LOWER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getLowerLeftCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(Cell.LOWER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getLowerLeftCell());
	}
	
	@Test
	public void TestMakeMoveLowerMiddle() {
		
		ticTacToeGame.makeMove(Cell.LOWER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getLowerMiddleCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(Cell.LOWER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getLowerMiddleCell());
	}
	
	@Test
	public void TestMakeMoveLowerRight() {
		
		ticTacToeGame.makeMove(Cell.LOWER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getLowerRightCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(Cell.LOWER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getLowerRightCell());
	}
}
