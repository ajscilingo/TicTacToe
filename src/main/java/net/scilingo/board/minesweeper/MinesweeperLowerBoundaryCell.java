package net.scilingo.board.minesweeper;

import net.scilingo.board.CellSelection;
import net.scilingo.board.LowerCell;

public class MinesweeperLowerBoundaryCell extends MinesweeperCellProperties implements LowerCell {

	private CellSelection _rightCell;
	private CellSelection _leftCell;
	private CellSelection _topRightCell;
	private CellSelection _topLeftCell;
	private CellSelection _topCell;
	
	MinesweeperLowerBoundaryCell(int column) throws MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException, MinesweeperCellIndexOutOfBoundsException, MinesweeperCellIllegalArgumentException{
		super(MinesweeperCellProperties.getMaxRow()-1, column);
		if(this.isLowerLeftCell() || this.isLowerRightCell())
			throw new MinesweeperCellIllegalArgumentException();
	}
	
	@Override
	public CellSelection getRightCell() {
		return _rightCell;
	}

	@Override
	public CellSelection getLeftCell() {
		return _leftCell;
	}

	@Override
	public CellSelection getTopRightCell() {
		return _topRightCell;
	}

	@Override
	public CellSelection getTopLeftCell() {
		return _topLeftCell;
	}

	@Override
	public CellSelection getTopCell() {
		return _topCell;
	}

}
