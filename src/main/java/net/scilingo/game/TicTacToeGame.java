package net.scilingo.game;

import java.util.Scanner;

import net.scilingo.board.*;
import net.scilingo.board.tictactoe.*;
import net.scilingo.game.tictactoe.state.AbstractGameState;
import net.scilingo.game.tictactoe.state.ToHtml;
import net.scilingo.game.tictactoe.state.Winnable;
import net.scilingo.menu.Menu;

public class TicTacToeGame implements Game {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1401219477193635111L;
	private boolean gameOver;
	protected TicTacToePlayer currentPlayer;
	protected TicTacToePlayer player1;
	protected TicTacToePlayer player2;
	protected TicTacToePlayer playerHuman;
	protected TicTacToePlayer playerComputer;
	protected TicTacToeGameBoard gameBoard;
	protected Menu playerMenu;
	protected Menu moveMenu;
	
	public TicTacToeGame(){
		gameBoard = TicTacToeGameFactory.generateGameBoard();
		player1 = TicTacToeGameFactory.generatePlayerOne();
		player2 = TicTacToeGameFactory.generatePlayerTwo();
		playerHuman = null;
		playerComputer = null;
		gameOver = false;
		currentPlayer = player1;
		// create player 1 / player 2 menu selection
		playerMenu = TicTacToeGameFactory.generatePlayerMenu();
		// move menu selection
		moveMenu = TicTacToeGameFactory.generateMoveMenu();
	}
	
	public TicTacToeGame(boolean humanPlayer)
	{
		this();
		
		if(!humanPlayer) {
			playerComputer = TicTacToeGameFactory.generatePlayerComputer();
			player2 = playerComputer;
			
		}
		else {
			playerHuman = player2;
		}
		
	}
	
	public void determinePlayerTwo(Scanner sc) {
		while(player2 == null) {
			showPlayerMenu();
			
			try {
				// sc.nextInt() is taking in either 1 for 1 Player or 2 for 2 Player
				switch(sc.nextInt()) {
					case Constants.TWO_PLAYER :
						playerHuman = TicTacToeGameFactory.generatePlayerTwo();
						player2 = playerHuman;
						break;
					case Constants.ONE_PLAYER:
						playerComputer = TicTacToeGameFactory.generatePlayerComputer();
						player2 = playerComputer;
						break;
					default:
						System.out.println(Constants.ONE_OR_TWO_PLAYERS_MSG);
						break;
				}
			}
			catch(Exception e){
				System.out.println(Constants.INVALID_PLAYER_SELECTION_MSG);
				sc.next();
			}
		}
		
	}
	
	/* (non-Javadoc)
	 * @see net.scilingo.game.Game#getCurrentPlayer()
	 */
	@Override
	public TicTacToePlayer getCurrentPlayer(){
		if(currentPlayer == null)
			return player1;
		
		if(currentPlayer.equals(player1))
			return player2;
		else
			return player1;
	}
	
	public TicTacToePlayerComputer getComputerPlayer() {
		if(player2.equals(playerComputer))
			return (TicTacToePlayerComputer) playerComputer;
		else
			return null;
	}
	
	/* (non-Javadoc)
	 * @see net.scilingo.game.Game#play()
	 */
	@Override
	public Game play(Scanner sc){
		
		// set _player2 to null again for determining what it should be
		player2 = null;
		determinePlayerTwo(sc);
		
		while(!isGameOver()){
			
			if( currentPlayer.equals(player1) || currentPlayer.equals(playerHuman) )
			{
				
				showMoveMenu();
				
				try {
					makeMove(TicTacToeCellSelection.values()[sc.nextInt()]);
				}
				catch(Exception e){
					// prevent user from changing on exception
					currentPlayer = getCurrentPlayer();
					sc.nextLine();
				}
			}
			else if(currentPlayer.equals(playerComputer)) {
				
				TicTacToePlayerComputer computerPlayer = (TicTacToePlayerComputer) playerComputer;
				
				try {
					while(makeMove(computerPlayer.getNextMove()) == false){
						System.out.println("Space Already Occupied Trying Again");
						currentPlayer = getCurrentPlayer();
					}
				}
				catch(Exception e){
					System.err.println(e.getMessage());
				}
			}
		
		}
		
		if(playAgain(sc)) {
			return new TicTacToeGame();
		}
		sc.close();
		return null;
	}
	
	/* (non-Javadoc)
	 * @see net.scilingo.game.Game#checkForWinOrTie()
	 */
	@Override
	public void checkForWin(){
	
		if(currentPlayer.isGameOver()){
			System.out.println(AbstractTicTacToePlayer.getGameState());
			gameOver =  true;
		}
			
	}
	
	public String getGameState(){
		
		AbstractGameState gameState = AbstractTicTacToePlayer.getGameState();
		
		if(gameState != null)
			return ((Winnable)gameState).winnerMessage();
		else
			return "";
	}
	
	public String getGameStateHTML() {

		AbstractGameState gameState = AbstractTicTacToePlayer.getGameState();
		
		if(gameState != null)
			return ((ToHtml)gameState).toHTML();
		else
			return "";
	}
	
	
	/* (non-Javadoc)
	 * @see net.scilingo.game.Game#isGameOver()
	 */
	@Override
	public boolean isGameOver() {
		return gameOver;
	}
	
	
	private void showBoard(){
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.print(this.gameBoard);
		System.out.println(" ");
		System.out.println(" ");
	}
	
	
	protected void showPlayerMenu() {
		System.out.println(this.playerMenu.display());
	}
	
	private void showMoveMenu(){
		
		StringBuilder sb = new StringBuilder();
		System.out.print(sb
		.append(currentPlayer)
		.append(" Make move #")
		.append(AbstractTicTacToePlayer.getNumberOfMoves() + 1)
		.append(Constants.NEWLINE)
		.append(moveMenu.display())
		.toString());
	}
	
	/* (non-Javadoc)
	 * @see net.scilingo.game.Game#playAgain(java.util.Scanner)
	 */
	@Override
	public boolean playAgain(Scanner sc) {
		String response = null;
		boolean stopLooping = false;

		while(!stopLooping) {
			System.out.println(Constants.PLAY_AGAIN_MSG);
			response = sc.next().toUpperCase();
			stopLooping = ( Constants.YES.equals(response) || Constants.Y.equals(response) || Constants.N.equals(response) || Constants.NO.equals(response) );
		}

		if(Constants.YES.equals(response) || Constants.Y.equals(response))
			return true;
		else 
			return false;
			
	}
	
	/* (non-Javadoc)
	 * @see net.scilingo.game.Game#makeMove(net.scilingo.board.tictactoe.TicTacToeCellSelection)
	 */
	@Override
	public boolean makeMove(TicTacToeCellSelection cellSelection){
		
		boolean moveSuccess = false;
		
		TicTacToeCellSelection ticTacToeCellSelection = cellSelection;
		
		if(!gameOver) {
			
			switch (ticTacToeCellSelection) {
				case UPPER_LEFT:
					moveSuccess = new MoveUpperLeft(this.gameBoard).move(this.currentPlayer, this.gameOver);
					break;
				case UPPER_MIDDLE: 
					moveSuccess = new MoveUpperMiddle(this.gameBoard).move(this.currentPlayer, this.gameOver);
					break;
				case UPPER_RIGHT: 
					moveSuccess = new MoveUpperRight(this.gameBoard).move(this.currentPlayer, this.gameOver);
					break;
				case MIDDLE_LEFT: 
					moveSuccess = new MoveMiddleLeft(this.gameBoard).move(this.currentPlayer, this.gameOver);
					break;
				case MIDDLE_MIDDLE: 
					moveSuccess = new MoveMiddleMiddle(this.gameBoard).move(this.currentPlayer, this.gameOver);
					break;
				case MIDDLE_RIGHT: 
					moveSuccess = new MoveMiddleRight(this.gameBoard).move(this.currentPlayer, this.gameOver);
					break;
				case LOWER_LEFT: 
					moveSuccess = new MoveLowerLeft(this.gameBoard).move(this.currentPlayer, this.gameOver);
					break;
				case LOWER_MIDDLE: 
					moveSuccess = new MoveLowerMiddle(this.gameBoard).move(this.currentPlayer, this.gameOver);
					break;
				case LOWER_RIGHT: 
					moveSuccess = new MoveLowerRight(this.gameBoard).move(this.currentPlayer, this.gameOver);
					break;
				default:
					break;
			}
			
			if(moveSuccess) {
				showBoard();
				checkForWin();
			}
			currentPlayer = getCurrentPlayer();
		}
		return moveSuccess;
	}

	@Override
	public AbstractGameBoard getGameBoard() {
		return gameBoard;
	}
}
