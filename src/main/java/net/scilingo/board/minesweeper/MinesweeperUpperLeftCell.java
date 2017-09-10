package net.scilingo.board.minesweeper;

import net.scilingo.board.CellSelection;
import net.scilingo.board.UpperLeftCell;

public class MinesweeperUpperLeftCell extends MinesweeperCellProperties implements UpperLeftCell {

	private CellSelection _rightCell;
	private CellSelection _bottomRightCell;
	private CellSelection _bottomCell;
	
	
	MinesweeperUpperLeftCell() throws MinesweeperCellIndexOutOfBoundsException, MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException, MinesweeperCellIllegalArgumentException {
		super(0,0);	
		if( !this.isUpperLeftCell() || this.isUpperRightCell() ) 
			throw new MinesweeperCellIllegalArgumentException();
		
		this._rightCell = new MinesweeperUpperBoundaryCell(1);
		this._bottomCell = new MinesweeperLeftBoundaryCell(1);
		this._bottomRightCell = new MinesweeperCell(1,1);
		
		this._adjacentCells.add(this._rightCell);
		this._adjacentCells.add(this._bottomCell);
		this._adjacentCells.add(this._bottomRightCell);
		
	}
	
	@Override
	public CellSelection getRightCell() {
		return _rightCell;
	}

	@Override
	public CellSelection getBottomRightCell() {
		return _bottomRightCell;
	}

	@Override
	public CellSelection getBottomCell() {
		return _bottomCell;
	}

}
