package net.scilingo.board;

public interface LowerCell extends CellSelection {

	public CellSelection getRightCell();
	public CellSelection getLeftCell();
	public CellSelection getTopRightCell();
	public CellSelection getTopLeftCell();
	public CellSelection getTopCell();
	
}
