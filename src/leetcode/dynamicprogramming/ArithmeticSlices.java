package leetcode.dynamicprogramming;

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {

        boolean[][] memo = new boolean[A.length][A.length];

        int count = 0;

        for (int window = 3; window < A.length + 1; window++) {
            for (int start = 0; start < A.length - window + 1; start++) {

                int end = start + window - 1;

                if (window == 3) {
                    int tempDiff = Integer.MIN_VALUE;
                    boolean isAP = true;
                    for (int i = start; i < end; i++) {

                        if (tempDiff == Integer.MIN_VALUE) {
                            tempDiff = A[i + 1] - A[i];

                        } else if (tempDiff != A[i + 1] - A[i]) {
                            isAP = false;
                            break;
                        }

                    }

                    if (isAP) {
                        memo[start][end] = true;
                        count++;
                    }
                } else {

                    if (memo[start][end - 1] && A[end] - A[end - 1] == A[end - 1] - A[end - 2]) {
                        count++;
                        memo[start][end] = true;
                    }

                }

            }
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5}));
    }

}
