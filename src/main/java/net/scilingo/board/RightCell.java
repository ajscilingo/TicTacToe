package net.scilingo.board;

public interface RightCell extends CellSelection {

	public CellSelection getTopCell();
	public CellSelection getTopLeftCell();
	public CellSelection getLeftCell();
	public CellSelection getBottomLeftCell();
	public CellSelection getBottomCell();
}
