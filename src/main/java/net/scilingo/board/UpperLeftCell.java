package net.scilingo.board;

public interface UpperLeftCell extends CellSelection {

	public CellSelection getRightCell();
	public CellSelection getBottomRightCell();
	public CellSelection getBottomCell();
}
