package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        return allPlalindromes(s, cache,new HashMap<>(), 0, s.length() - 1);
    }

    public List<String> allPlalindromes(String s, List<String> cache, Map<String, String> memo, int start, int end) {

        if(memo.containsKey(start+","+end)){
            return cache;
        }
        if (start > end || end >= s.length()) {
            return cache;
        }

        allPlalindromes(s, cache,memo, start + 1, end);
        allPlalindromes(s, cache,memo, start, end - 1);

        boolean isPalindrome = true;
        String subsString = s.substring(start,end+1);
        for (int i = 0; i < subsString.length(); i++) {
            if(memo.containsKey(i+","+(subsString.length()-i-1))){
                continue;
            }
            if (subsString.charAt(i) != subsString.charAt(subsString.length()-i-1)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            cache.add(subsString);
            memo.put(start+","+end, subsString);
        }



        return cache;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings().allPlalindromes("aaa"));
    }


}
