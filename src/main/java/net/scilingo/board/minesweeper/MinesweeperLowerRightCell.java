package net.scilingo.board.minesweeper;

import net.scilingo.board.CellSelection;
import net.scilingo.board.LowerRightCell;

public class MinesweeperLowerRightCell extends MinesweeperCellProperties implements LowerRightCell {

	private CellSelection _leftCell;
	private CellSelection _topLeftCell;
	private CellSelection _topCell;
	
	MinesweeperLowerRightCell() throws MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException, MinesweeperCellIndexOutOfBoundsException{
		super(MinesweeperCellProperties.getMaxRow() - 1, MinesweeperCellProperties.getMaxColumn() - 1);
		
		this._leftCell = new MinesweeperLowerBoundaryCell(MinesweeperCellProperties.getMaxColumn() - 2);
		this._topLeftCell = new MinesweeperCell(MinesweeperCellProperties.getMaxRow() - 2, MinesweeperCellProperties.getMaxColumn() - 2);
		this._topCell = new MinesweeperRightBoundaryCell(MinesweeperCellProperties.getMaxRow() - 2);		
	}
	
	@Override
	public CellSelection getLeftCell() {
		return _leftCell;
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
