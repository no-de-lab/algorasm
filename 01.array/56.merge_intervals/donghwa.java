class Solution {
    public int[][] merge(int[][] intervals) {
        int num = 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        for(int i=1;i<intervals.length;i++){
            if(intervals[num][1]>=intervals[i][0]){
                if(intervals[num][1]<intervals[i][1])
                    intervals[num][1] = intervals[i][1];
            }
            else{
                num++;
                intervals[num][0] = intervals[i][0];
                intervals[num][1] = intervals[i][1];
            }
        }
        intervals = Arrays.copyOf(intervals, num+1);
        return intervals;
    }
}
