package com.leetcode.easy;

/**
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * @author wadey
 *
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if(str == null || str.trim().isEmpty()) {
            return 0;
        }
        boolean isNegative = false;
        String d = str.trim();
        if(d.charAt(0) == '-') {
            isNegative = true;
            d = d.substring(1);
        } else if(d.charAt(0) == '+') {
            d = d.substring(1);
        } else if(d.charAt(0) < '0' || d.charAt(0) > '9') {
            return 0; // first character is invalid
        }
        int result = 0;
        long p = 1; // power of 10, define as long to avoid integer overflow
        for(int i = d.length() - 1; i >= 0; i--) {
            char c = d.charAt(i);
            if(c >= '0' && c <= '9') {
                long num = (c - 48) * p;
                if(num > Integer.MAX_VALUE) {
                    num = Integer.MAX_VALUE;
                } else {
                    p *= 10;
                }
                if(!isNegative) {
                    if((Integer.MAX_VALUE - result >= num)) {
                        result += num;
                    } else {
                        result = Integer.MAX_VALUE;
                    }
                } else {
                    if(result == 0 || result - Integer.MIN_VALUE >= num) {
                        result -= num;
                    } else {
                        result = Integer.MIN_VALUE;
                    }
                }
            } else {
                // one invalid character detected, reset the result and continue loop
                result = 0;
                p = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "    10522545459"; // fixed
        System.out.println(new StringToInteger().myAtoi(input));
        System.out.println(Integer.parseInt(input));
    }
}
