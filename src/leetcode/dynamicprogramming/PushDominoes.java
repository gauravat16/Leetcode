/*
 * Copyright (c) 2018.  Gaurav Sharma, All rights reserved.
 */

package leetcode.dynamicprogramming;

/**
 * There are N dominoes in a line, and we place each domino vertically upright.
 * <p>
 * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left.
 * <p>
 * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 * <p>
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 * <p>
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
 * <p>
 * Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.
 * <p>
 * Return a string representing the final state.
 */

public class PushDominoes {

    public String pushDominoes(String dominoes) {

        char[] dominoesArr = dominoes.toCharArray();

        int L = -1, R = -1;

        for (int i = 0; i <= dominoesArr.length; i++) {

            if (i == dominoesArr.length || dominoesArr[i] == 'R') {

                if (R > L) {
                    while (R < i) {
                        dominoesArr[R++] = 'R';
                    }

                }

                R = i;

            } else if (dominoesArr[i] == 'L') {
                if (L > R || (R == -1 && L == -1)) {
                    while (++L < i) {
                        dominoesArr[L] = 'L';
                    }
                } else {
                    L = i;
                    int lo = R + 1;
                    int high = L - 1;

                    while (lo < high) {
                        dominoesArr[lo++] = 'R';
                        dominoesArr[high--] = 'L';
                    }
                }
            }

        }


        return String.valueOf(dominoesArr);

    }

    public static void main(String[] args) {

        System.out.println(new PushDominoes().pushDominoes(".L.R...LR..L.."));

    }
}
