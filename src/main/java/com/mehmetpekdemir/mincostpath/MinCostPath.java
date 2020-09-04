package com.mehmetpekdemir.mincostpath;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
class MinCostPath {

	public int find(int[][] matrix, Cell start, Cell target) {
		validateIfTheCellIsOutOfMatrixBound(matrix, start);
		validateIfTheCellIsOutOfMatrixBound(matrix, target);

		return findMinCostPath(matrix, start, target);
	}

	private int findMinCostPath(int[][] matrix, Cell start, Cell target) {
		if (start.getRow() > target.getRow() || start.getColumn() > target.getColumn()) {
			return Integer.MAX_VALUE;
		}

		if (start.equals(target)) {
			return matrix[start.getRow()][start.getColumn()];
		}

		final int rightPathCost = findMinCostPath(matrix, new Cell(start.getRow(), start.getColumn() + 1), target);
		final int downPathCost = findMinCostPath(matrix, new Cell(start.getRow() + 1, start.getColumn()), target);
		final int diagonalPathCost = findMinCostPath(matrix, new Cell(start.getRow() + 1, start.getColumn() + 1), target);

		final int min = Math.min(rightPathCost, Math.min(downPathCost, diagonalPathCost));

		return min + matrix[start.getRow()][start.getColumn()];
	}

	private void validateIfTheCellIsOutOfMatrixBound(int[][] matrix, Cell cell) {
		if (cell.getRow() >= matrix.length || cell.getRow() < 0) {
			throw new IllegalArgumentException();
		}
		if (cell.getColumn() >= matrix[0].length || cell.getColumn() < 0) {
			throw new IllegalArgumentException();
		}
	}

}
