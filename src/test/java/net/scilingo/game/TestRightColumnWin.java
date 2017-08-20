package net.scilingo.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.scilingo.board.Cell;
import net.scilingo.board.Constants;
import net.scilingo.board.Player;

public class TestRightColumnWin {

private static Game ticTacToeGame;
	
	@BeforeClass
	public static void setup() {
		ticTacToeGame = new TicTacToeGame();
	}
	
	@AfterClass
	public static void after() {
		assertEquals(net.scilingo.board.state.RightColumnWin.class,  Player.getGameState().getClass());
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
	
	@Test
	public void TestMakeMoveMiddleRight() {
		
		ticTacToeGame.makeMove(Cell.MIDDLE_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getMiddleRightCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(Cell.MIDDLE_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getMiddleRightCell());
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
