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
		ticTacToeGame = new Game();
	}
	
	
	@AfterClass
	public static void after() {
		assertTrue(ticTacToeGame.isGameOver());
	}
	
	@Test
	public void TestMakeMoveUpperLeft() {
		if(ticTacToeGame.makeMove(Cell.UPPER_LEFT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getUpperLeftCell());
			assertTrue(ticTacToeGame._gameBoard.getUpperLeftCell() == Constants.X_SYMBOL || ticTacToeGame._gameBoard.getUpperLeftCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getUpperLeftCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveUpperMiddle() {
		if(ticTacToeGame.makeMove(Cell.UPPER_MIDDLE)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getUpperMiddleCell());
			assertTrue(ticTacToeGame._gameBoard.getUpperMiddleCell() == Constants.X_SYMBOL || ticTacToeGame._gameBoard.getUpperMiddleCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getUpperMiddleCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveUpperRight() {
		if(ticTacToeGame.makeMove(Cell.UPPER_RIGHT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getUpperRightCell());
			assertTrue(ticTacToeGame._gameBoard.getUpperRightCell() == Constants.X_SYMBOL || ticTacToeGame._gameBoard.getUpperRightCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getUpperRightCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
			
	}
	
	@Test
	public void TestMakeMoveMiddleLeft() {
		if(ticTacToeGame.makeMove(Cell.MIDDLE_LEFT)){
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getMiddleLeftCell());
			assertTrue(ticTacToeGame._gameBoard.getMiddleLeftCell() == Constants.X_SYMBOL || ticTacToeGame._gameBoard.getMiddleLeftCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getMiddleLeftCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveMiddleMiddle() {
		if(ticTacToeGame.makeMove(Cell.MIDDLE_MIDDLE)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getMiddleMiddleCell());
			assertTrue(ticTacToeGame._gameBoard.getMiddleMiddleCell() == Constants.X_SYMBOL || ticTacToeGame._gameBoard.getMiddleMiddleCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getMiddleMiddleCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveMiddleRight() {
		if(ticTacToeGame.makeMove(Cell.MIDDLE_RIGHT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getMiddleRightCell());
			assertTrue(ticTacToeGame._gameBoard.getMiddleRightCell() == Constants.X_SYMBOL || ticTacToeGame._gameBoard.getMiddleRightCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getMiddleRightCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveLowerLeft() {
		if(ticTacToeGame.makeMove(Cell.LOWER_LEFT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerLeftCell());
			assertTrue(ticTacToeGame._gameBoard.getLowerLeftCell() == Constants.X_SYMBOL || ticTacToeGame._gameBoard.getLowerLeftCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerLeftCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveLowerMiddle() {
		if(ticTacToeGame.makeMove(Cell.LOWER_MIDDLE)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerMiddleCell());
			assertTrue(ticTacToeGame._gameBoard.getLowerMiddleCell() == Constants.X_SYMBOL || ticTacToeGame._gameBoard.getLowerMiddleCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerMiddleCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}

	@Test
	public void TestMakeMoveLowerRight() {
		if(ticTacToeGame.makeMove(Cell.LOWER_RIGHT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerRightCell());
			assertTrue(ticTacToeGame._gameBoard.getLowerRightCell() == Constants.X_SYMBOL || ticTacToeGame._gameBoard.getLowerRightCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGame._gameBoard.getLowerRightCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
}
