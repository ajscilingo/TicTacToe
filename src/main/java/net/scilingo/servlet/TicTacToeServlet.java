package net.scilingo.servlet;

import javax.servlet.http.*;

import java.io.IOException;

import javax.servlet.*;

import net.scilingo.board.tictactoe.TicTacToeCellSelection;
import net.scilingo.board.tictactoe.TicTacToeGameBoard;
import net.scilingo.game.TicTacToeGame;

public class TicTacToeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 891251796134227260L;
	private static TicTacToeGame ticTacToeGame;
	private static TicTacToeGameBoard ticTacToeGameBoard;

    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
    	
    	String move = request.getParameter("move");
    	
    	
    	if(ticTacToeGame == null){
    		ticTacToeGame = new TicTacToeGame();
    		ticTacToeGameBoard = (TicTacToeGameBoard) ticTacToeGame.getGameBoard();
    	}
    	else
    	{
    		if(ticTacToeGame.isGameOver()){
    			ticTacToeGame = new TicTacToeGame();
    			ticTacToeGameBoard = (TicTacToeGameBoard) ticTacToeGame.getGameBoard();
    		}

    	}
    	
    if(move != null) {
	    	switch(move){
	    	
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
    }
    	
    	request.setAttribute("board", ticTacToeGameBoard);
    	request.setAttribute("game", ticTacToeGame);
    	
    	getServletContext()
    		.getRequestDispatcher("/index.jsp")
    		.forward(request, response);
    	
    }
    
    @Override
    protected void doGet(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
    	doPost(request, response);
    }
}
