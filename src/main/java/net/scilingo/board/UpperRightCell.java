package net.scilingo.board;

public interface UpperRightCell extends CellSelection {

	public CellSelection getLeftCell();
	public CellSelection getBottomLeftCell();
	public CellSelection getBottomCell();
	
}
