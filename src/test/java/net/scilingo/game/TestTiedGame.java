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
		ticTacToeGame = new TicTacToeGame();
	}
	
	@AfterClass
	public static void after() {
		assertTrue(ticTacToeGame.isGameOver());
		assertEquals(net.scilingo.board.state.TiedGame.class,  Player.getGameState().getClass());
	}
	
	@Test
	public void TestTiedGameOutcome() {
		
		ticTacToeGame.makeMove(Cell.UPPER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getUpperLeftCell());
		
		ticTacToeGame.makeMove(Cell.UPPER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperMiddleCell());
		assertEquals(Constants.O_SYMBOL, ticTacToeGame.getGameBoard().getUpperMiddleCell());
		
		ticTacToeGame.makeMove(Cell.UPPER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getUpperRightCell());
		
		ticTacToeGame.makeMove(Cell.MIDDLE_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleMiddleCell());
		assertEquals(Constants.O_SYMBOL, ticTacToeGame.getGameBoard().getMiddleMiddleCell());
		
		ticTacToeGame.makeMove(Cell.MIDDLE_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getMiddleLeftCell());
		
		ticTacToeGame.makeMove(Cell.MIDDLE_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleRightCell());
		assertEquals(Constants.O_SYMBOL, ticTacToeGame.getGameBoard().getMiddleRightCell());
		
		ticTacToeGame.makeMove(Cell.LOWER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getLowerMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getLowerMiddleCell());
		
		ticTacToeGame.makeMove(Cell.LOWER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getLowerLeftCell());
		assertEquals(Constants.O_SYMBOL, ticTacToeGame.getGameBoard().getLowerLeftCell());
		
		ticTacToeGame.makeMove(Cell.LOWER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getLowerRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGame.getGameBoard().getLowerRightCell());
		
	}
	
}
