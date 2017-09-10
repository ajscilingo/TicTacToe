package net.scilingo.board.minesweeper;

import net.scilingo.board.CellSelection;
import net.scilingo.board.UpperCell;

public class MinesweeperUpperBoundaryCell extends MinesweeperCellProperties implements UpperCell{

	private CellSelection _rightCell;
	private CellSelection _leftCell;
	private CellSelection _bottomRightCell;
	private CellSelection _bottomLeftCell;
	private CellSelection _bottomCell;
	
	MinesweeperUpperBoundaryCell(int column) throws MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException, MinesweeperCellIndexOutOfBoundsException, MinesweeperCellIllegalArgumentException {
		super(0,column);
		if(this.isUpperLeftCell() || this.isUpperRightCell())
			throw new MinesweeperCellIllegalArgumentException();
	}
	
	@Override
	public CellSelection getRightCell() {
		return _rightCell;
	}
	
	void setRightCell(CellSelection rightCell) {
		this._rightCell = rightCell;
		this._adjacentCells.add(this._rightCell);
	}

	@Override
	public CellSelection getLeftCell() {
		return _leftCell;
	}
	
	void setLeftCell(CellSelection leftCell) {
		this._leftCell = leftCell;
		this._adjacentCells.add(this._leftCell);
	}

	@Override
	public CellSelection getBottomRightCell() {
		return _bottomRightCell;
	}

	void setBottomRightCell(CellSelection bottomRightCell) {
		this._bottomRightCell = bottomRightCell;
		this._adjacentCells.add(this._bottomRightCell);
	}
	
	@Override
	public CellSelection getBottomLeftCell() {
		return _bottomLeftCell;
	}

	void setBottomLeftCell(CellSelection bottomLeftCell) {
		this._bottomLeftCell = bottomLeftCell;
		this._adjacentCells.add(this._bottomLeftCell);
	}
	
	@Override
	public CellSelection getBottomCell() {
		return _bottomCell;
	}
	
	void setBottomCell(CellSelection bottomCell) {
		this._bottomCell = bottomCell;
		this._adjacentCells.add(this._bottomCell);
	}

}
