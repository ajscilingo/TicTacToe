package net.scilingo.board.minesweeper;

import net.scilingo.board.CellSelection;
import net.scilingo.board.LowerLeftCell;

public class MinesweeperLowerLeftCell extends MinesweeperCellProperties implements LowerLeftCell {

	private CellSelection _rightCell;
	private CellSelection _topRightCell;
	private CellSelection _topCell;
	
	MinesweeperLowerLeftCell() throws MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException, MinesweeperCellIndexOutOfBoundsException, MinesweeperCellIllegalArgumentException {
		super(MinesweeperCellProperties.getMaxRow()-1, 0);
		if(!this.isLowerLeftCell() || this.isLowerRightCell() )
			throw new MinesweeperCellIllegalArgumentException();
		
		this._rightCell = new MinesweeperLowerBoundaryCell(1);
		this._topCell = new MinesweeperLeftBoundaryCell(MinesweeperCellProperties.getMaxRow()-2);
		this._topRightCell = new MinesweeperCell(MinesweeperCellProperties.getMaxRow()-2, 1);
		
		this._adjacentCells.add(this._rightCell);
		this._adjacentCells.add(this._topCell);
		this._adjacentCells.add(this._topRightCell);
		
	}
	
	@Override
	public CellSelection getRightCell() {
		return _rightCell;
	}

	@Override
	public CellSelection getTopRightCell() {
		return _topRightCell;
	}

	@Override
	public CellSelection getTopCell() {
		return _topCell;
	}

}
