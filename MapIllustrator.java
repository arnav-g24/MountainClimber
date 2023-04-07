import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MapIllustrator {
	/** the 2D array containing the elevations */
	private int[][] grid;

	/** constructor, parses input from the file into grid */
	public MapIllustrator(String fileName) {
		Scanner scan = null;

		try {
			scan = new Scanner(new File("Colorado_480x480.txt"));
		} catch (IOException e) {
			System.out.println("file cannot be read");
		}

		int x = scan.nextInt();
		int y = scan.nextInt();

		grid = new int[x][y];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = scan.nextInt();
			}
		}
	}

	/** @return the min value in the entire grid */
	public int findMin() {
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				min = Math.min(grid[i][j], min);
			}
		}

		return min; // REPLACE
	}

	/** @return the max value in the entire grid */
	public int findMax() {
		int max = -1;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				max = Math.max(grid[i][j], max);
			}
		}

		return max; // REPLACE
	}

	/**
	 * Draws the grid using the given Graphics object. Colors should be grayscale
	 * values 0-255, scaled based on min/max values in grid
	 */
	public void drawMap(Graphics g) {
		int max = findMax();
		int min = findMin();
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int color = (int) (255 * ((double) grid[i][j] - min) / (max -min));
				g.setColor(new Color(color, color, color));
				g.fillRect(j, i, 1, 1);
			}
		}
	}

	/**
	 * Find a path from West-to-East starting at given row. Choose a forward step
	 * out of 3 possible forward locations, using greedy method described in
	 * assignment.
	 * 
	 * @return the total change in elevation traveled from West-to-East
	 */
	public int drawPath(Graphics g, int row) {
		g.fillRect(0, row, 1, 1);
		int opt1, opt2, opt3;
		int previous;
		int elevationChange = 0;
		
		for(int s = 1; s < grid[row].length; s++) {
			previous = row;
			if(row == 0)
				row = 1;
			if(row == 480)
				row = 479;
			opt1 = Math.abs(grid[row][s] - grid[row][s-1]);
			opt2 = Math.abs(grid[row - 1][s] - grid[row][s-1]);
			opt3 = Math.abs(grid[row + 1][s] - grid[row][s-1]);
			
			if(opt3 < opt2 && opt3 < opt1)
				row +=1;
			else if(opt2 < opt1 && opt2 < opt3)
				row -= 1;
			g.fillRect(s, row, 1, 1);
			elevationChange += Math.abs(grid[row][s] - grid[previous][s-1]);
		}
		return elevationChange;
	}

	/**
	 * @return the index of the starting row for the lowest-elevation-change path in
	 *         the entire grid.
	 */
	public int getIndexOfLowestPath(Graphics g) {
		int lowestChange = Integer.MAX_VALUE;
		int current = 0;
		int row = 0;
		int total = 0;
		
		for(int r = 0; r< grid.length - 1; r++) {
			current = drawPath(g, r);
			if(current < lowestChange) {
				lowestChange = current;
				row = r;
			}
		}
		return row;
	}

	/** return the number of rows in grid */
	public int getRows() {
		return grid.length;
	}

	/** return the number of columns in grid (assumed rectangular) */
	public int getCols() {
		return grid[0].length;
	}
}
