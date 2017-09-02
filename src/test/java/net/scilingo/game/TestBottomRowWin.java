package net.scilingo.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.scilingo.board.Constants;
import net.scilingo.board.tictactoe.TicTacToeCellSelection;
import net.scilingo.board.tictactoe.TicTacToePlayer;
import net.scilingo.board.tictactoe.TicTacToeGameBoard;

public class TestBottomRowWin {
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
		assertEquals(net.scilingo.game.tictactoe.state.BottomRowWin.class, TicTacToePlayer.getGameState().getClass());
	}
	
	@Test
	public void TestMakeMoveLowerLeft() {
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getLowerLeftCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getLowerLeftCell());
	}
	
	@Test
	public void TestMakeMoveLowerMiddle() {
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getLowerMiddleCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getLowerMiddleCell());
	}
	
	@Test
	public void TestMakeMoveLowerRight() {
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getLowerRightCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getLowerRightCell());
	}
}
