package net.scilingo.board.minesweeper;

import net.scilingo.board.CellSelection;
import net.scilingo.board.LeftCell;

public class MinesweeperLeftBoundaryCell extends MinesweeperCellProperties implements LeftCell {

	private CellSelection _topCell;
	private CellSelection _topRightCell;
	private CellSelection _rightCell;
	private CellSelection _bottomRightCell;
	private CellSelection _bottomCell;
	
	MinesweeperLeftBoundaryCell(int row) throws MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException, MinesweeperCellIllegalArgumentException {
		super(row,0);
		if( this.isLowerLeftCell() || this.isUpperLeftCell() )
			throw new MinesweeperCellIllegalArgumentException();
	}

	@Override
	public CellSelection getTopCell() {
		return _topCell;
	}
	
	void setTopCell(CellSelection topCell) {
		this._topCell = topCell;
		this._adjacentCells.add(this._topCell);
	}

	@Override
	public CellSelection getTopRightCell() {
		return _topRightCell;
	}

	void setTopRightCell(CellSelection topRightCell) {
		this._topRightCell = topRightCell;
		this._adjacentCells.add(this._topRightCell);
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
	public CellSelection getBottomRightCell() {
		return _bottomRightCell;
	}
	
	void setBottomRightCell(CellSelection bottomRightCell) {
		this._bottomRightCell = bottomRightCell;
		this._adjacentCells.add(this._bottomRightCell);
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
