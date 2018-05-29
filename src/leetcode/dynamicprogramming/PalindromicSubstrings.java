package leetcode.dynamicprogramming;

import java.util.*;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * <p>
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 */

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        return allPlalindromes(s).size();
    }

    public List<String> allPlalindromes(String s) {
        List<String> cache = new ArrayList<>();

        boolean[][] memo = new boolean[s.length()][s.length()];

        return allPalindromes(s, cache, memo, new HashSet<>(), 0, s.length() - 1);
    }

    public List<String> allPalindromes(String s, List<String> cache, boolean[][] memo, Set<String> notPalindromeSet, int start, int end) {

        if (start > end || end >= s.length()) {
            return cache;
        }
        if (memo[start][end]) {
            return cache;
        }


        allPalindromes(s, cache, memo, notPalindromeSet, start + 1, end);
        allPalindromes(s, cache, memo, notPalindromeSet, start, end - 1);


        boolean isPalindrome = true;
        String subsString = s.substring(start, end + 1);
        if (subsString.length() > 2) {
            if (!notPalindromeSet.contains(subsString)) {

                if (memo[start + 1][end]) {
                    isPalindrome = s.charAt(start) == s.charAt(end);
                } else {
                    for (int i = start; i < s.length(); i++) {

                        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                            isPalindrome = false;
                            break;
                        }
                    }
                }

            } else {
                isPalindrome = false;
            }


        } else if (subsString.length() == 2) {
            isPalindrome = subsString.charAt(0) == subsString.charAt(1);
        }


        if (isPalindrome) {
            cache.add(subsString);
            memo[start][end] = true;
            if (start < s.length() && end < s.length() - 1)
                memo[start][end + 1] = memo[start][end] && memo[start + 1][end + 1];
        } else {
            notPalindromeSet.add(subsString);
        }


        return cache;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings().allPlalindromes("xkjkqlajprjwefilxgpdpebieswu"));
        System.out.println(new PalindromicSubstrings().allPlalindromes("aaa"));
        System.out.println(new PalindromicSubstrings().allPlalindromes("abc"));
    }


}
