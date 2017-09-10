package net.scilingo.board;

public interface Cell extends CellSelection {

	public CellSelection getTopCell();
	public CellSelection getTopRightCell();
	public CellSelection getTopLeftCell();
	
	public CellSelection getRightCell();
	public CellSelection getLeftCell();
	
	public CellSelection getBottomCell();
	public CellSelection getBottomRightCell();
	public CellSelection getBottomLeftCell();
	
}
