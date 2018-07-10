package leetcode.dynamicprogramming;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] minGrid = new int[rows][cols];

        minGrid[0][0] = grid[0][0];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (i == 0 && j > 0) {
                    minGrid[i][j] = minGrid[i][j - 1] + grid[i][j];
                } else if (i > 0 && j == 0) {
                    minGrid[i][j] = minGrid[i - 1][j] + grid[i][j];
                } else if (i > 0 && j > 0) {
                    minGrid[i][j] = Math.min(minGrid[i - 1][j], minGrid[i][j - 1]) + grid[i][j];
                }


            }
        }

        return minGrid[rows - 1][cols - 1];
    }

    public static void main(String[] args) {

        int[][] inpArr = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(new MinimumPathSum().minPathSum(inpArr));
    }
}
