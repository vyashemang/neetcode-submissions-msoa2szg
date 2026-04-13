/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        if (intervals.size() <= 1) {
            return true;
        }

        intervals.sort((a, b) -> a.start - b.start);


        // sort the array 
        // Collections.sort(intervals, new Comparator<Interval> () {
        //     public int compare(Interval i1, Interval i2) {
        //         // Define your custom sorting logic here
        //         return Integer.compare(i1.start, i2.start);
        //     }
        // });

        // determine if the start of next is greater than the end of prev
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i - 1).end > intervals.get(i).start) {
                return false;
            }
        }

        return true;
    }
}
