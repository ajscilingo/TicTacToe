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

public class TestMiddleColumnWin {

private static Game ticTacToeGame;
private static TicTacToeGameBoard ticTacToeGameBoard;
	
	@BeforeClass
	public static void setup() {
		ticTacToeGame = new TicTacToeGame();
		ticTacToeGameBoard = (TicTacToeGameBoard)ticTacToeGame.getGameBoard();
		
	}
	
	@AfterClass
	public static void after() {
		assertTrue(ticTacToeGame.isGameOver());
		assertEquals(net.scilingo.game.tictactoe.state.MiddleColumnWin.class,  TicTacToePlayer.getGameState().getClass());
	}
	
	@Test
	public void TestMakeMoveUpperMiddle() {
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getUpperMiddleCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getUpperMiddleCell());
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
	public void TestMakeMoveLowerMiddle() {
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getLowerMiddleCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getLowerMiddleCell());
	}
	
}
