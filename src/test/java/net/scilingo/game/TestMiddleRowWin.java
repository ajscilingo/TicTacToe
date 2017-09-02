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

public class TestMiddleRowWin {

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
		assertEquals(net.scilingo.game.tictactoe.state.MiddleRowWin.class, TicTacToePlayer.getGameState().getClass());
	}
	
	@Test
	public void TestMakeMoveMiddleLeft() {
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getMiddleLeftCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getMiddleLeftCell());
	}
	
	@Test
	public void TestMakeMoveMiddleMiddle() {
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getMiddleMiddleCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getMiddleMiddleCell());
	}
	
	@Test
	public void TestMakeMoveMiddleRight() {
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getMiddleRightCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getMiddleRightCell());
	}
}
