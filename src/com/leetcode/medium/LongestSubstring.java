package com.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        /* String Builder */
//        int maxLength = 0;
//        StringBuilder u = new StringBuilder();
//        for(int i = 0; i < s.length(); i++) {
//            String c = String.valueOf(s.charAt(i));
//            if(u.indexOf(c) >= 0) {
//                u.delete(0, u.indexOf(c) + 1);
//            }
//            u.append(c);
//            if(u.length() > maxLength){
//                maxLength = u.length();
//            }
//        }
//        return maxLength;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int l = lengthOfLongestSubstring("dvdf");
        System.out.println(l);
    }

}
