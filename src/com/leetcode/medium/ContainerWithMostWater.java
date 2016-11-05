package com.leetcode.medium;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 *  Note: You may not slant the container.
 *
 * Created by wadey on 11/2/2016.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null || height.length < 2) {
            return  0;
        }
        int l = 0, r = height.length - 1, result = 0;
        while (l < r) {
            result = Math.max(result, (r - l) * Math.min(height[l], Math.min(height[r], height[l])));
            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(new ContainerWithMostWater().maxArea(new int[]{50, 10, 1, 1, 1, 1, 1, 1}));
    }
}
