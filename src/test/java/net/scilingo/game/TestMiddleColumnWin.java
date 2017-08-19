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

public class TestMiddleColumnWin {

private static Game ticTacToeGame;
	
	@BeforeClass
	public static void setup() {
		ticTacToeGame = new Game();
	}
	
	@AfterClass
	public static void after() {
		assertTrue(ticTacToeGame.isGameOver());
		assertEquals(net.scilingo.board.state.MiddleColumnWin.class,  Player.getGameState().getClass());
	}
	
	@Test
	public void TestMakeMoveUpperMiddle() {
		
		ticTacToeGame.makeMove(Cell.UPPER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getUpperMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getUpperMiddleCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(Cell.UPPER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getUpperMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getUpperMiddleCell());
	}
	
	@Test
	public void TestMakeMoveMiddleMiddle() {
		
		ticTacToeGame.makeMove(Cell.MIDDLE_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getMiddleMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getMiddleMiddleCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(Cell.MIDDLE_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getMiddleMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getMiddleMiddleCell());
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
	
}
