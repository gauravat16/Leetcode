package leetcode.dynamicprogramming;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 */

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        return uniquePaths(m-1, n-1, 0, 0, dp, 0);
    }


    public int uniquePaths(int rows, int cols, int currRows, int currCols, int[][] dp, int count) {

        if (currRows > rows && currCols > cols) {
            return count;
        }

        if(currRows < rows && currCols < cols && dp[currRows][currCols] != 0){
            return dp[currRows][currCols];
        }

        if (currRows == rows && currCols == cols) {
            count++;
            return count;
        }
        int a=0 ,b=0;

        if(currCols<cols){
           a =  uniquePaths(rows, cols, currRows, currCols + 1, dp, count);
        }

        if(currRows<rows){
           b =  uniquePaths(rows, cols, currRows + 1, currCols, dp, count);
        }

        dp[currRows][currCols] = a+b;


        return dp[currRows][currCols];


    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(23, 12));
    }


}
