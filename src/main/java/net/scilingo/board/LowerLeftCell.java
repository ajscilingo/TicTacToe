package net.scilingo.board;

public interface LowerLeftCell extends CellSelection {

	public CellSelection getRightCell();
	public CellSelection getTopRightCell();
	public CellSelection getTopCell();
	
}
