package net.scilingo.board.tictactoe;

import net.scilingo.menu.Menu;
import net.scilingo.menu.BaseMenu;
import net.scilingo.menu.MenuItem;
import net.scilingo.menu.NumericMenuItem;
import net.scilingo.menu.StringMenuItem;

public class TicTacToeGameFactory {
	
	private static AbstractTicTacToePlayer _playerOne;
	private static AbstractTicTacToePlayer _playerTwo;
	private static AbstractTicTacToePlayer _playerComputer;
	private static TicTacToeGameBoard _ticTacToeGameBoard;
	private static Menu _playerMenu;
	private static Menu _moveMenu;
	
	public static AbstractTicTacToePlayer generatePlayerOne() {
		// generate the first time otherwise mutate instance
		if(_playerOne == null) {
			
			_playerOne = new TicTacToePlayerOne();
		
			if(_playerComputer == null) {
				_playerComputer = new TicTacToePlayerComputer();
				((TicTacToePlayerOne)_playerOne).setComputerOpponent((TicTacToePlayerComputer)_playerComputer);
			}
			
		}
		else {
			_playerOne.reset();
			_playerComputer.reset();
		}
		
		return _playerOne;
	}
	
	public static AbstractTicTacToePlayer generatePlayerTwo() {
		// generate the first time otherwise mutate instance
		if(_playerTwo == null)
			_playerTwo = new TicTacToePlayerTwo();
		else
			_playerTwo.reset();
		
		return _playerTwo;
	}
	
	public static AbstractTicTacToePlayer generatePlayerComputer() {
		
		if( ((TicTacToePlayerOne)_playerOne).getComputerOpponent() != null) {
			((TicTacToePlayerOne)_playerOne).getComputerOpponent().reset();
			return  ((TicTacToePlayerOne)_playerOne).getComputerOpponent();
		}
		else {
			_playerComputer = new TicTacToePlayerComputer();
			((TicTacToePlayerOne)_playerOne).setComputerOpponent((TicTacToePlayerComputer)_playerComputer);
			return _playerComputer;
		}
	}
	
	public static TicTacToeGameBoard generateGameBoard() {
		if(_ticTacToeGameBoard == null)
			_ticTacToeGameBoard = new TicTacToeGameBoard();
		else
			_ticTacToeGameBoard.clearBoard();
		return _ticTacToeGameBoard;
	}
	
	public static Menu generatePlayerMenu() {
		
		if(_playerMenu == null) {
			_playerMenu = new BaseMenu("Choose Number Of Players:");
			MenuItem onePlayerMenuItem = new NumericMenuItem("1 Player");
			MenuItem twoPlayerMenuItem = new NumericMenuItem("2 Player");
			_playerMenu.addMenuItem(onePlayerMenuItem);
			_playerMenu.addMenuItem(twoPlayerMenuItem);
		}
		
		return _playerMenu;
	}
	
	public static Menu generateMoveMenu() {
		if(_moveMenu == null) {
			_moveMenu = new BaseMenu();
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
			_moveMenu.addMenuItem(upperLeftMenuItem);
			_moveMenu.addMenuItem(upperCenterMenuItem);
			_moveMenu.addMenuItem(upperRightMenuItem);
			_moveMenu.addMenuItem(centerLeftMenuItem);
			_moveMenu.addMenuItem(centerMenuItem);
			_moveMenu.addMenuItem(centerRightMenuItem);
			_moveMenu.addMenuItem(lowerLeftMenuItem);
			_moveMenu.addMenuItem(lowerCenterMenuItem);
			_moveMenu.addMenuItem(lowerRightMenuItem);
		}
		return _moveMenu;
	}
}
