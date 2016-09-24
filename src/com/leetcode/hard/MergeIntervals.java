package com.leetcode.hard;

import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.

 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 * Subscribe to see which companies asked this question
 * @author wadey
 *
 */


public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        return intervals;
    }
}

class Interval {
    int start;
    int end;
    Interval() {
        start = 0; end = 0;
    }
    Interval(int s, int e) {
        start = s; end = e;
    }
}