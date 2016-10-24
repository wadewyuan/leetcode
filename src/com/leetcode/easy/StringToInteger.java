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
        int p = 1; // power of 10
        for(int i = d.length() - 1; i >= 0; i--) {
            char c = d.charAt(i);
            if(c >= '0' && c <= '9') {
                if(Integer.MAX_VALUE / p >= c-48) {
                    int num = (c - 48) * p;
                    if(p <= Integer.MAX_VALUE / 10) {
                        p *= 10;
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
                        continue;
                    }
                }
            } else {
                result = 0;
                p = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "    10522545459"; // failed with current solution
        System.out.println(new StringToInteger().myAtoi(input));
        System.out.println(Integer.parseInt(input));
    }
}
