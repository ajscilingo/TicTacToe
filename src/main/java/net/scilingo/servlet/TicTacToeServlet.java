package net.scilingo.servlet;

import javax.servlet.http.*;

import java.io.IOException;

import javax.servlet.*;

import net.scilingo.board.tictactoe.TicTacToeCellSelection;
import net.scilingo.board.tictactoe.TicTacToeGameBoard;
import net.scilingo.game.TicTacToeGame;

public class TicTacToeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 891251796134227260L;
	private static TicTacToeGame ticTacToeGame;
	private static TicTacToeGameBoard ticTacToeGameBoard;
	private String playAgainVisibilityStyle;
	private String numberOfPlayersVisibilityStyle;
	private boolean humanPlayerTwo;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String move = request.getParameter("move");
		playAgainVisibilityStyle = "";
		numberOfPlayersVisibilityStyle = "visibility: hidden !important;";
		
		if (ticTacToeGame == null) {
			
			humanPlayerTwo = Boolean.parseBoolean(request.getParameter("humanPlayer"));
			
			if(humanPlayerTwo)
				ticTacToeGame = new TicTacToeGame();
			else
				ticTacToeGame = new TicTacToeGame(false);
			ticTacToeGameBoard = (TicTacToeGameBoard) ticTacToeGame.getGameBoard();
		} else {
			if (ticTacToeGame.isGameOver()) {
				
				humanPlayerTwo = Boolean.parseBoolean(request.getParameter("humanPlayer"));
				
				if(humanPlayerTwo)
					ticTacToeGame = new TicTacToeGame();
				else
					ticTacToeGame = new TicTacToeGame(false);
				ticTacToeGameBoard = (TicTacToeGameBoard) ticTacToeGame.getGameBoard();
				move = null;
			}
		}

		if (move != null) {
			switch (move) {

			case "moveUpperLeft":
				ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_LEFT);
				break;
			case "moveUpperMiddle":
				ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_MIDDLE);
				break;
			case "moveUpperRight":
				ticTacToeGame.makeMove(TicTacToeCellSelection.UPPER_RIGHT);
				break;
			case "moveMiddleLeft":
				ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_LEFT);
				break;
			case "moveMiddleMiddle":
				ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_MIDDLE);
				break;
			case "moveMiddleRight":
				ticTacToeGame.makeMove(TicTacToeCellSelection.MIDDLE_RIGHT);
				break;
			case "moveLowerLeft":
				ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_LEFT);
				break;
			case "moveLowerMiddle":
				ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_MIDDLE);
				break;
			case "moveLowerRight":
				ticTacToeGame.makeMove(TicTacToeCellSelection.LOWER_RIGHT);
				break;
			default:
				break;
			}
			
			if(!humanPlayerTwo && !ticTacToeGame.isGameOver())
				ticTacToeGame.makeMove(ticTacToeGame.getComputerPlayer().getNextMove());
		}
		
		// check to see if game is over to show play again message
		if(ticTacToeGame.isGameOver())
			playAgainVisibilityStyle = "visibility: visible !important;";

		request.setAttribute("board", ticTacToeGameBoard);
		request.setAttribute("game", ticTacToeGame);
		request.setAttribute("playAgainVisibilityStyle", playAgainVisibilityStyle);
		request.setAttribute("numberOfPlayersVisibilityStyle", numberOfPlayersVisibilityStyle);

		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
