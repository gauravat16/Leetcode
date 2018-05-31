package leetcode.dynamicprogramming;

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {


        return fastSolution(A);

    }

    private int fastSolution(int[] A) {

        int count = 0, sum = 0;

        for (int index = 2; index < A.length; index++) {
            if (A[index] - A[index - 1] == A[index - 1] - A[index - 2]) {
                count++;
                sum += count;
            } else {
                count = 0;
            }

        }

        return sum;
    }


    private int slowSolution(int[] A) {
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
        System.out.println(new ArithmeticSlices().fastSolution(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new ArithmeticSlices().slowSolution(new int[]{1, 2, 3, 4, 5}));
    }

}
