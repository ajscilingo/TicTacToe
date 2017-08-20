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
import net.scilingo.game.Game;

public class TestLeftDiagonalWin {
	
	private static Game ticTacToeGame;
	
	@BeforeClass
	public static void setup() {
		ticTacToeGame = new TicTacToeGame();
	}
	
	@AfterClass
	public static void after() {
		assertTrue(ticTacToeGame.isGameOver());
		assertEquals(net.scilingo.board.state.LeftDiagonalWin.class,  Player.getGameState().getClass());
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
	
	@Test
	public void TestMakeMoveMiddleMiddle() {
		
		ticTacToeGame.makeMove(Cell.MIDDLE_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getMiddleMiddleCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(Cell.MIDDLE_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getMiddleMiddleCell());
	}
	
	@Test
	public void TestMakeMoveUpperRight() {
		
		ticTacToeGame.makeMove(Cell.UPPER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getUpperRightCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(Cell.UPPER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getUpperRightCell());
	}
}
