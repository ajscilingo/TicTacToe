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
import net.scilingo.game.Game;

public class TestLeftDiagonalWin {
	
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
		assertEquals(net.scilingo.game.tictactoe.state.LeftDiagonalWin.class,  TicTacToePlayer.getGameState().getClass());
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
	public void TestMakeMoveUpperRight() {
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getUpperRightCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getUpperRightCell());
	}
}
