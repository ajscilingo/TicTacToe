package net.scilingo.board.minesweeper;

import net.scilingo.board.Board;
import net.scilingo.board.CellSelection;

public class MinesweeperGameBoard implements Board {

	protected final CellSelection [][] _gameBoard;
	protected final int _rows;
	protected final int _columns;

	MinesweeperGameBoard() throws MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException {
		
		// By Default MinesweeperCellProperties is set to have 4 rows and 4 columns 		
		this(4,4);
	}
	
	MinesweeperGameBoard(int rows, int columns) throws MinesweeperCellSetMaxRowException, MinesweeperCellSetMaxColumnException{
		
		this._rows = rows;
		this._columns = columns;
		
		// All MinesweeperCells Created Must know this information
		MinesweeperCellProperties.setBoardDimensions(rows,columns);
		
		_gameBoard = new CellSelection[rows][columns]; 
		createUpperLeftCellAndAdjacentCells();
		createUpperRightCellAndAdjacentCells();
		createLowerLeftCellAndAdjacentCells();
		createLowerRightCellandAdjacentCells();
		visitUpperLeftCell((MinesweeperUpperLeftCell)_gameBoard[0][0]);
		populateCells();
	}
	
	void createUpperLeftCellAndAdjacentCells() {
		
		try {
			CellSelection upperLeftCell = new MinesweeperUpperLeftCell();
			_gameBoard[0][0] = upperLeftCell;
			MinesweeperUpperLeftCell minesweeperUpperLeftCell = (MinesweeperUpperLeftCell) upperLeftCell;
			_gameBoard[0][1] = minesweeperUpperLeftCell.getRightCell();
			_gameBoard[1][0] = minesweeperUpperLeftCell.getBottomCell();
			_gameBoard[1][1] = minesweeperUpperLeftCell.getBottomRightCell();
			
		} catch (MinesweeperCellIndexOutOfBoundsException | MinesweeperCellSetMaxRowException
				| MinesweeperCellSetMaxColumnException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void createUpperRightCellAndAdjacentCells() {
		
		try {
			CellSelection upperRightCell = new MinesweeperUpperRightCell();
			_gameBoard[0][this._columns-1] = upperRightCell;
			MinesweeperUpperRightCell minesweeperUpperRightCell = (MinesweeperUpperRightCell) upperRightCell;
			_gameBoard[0][this._columns-2] = minesweeperUpperRightCell.getLeftCell();
			_gameBoard[1][this._columns-1] = minesweeperUpperRightCell.getBottomCell();
			_gameBoard[1][this._columns-2] = minesweeperUpperRightCell.getBottomLeftCell();
		
		} catch (MinesweeperCellIndexOutOfBoundsException | MinesweeperCellIllegalArgumentException
				| MinesweeperCellSetMaxRowException | MinesweeperCellSetMaxColumnException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void createLowerLeftCellAndAdjacentCells() {
		
		try {
			CellSelection lowerLeftCell = new MinesweeperLowerLeftCell();
			_gameBoard[this._rows-1][0] = lowerLeftCell;
			MinesweeperLowerLeftCell minesweeperLowerLeftCell = (MinesweeperLowerLeftCell) lowerLeftCell;
			_gameBoard[this._rows-2][0] = minesweeperLowerLeftCell.getTopCell();
			_gameBoard[this._rows-2][1] = minesweeperLowerLeftCell.getTopRightCell();
			_gameBoard[this._rows-1][1] = minesweeperLowerLeftCell.getRightCell();
		} catch (MinesweeperCellIndexOutOfBoundsException | MinesweeperCellIllegalArgumentException
				| MinesweeperCellSetMaxRowException | MinesweeperCellSetMaxColumnException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void createLowerRightCellandAdjacentCells() {
		
		try {
			CellSelection lowerRightCell = new MinesweeperLowerRightCell();
			_gameBoard[this._rows-1][this._columns-1] = lowerRightCell;
			MinesweeperLowerRightCell minesweeperLowerRightCell = (MinesweeperLowerRightCell) lowerRightCell;
			_gameBoard[this._rows-1][this._columns-2] = minesweeperLowerRightCell.getLeftCell();
			_gameBoard[this._rows-2][this._columns-2] = minesweeperLowerRightCell.getTopLeftCell();
			_gameBoard[this._rows-2][this._columns-1] = minesweeperLowerRightCell.getTopCell();
		} catch (MinesweeperCellIndexOutOfBoundsException | MinesweeperCellSetMaxRowException
				| MinesweeperCellSetMaxColumnException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	void populateCells() {
		
		for(int row = 0; row < this._rows; row++) {
			for(int col = 0; col < this._columns; col++) {
				
				if(_gameBoard[row][col] == null) {
					System.out.print("N");
				}
				else {
					MinesweeperCellProperties cp  = (MinesweeperCellProperties) _gameBoard[row][col];
					if(cp.hasBomb())
						System.out.print("X");
					else
						System.out.print(cp.getAdjacentBombCount());
				}
			}
			System.out.println("");
		}
		
	}
	
	MinesweeperUpperLeftCell visitUpperLeftCell(MinesweeperUpperLeftCell minesweeperUpperLeftCell) {
		if( !minesweeperUpperLeftCell.isUpperLeftCell() ) throw new MinesweeperCellIllegalArgumentException();
		
		// first visit the Right Cell which is an UpperBoundary Cell
		MinesweeperUpperBoundaryCell minesweeperUpperBoundaryCell = (MinesweeperUpperBoundaryCell) minesweeperUpperLeftCell.getRightCell();
		
		// hook it up to this upperLeftCell
		minesweeperUpperBoundaryCell.setLeftCell(minesweeperUpperLeftCell);
		visitUpperBoundaryCell(minesweeperUpperBoundaryCell);
		
		// next visit the Bottom Cell which is a LeftBoundary Cell
		MinesweeperLeftBoundaryCell minesweeperLeftBoundaryCell = (MinesweeperLeftBoundaryCell) minesweeperUpperLeftCell.getBottomCell();
		
		// hook it up to the upperLeftCell
		minesweeperLeftBoundaryCell.setTopCell(minesweeperUpperLeftCell);
		visitLeftBoundaryCell(minesweeperLeftBoundaryCell);
		
		// next visit the Bottom Right Cell which is a Minesweeper Cell
		MinesweeperCell minesweeperCell = (MinesweeperCell) minesweeperUpperLeftCell.getBottomRightCell();
		
		// hook it up to the upperLeftCell
		minesweeperCell.setTopLeftCell(minesweeperUpperLeftCell);
		visitCell(minesweeperCell);
		
		
		return minesweeperUpperLeftCell;
	}
	
	MinesweeperUpperBoundaryCell visitUpperBoundaryCell(MinesweeperUpperBoundaryCell minesweeperUpperBoundaryCell) {
		if( !minesweeperUpperBoundaryCell.bordersUpperBoundary() || minesweeperUpperBoundaryCell.isUpperLeftCell() || minesweeperUpperBoundaryCell.isUpperRightCell())
			throw new MinesweeperCellIllegalArgumentException();
		
		// check to see if we're the next to the penultimate column if so then the next right cell is already created
		// so we need to grab it and hook up the appropriate connection
		if(minesweeperUpperBoundaryCell.getColumn() == this._columns - 3) {
			MinesweeperUpperBoundaryCell penUltimateRightUpperBoundaryCell = (MinesweeperUpperBoundaryCell) _gameBoard[0][this._columns - 2];
			minesweeperUpperBoundaryCell.setRightCell(penUltimateRightUpperBoundaryCell);
			penUltimateRightUpperBoundaryCell.setLeftCell(minesweeperUpperBoundaryCell);
			return minesweeperUpperBoundaryCell;
		}
		else {
			
			MinesweeperUpperBoundaryCell newMinesweeperUpperBoundaryCell;
			
			try {
				newMinesweeperUpperBoundaryCell = new MinesweeperUpperBoundaryCell(minesweeperUpperBoundaryCell.getColumn()+1);
				minesweeperUpperBoundaryCell.setRightCell(newMinesweeperUpperBoundaryCell);
				_gameBoard[0][minesweeperUpperBoundaryCell.getColumn()+1] = newMinesweeperUpperBoundaryCell;
				visitUpperBoundaryCell(newMinesweeperUpperBoundaryCell);
				newMinesweeperUpperBoundaryCell.setLeftCell(minesweeperUpperBoundaryCell);
				
			} catch (MinesweeperCellIndexOutOfBoundsException | MinesweeperCellIllegalArgumentException
					| MinesweeperCellSetMaxRowException | MinesweeperCellSetMaxColumnException e) {
				e.printStackTrace();
			}
			return minesweeperUpperBoundaryCell;
		}
	}
	
	MinesweeperLeftBoundaryCell visitLeftBoundaryCell(MinesweeperLeftBoundaryCell minesweeperLeftBoundaryCell) {
		if(minesweeperLeftBoundaryCell.isLowerLeftCell() || minesweeperLeftBoundaryCell.isUpperLeftCell() || !minesweeperLeftBoundaryCell.bordersLeftBoundary())
			throw new MinesweeperCellIllegalArgumentException();
		
		// check to see if we're the next to the penultimate row if so then the next right cell is already created
		// so we need to grab it and hook up the appropriate connection
		if(minesweeperLeftBoundaryCell.getRow() == this._rows - 3) {
			MinesweeperLeftBoundaryCell penUltimateLeftBoundaryCell = (MinesweeperLeftBoundaryCell) _gameBoard[this._rows - 2][0];
			minesweeperLeftBoundaryCell.setBottomCell(penUltimateLeftBoundaryCell);
			penUltimateLeftBoundaryCell.setTopCell(minesweeperLeftBoundaryCell);
			return minesweeperLeftBoundaryCell;
		}
		else {
			
			MinesweeperLeftBoundaryCell newMinesweeperLeftBoundaryCell;
			
			try {
				newMinesweeperLeftBoundaryCell = new MinesweeperLeftBoundaryCell(minesweeperLeftBoundaryCell.getRow()+1);
				minesweeperLeftBoundaryCell.setBottomCell(newMinesweeperLeftBoundaryCell);
				_gameBoard[minesweeperLeftBoundaryCell.getRow()+1][0] = newMinesweeperLeftBoundaryCell;
				visitLeftBoundaryCell(newMinesweeperLeftBoundaryCell);
				newMinesweeperLeftBoundaryCell.setTopCell(minesweeperLeftBoundaryCell);
				
			} catch (MinesweeperCellIllegalArgumentException | MinesweeperCellSetMaxRowException
					| MinesweeperCellSetMaxColumnException e) {
				e.printStackTrace();
			}
			return minesweeperLeftBoundaryCell;
		}
	}
	
	MinesweeperCell visitCell(MinesweeperCell minesweeperCell) {
		
		// Visit and Set Top Cell
		// TODO 
		return null;
		
	}
	
	MinesweeperLowerLeftCell visitLowerLeftCell(MinesweeperLowerLeftCell minesweeperLowerLeftCell) {
		// TODO
		return null;
	}
	
	MinesweeperLowerBoundaryCell visitLowerBoundaryCell(MinesweeperLowerBoundaryCell minesweeperLowerBoundaryCell) {
		// TODO
		return null;
	}
	
	MinesweeperRightBoundaryCell visitRightBoundaryCell(MinesweeperRightBoundaryCell minesweeperRightBoundaryCell) {
		// TODO 
		return null;
	}
}
