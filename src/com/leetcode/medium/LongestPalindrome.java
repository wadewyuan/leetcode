package com.leetcode.medium;

import java.util.Random;

/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * @author wadey
 *
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        String ans = "";
        if(s.length() == 1) {
            return s;
        }
        /* Dynamic Programming */
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = (s.charAt(i) == s.charAt(j)) && (i - j < 3 || dp[j + 1][i - 1]);
                // System.out.println(ret);
                if (dp[j][i] && (i - j + 1) > ans.length()) {
                    ans = s.substring(j, i + 1);
                }
            }
        }
        return ans;
    }

    static boolean isPalindrome(String s) {
        int l = s.length();
        for(int i = 0; i <= l/2; i++) {
            if(s.charAt(i) != s.charAt(l-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int max=122;
        int min=65;
        int counter = 0;
        long totalTime = 0;
//        System.out.println(longestPalindrome("aa"));
        while(counter <= 100){
            counter++;
            Random random = new Random();
            char[] randStr = new char[1000];
            for(int i = 0; i < randStr.length; i++) {
                randStr[i] = ((char)(random.nextInt(max)%(max-min+1) + min));
            }
            String s = String.copyValueOf(randStr);
            long beginMillis = System.currentTimeMillis();
            System.out.println(longestPalindrome(s));
            long endMillis = System.currentTimeMillis();
            totalTime += (endMillis - beginMillis);
        }
        System.out.println("Total time: " + totalTime);
    }

}
