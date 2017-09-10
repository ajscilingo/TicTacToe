package net.scilingo.board;

public interface UpperCell extends CellSelection {
	
	public CellSelection getRightCell();
	public CellSelection getLeftCell();
	public CellSelection getBottomRightCell();
	public CellSelection getBottomLeftCell();
	public CellSelection getBottomCell();
	
}
