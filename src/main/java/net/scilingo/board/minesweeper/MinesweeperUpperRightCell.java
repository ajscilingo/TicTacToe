package net.scilingo.board.minesweeper;

import net.scilingo.board.CellSelection;
import net.scilingo.board.UpperRightCell;

public class MinesweeperUpperRightCell extends MinesweeperCellProperties implements UpperRightCell {

	private CellSelection _leftCell;
	private CellSelection _bottomLeftCell;
	private CellSelection _bottomCell;
	
	
	MinesweeperUpperRightCell() throws MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException, MinesweeperCellIndexOutOfBoundsException, MinesweeperCellIllegalArgumentException{
		super(0, MinesweeperCellProperties.getMaxColumn() -1);
		if(!isUpperRightCell() || this.isUpperLeftCell())
			throw new MinesweeperCellIllegalArgumentException();
		
		this._leftCell = new MinesweeperUpperBoundaryCell(getMaxColumn() - 2);
		this._bottomCell = new MinesweeperRightBoundaryCell(1);
		this._bottomLeftCell = new MinesweeperCell(1, getMaxColumn() - 2);
		
		this._adjacentCells.add(this._leftCell);
		this._adjacentCells.add(this._bottomCell);
		this._adjacentCells.add(this._bottomLeftCell);
		
	}
	
	@Override
	public CellSelection getLeftCell() {
		return _leftCell;
	}

	@Override
	public CellSelection getBottomLeftCell() {
		return _bottomLeftCell;
	}

	@Override
	public CellSelection getBottomCell() {
		return _bottomCell;
	}

}
