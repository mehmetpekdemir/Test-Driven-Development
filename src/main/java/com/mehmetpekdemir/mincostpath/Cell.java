package com.mehmetpekdemir.mincostpath;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 03.30.2020
 *
 */
public class Cell {

	private final int row;
	private final int column;

	public Cell(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public boolean equals(Object obj) {
		if (!Cell.class.isInstance(obj)) {
			return false;
		}

		final Cell cell2 = (Cell) obj;

		return cell2.getRow() == this.getRow() && cell2.getColumn() == this.getColumn();
	}

}
