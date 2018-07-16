package leetcode.dynamicprogramming;

/**
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
 * <p>
 * A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 * <p>
 * <p>
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
 * <p>
 * The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.
 */

public class KnightProbabilityChessboard {


    double[][][] dp;

    public double knightProbability(int N, int K, int r, int c) {
        dp = new double[N][N][K + 1];

        return knightProbabilityRecursion(N, K, r, c) / Math.pow(8, K);

    }

    public double knightProbabilityRecursion(int N, int K, int r, int c) {
        int[] dr = new int[]{2, 2, 1, 1, -2, -2, -1, -1};
        int[] dc = new int[]{-1, 1, -2, 2, -1, 1, -2, 2};

        if (K == 0) {
            return 1;
        }

        double numerator = 0;

        for (int i = 0; i < 8; i++) {
            int cx = r + dr[i];
            int cy = c + dc[i];

            if (cx >= 0 && cx < N && cy >= 0 && cy < N) {

                if (dp[cx][cy][K] == 0) {
                    dp[cx][cy][K] = knightProbabilityRecursion(N, K - 1, cx, cy);

                }


                numerator += dp[cx][cy][K];

            }


        }

        return numerator;


    }

    public static void main(String[] args) {

        System.out.println(new KnightProbabilityChessboard().knightProbability(3, 2, 0, 0));

    }
}
