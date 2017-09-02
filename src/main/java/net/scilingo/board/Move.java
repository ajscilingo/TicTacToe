package net.scilingo.board;

public interface Move {

	public boolean move(Player player, boolean gameOver);
	public Player madeBy();
	public String getDisplayName();
	
}
