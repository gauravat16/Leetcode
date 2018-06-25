package leetcode.dynamicprogramming;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * <p>
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 */

public class IsSubsquence {

    public boolean isSubsequence(String s, String t) {

        int t_len = 0, s_len = 0;

        if (t.length() == 0 && s.length() == 0) {
            return true;
        }


        if (t.length() == 0) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }


        while (t_len < t.length()) {

            if (t.codePointAt(t_len) == s.codePointAt(s_len)) {
                s_len++;

                if (s_len == s.length()) {
                    return true;
                }
            }

            t_len++;

        }


        return false;

    }


    public static void main(String[] args) {
        System.out.println(new IsSubsquence().isSubsequence("abc", "ahbgdc"));
    }


}
