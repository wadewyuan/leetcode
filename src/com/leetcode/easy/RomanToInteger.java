package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 * Created by wadey on 11/5/2016.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == null) {
                result = 0;
                System.out.println(String.format("Invalid input: %s", s));
                break;
            }
            if(i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                int l = map.get(s.charAt(i)), r = map.get(s.charAt(i+1));
                if(r / l == 10 || r / l == 5) {
                    result += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                    i++;
                } else {
                    result = 0;
                    System.out.println(String.format("Invalid input: %s", s));
                    break;
                }
            } else {
                result += map.get(s.charAt(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("ABC"));
    }
}
