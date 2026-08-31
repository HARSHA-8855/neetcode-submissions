class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int prevEnd = intervals[0][1];
        int removals = 0;
        for(int i = 1; i<intervals.length;i++){
            int currentstart = intervals[i][0];
            int currentend = intervals[i][1];
            if(currentstart < prevEnd){
                removals++;
                prevEnd = Math.min(currentend, prevEnd);
            }else{
                prevEnd = currentend;
            }
        }
        return removals;
        
    }
}
