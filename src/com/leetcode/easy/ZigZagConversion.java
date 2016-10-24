package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * @author wadey
 *
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows > 1) {
            Map<Integer, String> map = new HashMap<>();
            boolean reversed = false;
            int turns = 0; // Count of the turns in conversion
            for (int i = 0; i < s.length(); i++) {
                int mod = (i % numRows + turns) % numRows;
                int idx = mod; // Row index
                if(reversed) {
                    idx = numRows - 1 - mod; // Add character in reverse direction
                }
                // Append character to the row
                String tmp = map.get(idx) == null ? "" : map.get(idx);
                map.put(idx, tmp + s.charAt(i));
                if(i > 0 && mod == numRows - 1) {
                    // Here's a turning
                    reversed = !reversed;
                    turns++;
                }
            }
            String result = "";
            for (int j = 0; j < numRows; j++) {
                if(map.get(j) != null) {
                    result += map.get(j);
                }
            }
            return result;
        } else {
            return s; // do nothing if just one row or invalid input: 0, -1 etc.
        }
    }
}
