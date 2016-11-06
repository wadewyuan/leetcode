package com.leetcode.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Created by wadey on 11/6/2016.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public String longestCommonPrefixBinarySearch(String[] strs) {
        if(strs == null || strs.length < 1) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for(String str : strs) {
            if (str.length() < minLen) minLen = str.length();
        }

        int l = 0, r = minLen;
        while (l < r) {
            int mid = (l + r) / 2;
            if(isCommonPrefix(strs, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return strs[0].substring(0, (l + r) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new LongestCommonPrefix().getCommonPrefix("abccddd", "abccdddc"));
        System.out.println(new LongestCommonPrefix().longestCommonPrefixBinarySearch(new String[] {
                "abccddd",
                "ab",
                "abcadddc",
                "abcedddc"
        }));
    }
}
