package leetcode.dynamicprogramming;


public class CountingBits {

    public int[] countBits(int num) {

        int[] memo = new int[num + 1];

        memo[0] = 0;

        for (int i = 1; i <= num; i++) {

            memo[i] = memo[i / 2] + i % 2;

        }

        return memo;

    }


    public static void main(String[] args) {
        for (int i : new CountingBits().countBits(16)) {
            System.out.println(i);
        }
    }
}
