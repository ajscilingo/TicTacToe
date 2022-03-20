package net.scilingo.board.tictactoe;

import net.scilingo.menu.Menu;
import net.scilingo.menu.BaseMenu;
import net.scilingo.menu.MenuItem;
import net.scilingo.menu.NumericMenuItem;
import net.scilingo.menu.StringMenuItem;

public class TicTacToeGameFactory {
	
	private static AbstractTicTacToePlayer playerOne;
	private static AbstractTicTacToePlayer playerTwo;
	private static AbstractTicTacToePlayer playerComputer;
	private static TicTacToeGameBoard ticTacToeGameBoard;
	private static Menu playerMenu;
	private static Menu moveMenu;
	
	public static AbstractTicTacToePlayer generatePlayerOne() {
		// generate the first time otherwise mutate instance
		if(playerOne == null) {
			
			playerOne = new TicTacToePlayerOne();
		
			if(playerComputer == null) {
				playerComputer = new TicTacToePlayerComputer();
				((TicTacToePlayerOne) playerOne).setComputerOpponent((TicTacToePlayerComputer) playerComputer);
			}
			
		}
		else {
			playerOne.reset();
			playerComputer.reset();
		}
		
		return playerOne;
	}
	
	public static AbstractTicTacToePlayer generatePlayerTwo() {
		// generate the first time otherwise mutate instance
		if(playerTwo == null)
			playerTwo = new TicTacToePlayerTwo();
		else
			playerTwo.reset();
		
		return playerTwo;
	}
	
	public static AbstractTicTacToePlayer generatePlayerComputer() {
		
		if( ((TicTacToePlayerOne) playerOne).getComputerOpponent() != null) {
			((TicTacToePlayerOne) playerOne).getComputerOpponent().reset();
			return  ((TicTacToePlayerOne) playerOne).getComputerOpponent();
		}
		else {
			playerComputer = new TicTacToePlayerComputer();
			((TicTacToePlayerOne) playerOne).setComputerOpponent((TicTacToePlayerComputer) playerComputer);
			return playerComputer;
		}
	}
	
	public static TicTacToeGameBoard generateGameBoard() {
		if(ticTacToeGameBoard == null)
			ticTacToeGameBoard = new TicTacToeGameBoard();
		else
			ticTacToeGameBoard.clearBoard();
		return ticTacToeGameBoard;
	}
	
	public static Menu generatePlayerMenu() {
		
		if(playerMenu == null) {
			playerMenu = new BaseMenu("Choose Number Of Players:");
			MenuItem onePlayerMenuItem = new NumericMenuItem("1 Player");
			MenuItem twoPlayerMenuItem = new NumericMenuItem("2 Player");
			playerMenu.addMenuItem(onePlayerMenuItem);
			playerMenu.addMenuItem(twoPlayerMenuItem);
		}
		
		return playerMenu;
	}
	
	public static Menu generateMoveMenu() {
		if(moveMenu == null) {
			moveMenu = new BaseMenu();
			MenuItem upperLeftMenuItem = new StringMenuItem(
					Integer.toString(TicTacToeCellSelection.UPPER_LEFT.ordinal()), 
						"Move To Upper Left");
			MenuItem upperCenterMenuItem = new StringMenuItem(
					Integer.toString(TicTacToeCellSelection.UPPER_MIDDLE.ordinal()), 
						"Move To Upper Center");
			MenuItem upperRightMenuItem = new StringMenuItem(
					Integer.toString(TicTacToeCellSelection.UPPER_RIGHT.ordinal()), 
						"Move To Upper Right");
			MenuItem centerLeftMenuItem = new StringMenuItem(
					Integer.toString(TicTacToeCellSelection.MIDDLE_LEFT.ordinal()), 
						"Move To Center Left");
			MenuItem centerMenuItem = new StringMenuItem(
					Integer.toString(TicTacToeCellSelection.MIDDLE_MIDDLE.ordinal()), 
						"Move To Center");
			MenuItem centerRightMenuItem = new StringMenuItem(
					Integer.toString(TicTacToeCellSelection.MIDDLE_RIGHT.ordinal()), 
						"Move To Center Right");
			MenuItem lowerLeftMenuItem = new StringMenuItem(
					Integer.toString(TicTacToeCellSelection.LOWER_LEFT.ordinal()), 
						"Move To Lower Left");
			MenuItem lowerCenterMenuItem = new StringMenuItem(
					Integer.toString(TicTacToeCellSelection.LOWER_MIDDLE.ordinal()), 
						"Move To Lower Center");
			MenuItem lowerRightMenuItem = new StringMenuItem(
					Integer.toString(TicTacToeCellSelection.LOWER_RIGHT.ordinal()), 
						"Move To Lower Right");
			moveMenu.addMenuItem(upperLeftMenuItem);
			moveMenu.addMenuItem(upperCenterMenuItem);
			moveMenu.addMenuItem(upperRightMenuItem);
			moveMenu.addMenuItem(centerLeftMenuItem);
			moveMenu.addMenuItem(centerMenuItem);
			moveMenu.addMenuItem(centerRightMenuItem);
			moveMenu.addMenuItem(lowerLeftMenuItem);
			moveMenu.addMenuItem(lowerCenterMenuItem);
			moveMenu.addMenuItem(lowerRightMenuItem);
		}
		return moveMenu;
	}
}
