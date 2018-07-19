package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, except those cells in the given list mines which are 0. What is the largest axis-aligned plus sign of 1s contained in the grid? Return the order of the plus sign. If there is none, return 0.
 * <p>
 * An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1 along with 4 arms of length k-1 going up, down, left, and right, and made of 1s. This is demonstrated in the diagrams below. Note that there could be 0s or 1s beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1s.
 * <p>
 * Examples of Axis-Aligned Plus Signs of Order k:
 * <p>
 * Order 1:
 * 000
 * 010
 * 000
 * <p>
 * Order 2:
 * 00000
 * 00100
 * 01110
 * 00100
 * 00000
 * <p>
 * Order 3:
 * 0000000
 * 0001000
 * 0001000
 * 0111110
 * 0001000
 * 0001000
 * 0000000
 */

public class LargestPlusSign {

    public int orderOfLargestPlusSign(int N, int[][] mines) {

        int[][] grid = new int[N][N];

        for (int[] row : grid) {
            Arrays.fill(row, 1);

        }

        for (int[] minePos : mines) {
            grid[minePos[0]][minePos[1]] = 0;
        }

        int largest = 0;

        for (int i = 0; i < N; i++) {


            for (int j = 0; j < N; j++) {


                if (grid[i][j] == 1) {
                    int count = 1;
                    int level = 1;

                    while (isPlus(grid, level, i, j)) {
                        count++;
                        level++;
                    }


                    largest = Math.max(largest, count);


                }
            }
        }

        return largest;

    }

    private boolean isPlus(int[][] grid, int level, int i, int j) {
        return j - level >= 0 && j + level < grid.length && i - level >= 0 && i + level < grid.length &&
                grid[i][j - level] == 1 && grid[i][j + level] == 1 &&
                grid[i - level][j] == 1 && grid[i + level][j] == 1;
    }


    public static void main(String[] args) {

        System.out.println(new LargestPlusSign().orderOfLargestPlusSign(5, new int[][]{{4, 2}}));

    }
}
