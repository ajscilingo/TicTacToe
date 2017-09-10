package net.scilingo.board.minesweeper;

import net.scilingo.board.CellSelection;
import net.scilingo.board.RightCell;

public class MinesweeperRightBoundaryCell extends MinesweeperCellProperties implements RightCell {

	private CellSelection _topCell;
	private CellSelection _topLeftCell;
	private CellSelection _leftCell;
	private CellSelection _bottomLeftCell;
	private CellSelection _bottomCell;
	
	MinesweeperRightBoundaryCell(int row) throws MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException, MinesweeperCellIllegalArgumentException {
		super(row, MinesweeperCellProperties.getMaxColumn() - 1);
		if( (this.isLowerRightCell() || this.isUpperRightCell()) || !this.bordersRightBoundary())
			throw new MinesweeperCellIllegalArgumentException();
	}

	@Override
	public CellSelection getTopCell() {
		return _topCell;
	}

	@Override
	public CellSelection getTopLeftCell() {
		return _topLeftCell;
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
