package com.leetcode.easy;

/**
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * @author wadey
 *
 */
public class ReverseInteger {
    public int reverse(int x) {
        String s = String.valueOf(x);
        boolean isNegative = false;
        if(s.startsWith("-") || s.startsWith("+")) {
            s = s.substring(1);
            isNegative = (s.charAt(0) == '-');
        }
        if(s.length() > 1) {
            char[] c = s.toCharArray();
            char[] c1 = new char[c.length];
            for(int i = c.length - 1; i >= 0; i--) {
                c1[c1.length - 1 - i] = c[i];
            }
            s = String.copyValueOf(c1);
            if(isNegative) {
                s = "-" + s;
            }
            int result = 0;
            try {
                result = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Integer overflows");
            }
            return result;
        } else {
            return x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(+102));
    }
}
