package com.leetcode.easy;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 *
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 *
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 *
 * There is a more generic way of solving this problem.
 * @author wadey
 *
 */
public class PalindromeInteger {
    public boolean isPalindrome(int x) {
        // To optimize, running slow
        if(x < 0) {
            return false;
        }
        if(x < 10) {
            return true;
        }

        long n = 10;
        int c = 1;
        while (x / n > 0) {
            c++;
            n *= 10;
        }
        System.out.println(c);
        for(int i = 1; i <= c; i++, --c) {
            int a = x % 10;
            int b = (int) (x / Math.pow(10, c - i));
            if(a != b) {
                return false;
            }
            x -= b * Math.pow(10, c - i);
            x = x / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeInteger().isPalindrome(-2147447412));
    }
}
