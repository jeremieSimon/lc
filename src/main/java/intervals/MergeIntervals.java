package intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * Given a collection of intervals, merge all overlapping intervals.
 *
 */
public class MergeIntervals {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1,
                Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start == o2.start) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        if (intervals.size() <= 1) {
            return intervals;
        }
        Interval start = intervals.get(0);
        List<Interval> solutions = new ArrayList<>();
        for (int i = 1; i < intervals.size(); i++) {
            if (mergeable(start, intervals.get(i))) {
                start = merge(start, intervals.get(i));
            } else {
                solutions.add(start);
                start = intervals.get(i);
            }
        }
        solutions.add(start);
        return solutions;
    }

    static boolean mergeable(Interval a, Interval b) {
        if (a.end >= b.start && a.end <= b.end) {
            return true;
        } else if (b.end <= a.end) {
            return true;
        }
        return false;
    }

    static Interval merge(Interval a, Interval b) {
        int start = Math.min(a.start, b.start);
        int end = Math.max(a.end, b.end);
        return new Interval(start, end);
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>(); //1,3],[2,6],[8,10],[15,18],
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        System.out.println(merge(intervals));
     }
}
