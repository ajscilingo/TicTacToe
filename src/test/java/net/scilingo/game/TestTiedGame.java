package net.scilingo.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.scilingo.board.Constants;
import net.scilingo.board.tictactoe.TicTacToeCellSelection;
import net.scilingo.board.tictactoe.AbstractTicTacToePlayer;
import net.scilingo.board.tictactoe.TicTacToeGameBoard;

public class TestTiedGame {

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
		assertEquals(net.scilingo.game.tictactoe.state.TiedGame.class,  AbstractTicTacToePlayer.getGameState().getClass());
	}
	
	@Test
	public void TestTiedGameOutcome() {
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getUpperLeftCell());
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperMiddleCell());
		assertEquals(Constants.O_SYMBOL, ticTacToeGameBoard.getUpperMiddleCell());
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getUpperRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getUpperRightCell());
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleMiddleCell());
		assertEquals(Constants.O_SYMBOL, ticTacToeGameBoard.getMiddleMiddleCell());
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleLeftCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getMiddleLeftCell());
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getMiddleRightCell());
		assertEquals(Constants.O_SYMBOL, ticTacToeGameBoard.getMiddleRightCell());
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_MIDDLE);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerMiddleCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getLowerMiddleCell());
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_LEFT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerLeftCell());
		assertEquals(Constants.O_SYMBOL, ticTacToeGameBoard.getLowerLeftCell());
		
		ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_RIGHT);
		assertNotEquals(Constants.UNOCCUPIED_SPACE, ticTacToeGameBoard.getLowerRightCell());
		assertEquals(Constants.X_SYMBOL, ticTacToeGameBoard.getLowerRightCell());
		
	}
	
}
