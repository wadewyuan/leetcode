package com.leetcode.medium;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note: The solution set must not contain duplicate triplets.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *     [-1, 0, 1],
 *     [-1, -1, 2]
 * ]
 *
 * Created by wadey on 11/6/2016.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j+1]) j++;
                        while (j < k && nums[k] == nums[k-1]) k--;
                        j++;
                        k--;
                    } else if (sum > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
//        Set<String> triplets = new HashSet<>();
//        int l = 0, r = nums.length - 1;
//        while (l < nums.length - 1) {
//            for (int m = l + 1; m < r; ) {
//                int sum = nums[l] + nums[m] + nums[r];
//                String t = "" + nums[l] + nums[m] + nums[r];
//                if(sum == 0) {
//                    if(!triplets.contains(t)) {
//                        result.add(Arrays.asList(nums[l], nums[m], nums[r]));
//                        triplets.add(t);
//                    }
//                    r--;
//                    m++;
//                } else if (sum > 0) {
//                    r--;
//                } else {
//                    m++;
//                }
//            }
//            l++;
//            r = nums.length - 1;
//        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new ThreeSum().threeSum(new int[] {-1, 0, 1, 0, 0}));
        System.out.println(new ThreeSum().threeSum(new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0})); // [[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
//        System.out.println(new ThreeSum().threeSum(new int[] {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6}));
    }
}
