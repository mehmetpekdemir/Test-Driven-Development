package com.mehmetpekdemir.mincostpath.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.mehmetpekdemir.mincostpath.Cell;
import com.mehmetpekdemir.mincostpath.MinCostPath;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 03.30.2020
 *
 */
public class MinCostPathTests {

	private MinCostPath minCostPath;

	@Before
	public void setUp() {
		minCostPath = new MinCostPath();
	}

	private Cell cell(int row,int column) {
		return new Cell(row, column);
	}
	
	@Test
	@DisplayName("Throws IllegalArgumentException when the start cell is out of matrix bound")
	public void throwsIllegalArgumentExceptionWhenTheCellIsOutOfTheMatrixBound() {
		final int[][] matrix = { 
				{ 4, 5, 6 }, 
				{ 7, 8, 1 } 
		};
		
		assertAll("Start cell must be in matrix",
				() -> assertThrows(IllegalArgumentException.class, ()-> minCostPath.find(matrix,cell(2,1),cell(0,2))),
				() -> assertThrows(IllegalArgumentException.class, ()-> minCostPath.find(matrix,cell(-1,1),cell(0,2)))
		);
		
		assertAll("Target cell must be in matrix",
				() -> assertThrows(IllegalArgumentException.class, ()-> minCostPath.find(matrix,cell(0,0),cell(2,1))),
				() -> assertThrows(IllegalArgumentException.class, ()-> minCostPath.find(matrix,cell(0,0),cell(-1,2)))
		);
	}
	
	@Test
    @DisplayName("Return the cost of start cell when the start cell equals to target cell")
	public void returnTheCostStartCellWhenTheStartCellIsEqualToTargetCell() {
        final int[][] matrix = {
                {3, 5, 7, 9}
        };
        
        assertAll("The start cell is equals to target cell",
        		()->  assertEquals(3, minCostPath.find(matrix, cell(0,0), cell(0,0))),
        		()-> assertEquals(7, minCostPath.find(matrix, cell(0,2), cell(0,2)))
       );     
	}
	
	@Test
	@DisplayName("Find min cost path for one row matrix")
	public void findCostPathForOneRowMatrix() {
		 final int[][] matrix = {
	                {3, 6, 7, 4}
	        };
		 
		 assertAll("One row matrix",
				 ()-> assertEquals(9, minCostPath.find(matrix, cell(0,0), cell(0,1))),
				 ()-> assertEquals(16, minCostPath.find(matrix, cell(0,0), cell(0,2))),
				 ()-> assertEquals(11, minCostPath.find(matrix, cell(0,2), cell(0,3)))
		);
 
	}
	
	
	@Test
	@DisplayName("Find min cost path for multi row matrix ")
	public void findCostPathForMultiRowMatrix() {
		final int[][] matrix = {
				 {1, 2, 3, 4},
	             {1, 3, 1, 2},
	             {1, 2, 4, 5}
		};
		
		assertAll("Multi row matrix",
				()-> assertEquals(4, minCostPath.find(matrix, cell(0,0), cell(1,2))),
				()-> assertEquals(4, minCostPath.find(matrix, cell(0,0), cell(2,1))),
				()-> assertEquals(9, minCostPath.find(matrix, cell(0,0), cell(2,3)))
		);
		
	}

}
