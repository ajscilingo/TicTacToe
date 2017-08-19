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

public class TestTiedGame {

private static Game ticTacToeGame;
	
	@BeforeClass
	public static void setup() {
		ticTacToeGame = new Game();
	}
	
	@AfterClass
	public static void after() {
		assertTrue(ticTacToeGame.isGameOver());
		assertEquals(net.scilingo.board.state.TiedGame.class,  Player.getGameState().getClass());
	}
	
	@Test
	public void TestTiedGameOutcome() {
		
		ticTacToeGame.makeMove(Cell.UPPER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getUpperLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getUpperLeftCell());
		
		ticTacToeGame.makeMove(Cell.UPPER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getUpperMiddleCell());
		assertEquals(Constants.O_SYMBOL, ticTacToeGame._gameBoard.getUpperMiddleCell());
		
		ticTacToeGame.makeMove(Cell.UPPER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getUpperRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getUpperRightCell());
		
		ticTacToeGame.makeMove(Cell.MIDDLE_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getMiddleMiddleCell());
		assertEquals(Constants.O_SYMBOL, ticTacToeGame._gameBoard.getMiddleMiddleCell());
		
		ticTacToeGame.makeMove(Cell.MIDDLE_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getMiddleLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getMiddleLeftCell());
		
		ticTacToeGame.makeMove(Cell.MIDDLE_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getMiddleRightCell());
		assertEquals(Constants.O_SYMBOL, ticTacToeGame._gameBoard.getMiddleRightCell());
		
		ticTacToeGame.makeMove(Cell.LOWER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getLowerMiddleCell());
		
		ticTacToeGame.makeMove(Cell.LOWER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerLeftCell());
		assertEquals(Constants.O_SYMBOL, ticTacToeGame._gameBoard.getLowerLeftCell());
		
		ticTacToeGame.makeMove(Cell.LOWER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame._gameBoard.getLowerRightCell());
		
	}
	
}
