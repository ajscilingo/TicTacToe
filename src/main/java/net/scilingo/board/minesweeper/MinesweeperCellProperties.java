package net.scilingo.board.minesweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.scilingo.board.CellSelection;

public class MinesweeperCellProperties {

	// properties shared amongst all cells
	private static int _maxRow = 4;
	private static int _maxColumn = 4;
	
	// properties specific to each cell
	protected int _row;
	protected int _column;
	
	protected boolean _isUpperLeftCell = false;
	protected boolean _isUpperRightCell = false;
	protected boolean _isLowerLeftCell = false;
	protected boolean _isLowerRightCell = false;
	protected boolean _isNotAnEdgeCell = false;
	
	protected boolean _bordersUpperBoundary = false;
	protected boolean _bordersLowerBoundary = false;
	
	protected boolean _bordersLeftBoundary = false;
	protected boolean _bordersRightBoundary = false;

	protected List<CellSelection> _adjacentCells = new ArrayList<CellSelection>();
	
	protected final boolean _bomb;
	protected int _adjacentBombCount = 0;
	protected static final Random _random = new Random();
	
	MinesweeperCellProperties()  {
		this._bomb = _random.nextBoolean();
	}
	
	MinesweeperCellProperties(boolean bomb) throws MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException{
		this._bomb = bomb;
	}
	
	MinesweeperCellProperties(int row, int column) throws MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException, MinesweeperCellIndexOutOfBoundsException {
		
		// Must call setMaxRow and setMaxColumn before creating a FreecellCell
		validateMaxRow();
		validateMaxColumn();
		
		this._row = row;
		validateRow();
		this._column = column;
		validateColumn();
		
		setAdditionalFlags();
		
		this._bomb = _random.nextBoolean();
	}
	
	MinesweeperCellProperties(int row, int column, boolean bomb) throws MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException, MinesweeperCellIndexOutOfBoundsException {
		
		// Must call setMaxRow and setMaxColumn before creating a FreecellCell
		validateMaxRow();
		validateMaxColumn();
		
		this._row = row;
		validateRow();
		this._column = column;
		validateColumn();
		
		setAdditionalFlags();
		
		this._bomb = bomb;
	}
	
	private void setAdditionalFlags() {
		
		/**
		 * 
		 * Edge Cases 
		 * 
		 */
		
		// Is this the upper left cell ?
		if(this._row == 0 && this._column == 0) 
			this._isUpperLeftCell = true;
		// Is this the upper right cell ?
		else if (this._row == 0 && this._column == _maxColumn - 1)
			this._isUpperRightCell = true;
		// Is this the lower left cell ?
		else if (this._row == _maxRow - 1 && this._column == 0)
			this._isLowerLeftCell = true;
		// Is this the lower right cell ?
		else if (this._row == _maxRow - 1 && this._column == _maxColumn - 1)
			this._isLowerRightCell = true;
		// Else this is not an edge cell
		else
			this._isNotAnEdgeCell = true;
		
		/**
		 * 
		 * Additional Checks
		 * that apply to both 
		 * edge and non-edge 
		 * 
		 */
		
		// Is this cell in the first row ?
		if(this._row == 0)
			this._bordersUpperBoundary = true;
		// Is this cell in the last row ?
		if(this._row == _maxRow - 1)
			this._bordersLowerBoundary = true;
		// Is this cell in the first column ?
		if(this._column == 0)
			this._bordersLeftBoundary = true;
		// Is this cell in the last column ?
		if(this._column == _maxColumn - 1)
			this._bordersRightBoundary = true;
		
	}
	
	static void setBoardDimensions(int maxRow, int maxColumn) throws MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException {
		_maxRow = maxRow;
		_maxColumn = maxColumn;
		validateMaxRow();
		validateMaxColumn();
	}
	
	static void setMaxRow(int maxRow) throws MinesweeperCellSetMaxRowException {
		_maxRow = maxRow;
		validateMaxRow();
	}
	
	static int getMaxRow() {
		return _maxRow;
	}
	
	static int getMaxColumn() {
		return _maxColumn;
	}
	
	static void setMaxColumn(int maxColumn) throws MinesweeperCellSetMaxColumnException {
		_maxColumn = maxColumn;
		validateMaxColumn();
	}
	
	private void validateRow() throws MinesweeperCellIndexOutOfBoundsException{
		if(this._row < 0 || this._row >= _maxRow)
			throw new MinesweeperCellIndexOutOfBoundsException(this._row);
	}
	
	private void validateColumn() throws MinesweeperCellIndexOutOfBoundsException{
		if(this._column < 0 || this._column >= _maxColumn)
			throw new MinesweeperCellIndexOutOfBoundsException(this._column);
	}
	
	private static void validateMaxRow() throws MinesweeperCellSetMaxRowException {
		if (_maxRow < 4) 
			throw new MinesweeperCellSetMaxRowException(_maxRow);
	}
	
	private static void validateMaxColumn() throws MinesweeperCellSetMaxColumnException {
		if (_maxColumn < 4) 
			throw new MinesweeperCellSetMaxColumnException(_maxColumn);
	}
	
	public boolean isUpperLeftCell() {
		return this._isUpperLeftCell;
	}
	
	public boolean isUpperRightCell() {
		return this._isUpperRightCell;
	}
	
	public boolean isLowerLeftCell() {
		return this._isLowerLeftCell;
	}
	
	public boolean isLowerRightCell() {
		return this._isLowerRightCell;
	}
	
	public boolean isNotAnEdgeCell() {
		return this._isNotAnEdgeCell;
	}
	
	public boolean bordersUpperBoundary() {
		return this._bordersUpperBoundary;
	}
	
	public boolean bordersLowerBoundary() {
		return this._bordersLowerBoundary;
	}
	
	public boolean bordersLeftBoundary() {
		return this._bordersLeftBoundary;
	}
	
	public boolean bordersRightBoundary() {
		return this._bordersRightBoundary;
	}
	
	public int getRow() {
		return _row;
	}

	void setRow(int row) throws MinesweeperCellIndexOutOfBoundsException {
		this._row = row;
		validateRow();
	}

	public int getColumn() {
		return _column;
	}

	void setColumn(int column) throws MinesweeperCellIndexOutOfBoundsException {
		this._column = column;
		validateColumn();
	}
	
	public boolean hasBomb() {
		return _bomb;
	}
	
	public int getAdjacentBombCount() {
		return _adjacentBombCount;
	}
}
