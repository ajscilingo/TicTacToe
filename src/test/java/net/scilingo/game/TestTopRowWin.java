package net.scilingo.game;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.scilingo.board.tictactoe.TicTacToeCellSelection;
import net.scilingo.board.tictactoe.Constants;
import net.scilingo.board.tictactoe.TicTacToePlayer;
import net.scilingo.board.tictactoe.TicTacToeGameBoard;

public class TestTopRowWin {

	private static Game ticTacToeGame;
	private static TicTacToeGameBoard ticTacToeGameBoard;
	
	@BeforeClass
	public static void setup() {
		ticTacToeGame = new TicTacToeGame();
		ticTacToeGameBoard = (TicTacToeGameBoard) ticTacToeGame.getGameBoard();	}
	
	@AfterClass
	public static void after() {
		assertEquals(net.scilingo.game.tictactoe.state.TopRowWin.class,  TicTacToePlayer.getGameState().getClass());
	}
	
	@Test
	public void TestMakeMoveUpperLeft() {
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getUpperLeftCell());
		
		// Repeat the action to prevent other player from making a conflicting move
		ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getUpperLeftCell());
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
