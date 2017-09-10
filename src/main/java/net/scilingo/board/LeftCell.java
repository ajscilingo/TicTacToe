package net.scilingo.board;

public interface LeftCell extends CellSelection {

	public CellSelection getTopCell();
	public CellSelection getTopRightCell();
	public CellSelection getRightCell();
	public CellSelection getBottomRightCell();
	public CellSelection getBottomCell();
	
}
