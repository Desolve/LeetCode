/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// From D_shaw
// The sorting would NOT affect the result
// The idea is that for the result distinct Interval, the latter one's start must > previous one's end.
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }
}
/*
class Solution {
    class compareStart implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        
        Collections.sort(intervals, new compareStart());
        List<Interval> res = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for (Interval i : intervals) {
            if (i.start <= end) {
                end = Math.max(end, i.end);
            } else {
                res.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}*/

/* Faster solution by elog2n
// Use array to log all intervals, 0 -> none, 1 -> in interval, 2 -> start point
// The memory/time space would be determined by interval's min point and max point's difference

class Solution {
     public List<Interval> merge(List<Interval> intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(Interval current : intervals) {
            if(current.start < min){
                min = current.start;
            }

            if(current.end > max){
                max = current.end;
            }
        }

        byte[] mergeArray = new byte[max - min + 1];
        List<Interval> output = new ArrayList<>();

        for(Interval current : intervals){
            if(mergeArray[current.start - min] != 1){
                mergeArray[current.start - min] = 2;
            }

            for(int i = current.start + 1; i <= current.end; i++){
                mergeArray[i - min] = 1;
            }
        }

        int currentStart = -1;
        int currentEnd = -1;
        for(int i = 0; i < mergeArray.length; i++){
            if(mergeArray[i] > 1){
                if(currentStart == -1){
                    currentStart = i;
                    currentEnd = i;
                } else {
                    output.add(new Interval(currentStart + min, currentEnd + min));
                    currentStart = i;
                    currentEnd = i;
                }
            } else if(mergeArray[i] == 1){
                currentEnd = i;
            }
        }

        if(currentEnd != -1){
            output.add(new Interval(currentStart + min, currentEnd + min));
        }

        return output;
    }
}
*/