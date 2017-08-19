package net.scilingo.board;

public class GameFactory {

	public static Player generatePlayerOne() {
		return Player.generatePlayerOne();
	}
	
	public static Player generatePlayerTwo() {
		return Player.generatePlayerTwo();
	}
	
	public static Board generateBoard() {
		return new Board();
	}
}
