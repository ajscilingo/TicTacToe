package net.scilingo.board.minesweeper;

import net.scilingo.board.Cell;
import net.scilingo.board.CellSelection;

public class MinesweeperCell extends MinesweeperCellProperties implements Cell {

	private CellSelection _topCell;
	private CellSelection _topRightCell;
	private CellSelection _topLeftCell;
	
	private CellSelection _rightCell;
	private CellSelection _leftCell;
	
	private CellSelection _bottomCell;
	private CellSelection _bottomRightCell;
	private CellSelection _bottomLeftCell;
	
	MinesweeperCell(int row, int column) throws MinesweeperCellIndexOutOfBoundsException, MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException, MinesweeperCellIllegalArgumentException{
		super(row, column);
		if( this.isLowerLeftCell() || this.isLowerRightCell() 
				|| this.isUpperLeftCell() || this.isUpperRightCell() 
				|| this.bordersLeftBoundary() || this.bordersRightBoundary() 
				|| this.bordersUpperBoundary() || this.bordersLowerBoundary() ) {
			throw new MinesweeperCellIllegalArgumentException();
		}
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
	public CellSelection getTopLeftCell() {
		return _topLeftCell;
	}

	void setTopLeftCell(CellSelection topLeftCell) {
		this._topLeftCell = topLeftCell;
		this._adjacentCells.add(this._topLeftCell);
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
	public CellSelection getBottomCell() {
		return _bottomCell;
	}
	
	void setBottomCell(CellSelection bottomCell) {
		this._bottomCell = bottomCell;
		this._adjacentCells.add(this._bottomCell);
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

}
