package com.leetcode.hard;

/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * @author wadey
 *
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int j = 0;
        boolean asteriskMatch = false;
        for(int i = 0; i < p.length(); i++) {
            if(i >= p.length() - 1 && j < s.length() - 1) {
                return false; // pattern is complete, but string still remains
            }
            if(p.charAt(i) != '*') {
                if((i + 1 < p.length()) && p.charAt(i + 1) == '*') {
                    asteriskMatch = true;
                    for(; j < s.length(); ) {
                        if(!isCharMatch(s.charAt(j), p.charAt(i))) {
                            asteriskMatch = false;
                            break;
                        } else {
                            j++;
                        }
                    }
                } else {
                    if(j >= s.length() - 1 && i <= p.length() - 1) {
                        return false;
                    }
                    if(!isCharMatch(s.charAt(j++), p.charAt(i)) && !asteriskMatch) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     *
     * @param c1 input character
     * @param c2 character to match
     * @return true if c1 equals to c2 or c2 is '.'
     */
    private boolean isCharMatch(char c1, char c2) {
        return c1 == c2 || c2 == '.';
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("aaabcc", ".*c")); // failed with current code
    }
}
