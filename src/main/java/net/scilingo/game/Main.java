package net.scilingo.game;

import java.util.Scanner;

public class Main {

	public static void main(String [] args){
		
		Scanner sc = new Scanner(System.in);
		
		Game g = new TicTacToeGame();
		while(g != null) {
			g = g.play(sc);
		}
		
//		Game g = new MinesweeperGame(10,10);
//		g.play();
		
		
	}
	
}
