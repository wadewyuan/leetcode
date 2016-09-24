package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 * You may assume that each input would have exactly one solution.

 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,

 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * @author wadey
 *
 */

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        /* Regular solution */
//        int a = 0, b = 0, counter = 0;
//        boolean solved = false;
//        for(int i=0; i < nums.length; i++) {
//            counter++;
//            a = i;
//            for(int j = 0; j < nums.length; j++) {
//                counter++;
//                if(a != j && nums[a] + nums[j] == target) {
//                    b = j;
//                    solved = true;
//                    break;
//                }
//            }
//            if(solved) {
//                break;
//            }
//        }
        /* Solution 2 */
//        int a = 0,
//            b = 0,
//            counter = 0;
//        boolean solved = false;
//        for(int i=0; i < nums.length; i++) {
//            counter++;
//            for(int j = nums.length-1; j > i; j--) {
//                counter++;
//                if(nums[i] + nums[j] == target) {
//                    a = i;
//                    b = j;
//                    solved = true;
//                    break;
//                }
//            }
//            if(solved) {
//                break;
//            }
//        }
        /* HashMap solution */
        int a = 0,
            b = 0,
            counter = 0;
        Map<Integer, Integer> numsIndices = new HashMap<Integer, Integer>();
        for(int i=0; i < nums.length; i++) {
            counter++;
            int rest = target - nums[i];
            if(numsIndices.get(rest) != null) {
                a = i;
                b = numsIndices.get(rest);
                break;
            } else {
                numsIndices.put(nums[i], i);
            }
        }
        System.out.println(String.format("loop count: %d", counter));
        return new int[] {a, b};
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;
        int[] res = twoSum(nums, target);
        System.out.println(String.format("number a: %d, number b: %d", res[0], res[1]));
    }
}
