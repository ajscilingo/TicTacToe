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

public class TestLeftColumnWin {

private static Game ticTacToeGame;
	
	@BeforeClass
	public static void setup() {
		ticTacToeGame = new TicTacToeGame();
	}
	
	@AfterClass
	public static void after() {
		assertTrue(ticTacToeGame.isGameOver());
		assertEquals(net.scilingo.board.state.LeftColumnWin.class,  Player.getGameState().getClass());
	}
	
	@Test
	public void TestMakeMoveUpperLeft() {
		
		ticTacToeGame.makeMove(Cell.UPPER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getUpperLeftCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(Cell.UPPER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getUpperLeftCell());
	}
	
	@Test
	public void TestMakeMoveMiddleLeft() {
		
		ticTacToeGame.makeMove(Cell.MIDDLE_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getMiddleLeftCell());

		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(Cell.MIDDLE_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getMiddleLeftCell());
	}
	
	@Test
	public void TestMakeMoveLowerLeft() {
		
		ticTacToeGame.makeMove(Cell.LOWER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getLowerLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getLowerLeftCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(Cell.LOWER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getLowerLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getLowerLeftCell());
	}
	
}
