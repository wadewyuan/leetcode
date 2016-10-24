package com.leetcode.hard;

/**
 * here are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 * @author wadey
 *
 */
public class MedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[]{};
        if(nums1.length > 0 && nums2.length > 0) {
            merged = new int[nums1.length + nums2.length];
            for(int i=0, n=0, m=0; i < merged.length; i++){
                if(n < nums1.length && (nums1[n] <= getNthElem(nums2, m) || m >= nums2.length)) {
                    merged[i] = nums1[n++];
                } else if(m < nums2.length && (nums2[m] <= getNthElem(nums1, n) || n >= nums1.length )) {
                    merged[i] = nums2[m++];
                }
            }
        } else if(nums1.length > 0) {
            merged = nums1;
        } else if(nums2.length > 0) {
            merged = nums2;
        }

        return getArrayMedian(merged);
    }

    static int getNthElem(int[] arr, int n) {
        if(n >= arr.length) {
            return arr[arr.length - 1];
        } else {
            return arr[n];
        }
    }

    static double getArrayMedian(int[] arr) {
        double median = 0;
        if(arr.length > 0) {
            int l = arr.length;
            median = l % 2 == 0 ? (double)(arr[l/2] + arr[l/2 -1])/2 : arr[(l - 1) / 2];
        }
        return median;
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1,2};
        int[] n2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(n1, n2));
    }

}
