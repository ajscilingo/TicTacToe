package net.scilingo.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.scilingo.board.tictactoe.TicTacToeCellSelection;
import net.scilingo.board.tictactoe.Constants;
import net.scilingo.board.tictactoe.TicTacToeGameBoard;

public class TestRandomGameOver {

	private static Game ticTacToeGame;
	private static TicTacToeGameBoard ticTacToeGameBoard;
	
	@BeforeClass
	public static void setup() {
		ticTacToeGame = new TicTacToeGame();
		ticTacToeGameBoard = (TicTacToeGameBoard) ticTacToeGame.getGameBoard();
	}
	
	
	@AfterClass
	public static void after() {
		assertTrue(ticTacToeGame.isGameOver());
	}
	
	@Test
	public void TestMakeMoveUpperLeft() {
		if(ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_LEFT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperLeftCell());
			assertTrue(ticTacToeGameBoard.getUpperLeftCell() == Constants.X_SYMBOL || ticTacToeGameBoard.getUpperLeftCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperLeftCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveUpperMiddle() {
		if(ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_MIDDLE)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperMiddleCell());
			assertTrue(ticTacToeGameBoard.getUpperMiddleCell() == Constants.X_SYMBOL || ticTacToeGameBoard.getUpperMiddleCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperMiddleCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveUpperRight() {
		if(ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_RIGHT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperRightCell());
			assertTrue(ticTacToeGameBoard.getUpperRightCell() == Constants.X_SYMBOL || ticTacToeGameBoard.getUpperRightCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperRightCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
			
	}
	
	@Test
	public void TestMakeMoveMiddleLeft() {
		if(ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_LEFT)){
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleLeftCell());
			assertTrue(ticTacToeGameBoard.getMiddleLeftCell() == Constants.X_SYMBOL || ticTacToeGameBoard.getMiddleLeftCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleLeftCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveMiddleMiddle() {
		if(ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_MIDDLE)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleMiddleCell());
			assertTrue(ticTacToeGameBoard.getMiddleMiddleCell() == Constants.X_SYMBOL || ticTacToeGameBoard.getMiddleMiddleCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleMiddleCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveMiddleRight() {
		if(ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_RIGHT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleRightCell());
			assertTrue(ticTacToeGameBoard.getMiddleRightCell() == Constants.X_SYMBOL || ticTacToeGameBoard.getMiddleRightCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleRightCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveLowerLeft() {
		if(ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_LEFT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerLeftCell());
			assertTrue(ticTacToeGameBoard.getLowerLeftCell() == Constants.X_SYMBOL || ticTacToeGameBoard.getLowerLeftCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerLeftCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
	
	@Test
	public void TestMakeMoveLowerMiddle() {
		if(ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_MIDDLE)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerMiddleCell());
			assertTrue(ticTacToeGameBoard.getLowerMiddleCell() == Constants.X_SYMBOL || ticTacToeGameBoard.getLowerMiddleCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerMiddleCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}

	@Test
	public void TestMakeMoveLowerRight() {
		if(ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_RIGHT)) {
			assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerRightCell());
			assertTrue(ticTacToeGameBoard.getLowerRightCell() == Constants.X_SYMBOL || ticTacToeGameBoard.getLowerRightCell() == Constants.O_SYMBOL);
		}
		else {
			assertEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerRightCell());
			assertTrue(ticTacToeGame.isGameOver());
		}
	}
}
