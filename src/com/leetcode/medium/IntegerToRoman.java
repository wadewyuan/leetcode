package com.leetcode.medium;

/**
 * Given an integer, convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Created by wadey on 11/5/2016.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        String s = "";
        if(num > 0 && num <= 3999) {
            int tmp = num, p = 1000;
            while (tmp > 0) {
                int n = tmp / p;
                s += convertRoman(n, p);
                tmp -= n * p;
                p /= 10;
            }
        }
        return s;
    }

    /**
     *
     * @param n digit
     * @param p power of 10
     * @return
     */
    private String convertRoman(int n, int p) {
        String r = "";
        if(n < 4) {
            for( int i = 0; i < n; i++) {
                if(p == 1000) {
                    r += "M";
                } else if(p == 100) {
                    r += "C";
                } else if(p == 10) {
                    r += "X";
                } else if(p == 1) {
                    r += "I";
                }
            }
        } else if(n == 5) {
            if(p == 1000) {
                // none
            } else if(p == 100) {
                r = "D";
            } else if(p == 10) {
                r = "L";
            } else if(p == 1) {
                r = "V";
            }
        } else if(n == 4) {
            r = convertRoman(1, p) + convertRoman(5, p);
        } else if(n == 9) {
            r = convertRoman(1, p) + convertRoman(1, p * 10);
        } else if(n > 5) {
            r = convertRoman(5, p) + convertRoman(n - 5, p);
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(4));
//        System.out.println(new IntegerToRoman().convertRoman(8, 1));
    }
}
