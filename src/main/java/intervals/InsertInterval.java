package intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of intervals, and an interval, merge, the given one into the list.
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

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

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        boolean wasInserted = false;
        List<Interval> newIntervals = new ArrayList<>();
        while (i < intervals.size()) {
            if (!intersectWith(newInterval, intervals.get(i))) {
                if (!wasInserted && newInterval.start < intervals.get(i).start) {
                    newIntervals.add(newInterval);
                    wasInserted = true;
                } else {
                    newIntervals.add(intervals.get(i));
                    i++;
                }
            } else {
                List<Interval> intersectingIntervals = new ArrayList<>();
                intersectingIntervals.add(newInterval);
                intersectingIntervals.add(intervals.get(i));
                i += 1;
                while (i < intervals.size() && intersectWith(newInterval, intervals.get(i))) {
                    intersectingIntervals.add(intervals.get(i));
                    i++;
                }
                newIntervals.add(merge(intersectingIntervals));
                wasInserted = true;
            }
        }
        if (!wasInserted) {
            newIntervals.add(newInterval);
        }
        return newIntervals;
    }

    public static boolean intersectWith(Interval left, Interval right) {
        Interval small = left.start <= right.start ? left: right;
        Interval big = left.start <= right.start ? right: left;
        return big.start >= small.start && big.start <= small.end;
    }

    public static Interval merge(List<Interval> intervals) {
        int small = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (Interval interval: intervals) {
            if (interval.start < small) {
                small = interval.start;
            }
            if (interval.end > end) {
                end = interval.end;
            }
        }
        return new Interval(small, end);
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1, 2);
        Interval i2 = new Interval(3, 5);
        Interval i3 = new Interval(6, 7);
        Interval i4 = new Interval(8, 10);
        Interval i5 = new Interval(12, 16);
        List<Interval> is = new ArrayList<>();
        is.add(i1);
        is.add(i2);
        is.add(i3);
        is.add(i4);
        is.add(i5);

        Interval i6 = new Interval(1, 5);
        List<Interval> is2 = new ArrayList<>();
        is2.add(i6);
        System.out.println(insert(is2, new Interval(2, 3)));
    }
}
