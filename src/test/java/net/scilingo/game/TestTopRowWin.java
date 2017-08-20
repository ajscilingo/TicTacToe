package net.scilingo.game;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.scilingo.board.Cell;
import net.scilingo.board.Constants;
import net.scilingo.board.Player;

public class TestTopRowWin {

	private static Game ticTacToeGame;
	
	@BeforeClass
	public static void setup() {
		ticTacToeGame = new TicTacToeGame();
	}
	
	@AfterClass
	public static void after() {
		assertEquals(net.scilingo.board.state.TopRowWin.class,  Player.getGameState().getClass());
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
	public void TestMakeMoveUpperMiddle() {
		
		ticTacToeGame.makeMove(Cell.UPPER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getUpperMiddleCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(Cell.UPPER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getUpperMiddleCell());
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
