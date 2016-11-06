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
        if(nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        Set<String> triplets = new HashSet<>();
        int l = 0, r = nums.length - 1;
        while (l < r) {
            for (int m = l + 1; m < r; ) {
                int sum = nums[l] + nums[m] + nums[r];
                String t = "" + nums[l] + nums[m] + nums[r];
                if(sum == 0 && !triplets.contains(t)) {
                    result.add(Arrays.asList(nums[l], nums[m], nums[r]));
                    triplets.add(t);
                } else if (sum > 0) {
                    r--;
                    continue;
                }
                m++;
            }
            l++;
//            r = nums.length - 1;
        }
        return result;
//        List<Integer> zeros = new ArrayList<>(), negative = new ArrayList<>(), positive = new ArrayList<>();
//        for(int n : nums) {
//            if(n == 0) {
//                zeros.add(n);
//            } else if (n < 0) {
//                negative.add(n);
//            } else {
//                positive.add(n);
//            }
//        }
//        if(zeros.size() >= 3) {
//            result.add(zeros.subList(0, 3));
//        }
//
//        if(zeros.size() > 0) {
//            Set<Integer> nSet = new HashSet<>();
//            for(int n : negative) {
//                if(positive.size() < 1) {
//                    break;
//                }
//                if(!nSet.contains(n) && positive.contains(0 - n)) {
//                    nSet.add(n);
//                    result.add(Arrays.asList(n, 0, 0 - n));
//                }
//            }
//        }
//
//        Set<String> combo = new HashSet<>();
//        int n = negative.size(), p = positive.size();
//        if(n > 0 && p > 0 && n + p >= 3) {
//            for (int i = 0; n > 1 && i < n; i++) {
//                for(int j = i + 1; j < n; j++) {
//                    int n1 = negative.get(i), n2 = negative.get(j);
//                    String c = "" + n1 + n2;
//                    if(!combo.contains(c) && positive.contains(0 - n1 - n2)) {
//                        combo.add(c);
//                        result.add(Arrays.asList(n1, n2, 0 - n1 - n2));
//                    }
//                }
//            }
//
//            for (int i = 0; p > 1 && i < p; i++) {
//                for(int j = i + 1; j < p; j++) {
//                    int p1 = positive.get(i), p2 = positive.get(j);
//                    String c = "" + p1 + p2;
//                    if(!combo.contains(c) && negative.contains(0 - p1 - p2)) {
//                        combo.add(c);
//                        result.add(Arrays.asList(p1, p2, 0 - p1 - p2));
//                    }
//                }
//            }
//        }
    }

    public static void main(String[] args) {
//        System.out.println(new ThreeSum().threeSum(new int[] {-1, 0, 1, 0, 0}));
        System.out.println(new ThreeSum().threeSum(new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0})); // [[0, 0, 0], [-4, 0, 4], [-2, -2, 4], [1, 1, -2], [1, 3, -4], [1, 4, -5]]
//        System.out.println(new ThreeSum().threeSum(new int[] {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6}));
    }
}
