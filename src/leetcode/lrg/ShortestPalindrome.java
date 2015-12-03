package leetcode.lrg;

/**
 * Created by programmer on 11/7/15.
 */
public class ShortestPalindrome {
    public String shortestpalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) == s.charAt(j)) j++;
        if (j == s.length()) return s;
        else return new StringBuilder(s.substring(j)).reverse()
                + shortestpalindrome(s.substring(0, j))
                + s.substring(j);
    }
}
