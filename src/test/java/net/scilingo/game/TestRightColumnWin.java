package net.scilingo.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.scilingo.board.Constants;
import net.scilingo.board.tictactoe.TicTacToeCellSelection;
import net.scilingo.board.tictactoe.AbstractTicTacToePlayer;
import net.scilingo.board.tictactoe.TicTacToeGameBoard;

public class TestRightColumnWin {

	private static Game ticTacToeGame;
	private static TicTacToeGameBoard ticTacToeGameBoard;
	
	@BeforeClass
	public static void setup() {
		ticTacToeGame = new TicTacToeGame();
		ticTacToeGameBoard = (TicTacToeGameBoard) ticTacToeGame.getGameBoard();
		
	}
	
	@AfterClass
	public static void after() {
		assertEquals(net.scilingo.game.tictactoe.state.RightColumnWin.class,  AbstractTicTacToePlayer.getGameState().getClass());
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
