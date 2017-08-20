package net.scilingo.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.scilingo.board.Cell;
import net.scilingo.board.Constants;
import net.scilingo.board.Player;

public class TestRightDiagonalWin {

private static Game ticTacToeGame;
	
	@BeforeClass
	public static void setup() {
		ticTacToeGame = new TicTacToeGame();
	}
	
	@AfterClass
	public static void after() {
		assertEquals(net.scilingo.board.state.RightDiagonalWin.class,  Player.getGameState().getClass());
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
	public void TestMakeMoveLowerRight() {
		
		ticTacToeGame.makeMove(Cell.LOWER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getLowerRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getLowerRightCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(Cell.LOWER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getLowerRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getLowerRightCell());
	}
	
}
