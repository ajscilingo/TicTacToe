package net.scilingo.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.scilingo.board.Cell;
import net.scilingo.board.Constants;

public class TestRandomGameOver {

private static Game ticTacToeGame;
	
	@BeforeClass
	public static void setup() {
		ticTacToeGame = new TicTacToeGame();
	}
	
	
	@AfterClass
	public static void after() {
		assertTrue(ticTacToeGame.isGameOver());
	}
	
	@Test
	public void TestMakeMoveUpperLeft() {
		if(ticTacToeGame.makeMove(Cell.UPPER_LEFT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperLeftCell());
			assertTrue(ticTacToeGame.getGameBoard().getUpperLeftCell() == Constants.X_SYMBOL || ticTacToeGame.getGameBoard().getUpperLeftCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperLeftCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveUpperMiddle() {
		if(ticTacToeGame.makeMove(Cell.UPPER_MIDDLE)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperMiddleCell());
			assertTrue(ticTacToeGame.getGameBoard().getUpperMiddleCell() == Constants.X_SYMBOL || ticTacToeGame.getGameBoard().getUpperMiddleCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperMiddleCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveUpperRight() {
		if(ticTacToeGame.makeMove(Cell.UPPER_RIGHT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperRightCell());
			assertTrue(ticTacToeGame.getGameBoard().getUpperRightCell() == Constants.X_SYMBOL || ticTacToeGame.getGameBoard().getUpperRightCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getUpperRightCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
			
	}
	
	@Test
	public void TestMakeMoveMiddleLeft() {
		if(ticTacToeGame.makeMove(Cell.MIDDLE_LEFT)){
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleLeftCell());
			assertTrue(ticTacToeGame.getGameBoard().getMiddleLeftCell() == Constants.X_SYMBOL || ticTacToeGame.getGameBoard().getMiddleLeftCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleLeftCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveMiddleMiddle() {
		if(ticTacToeGame.makeMove(Cell.MIDDLE_MIDDLE)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleMiddleCell());
			assertTrue(ticTacToeGame.getGameBoard().getMiddleMiddleCell() == Constants.X_SYMBOL || ticTacToeGame.getGameBoard().getMiddleMiddleCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleMiddleCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveMiddleRight() {
		if(ticTacToeGame.makeMove(Cell.MIDDLE_RIGHT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleRightCell());
			assertTrue(ticTacToeGame.getGameBoard().getMiddleRightCell() == Constants.X_SYMBOL || ticTacToeGame.getGameBoard().getMiddleRightCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getMiddleRightCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveLowerLeft() {
		if(ticTacToeGame.makeMove(Cell.LOWER_LEFT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getLowerLeftCell());
			assertTrue(ticTacToeGame.getGameBoard().getLowerLeftCell() == Constants.X_SYMBOL || ticTacToeGame.getGameBoard().getLowerLeftCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getLowerLeftCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveLowerMiddle() {
		if(ticTacToeGame.makeMove(Cell.LOWER_MIDDLE)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getLowerMiddleCell());
			assertTrue(ticTacToeGame.getGameBoard().getLowerMiddleCell() == Constants.X_SYMBOL || ticTacToeGame.getGameBoard().getLowerMiddleCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getLowerMiddleCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}

	@Test
	public void TestMakeMoveLowerRight() {
		if(ticTacToeGame.makeMove(Cell.LOWER_RIGHT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getLowerRightCell());
			assertTrue(ticTacToeGame.getGameBoard().getLowerRightCell() == Constants.X_SYMBOL || ticTacToeGame.getGameBoard().getLowerRightCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame.getGameBoard().getLowerRightCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
}
