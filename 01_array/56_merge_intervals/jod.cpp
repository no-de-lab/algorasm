class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        int event =0;
        // 머지가 발생할 경우의 수를 다 때려박다가.. 포기했습니다. 죄송합니다.
        for(int i=0; i<intervals.size()-1; i++) {
            // if(intervals[i][0] <= intervals[i+1][0]) {
            //     intervals[i+1][0]= intervals[i][0];
            //     event=1;
            // }
            // if(intervals[i][1] >= intervals[i+1][1]) {
            //     intervals[i+1][1]= intervals[i][1];
            //     event=1;
            // }
            // if(intervals[i][0] <= intervals[i+1][1]) {
                
            // }
            // if(event==1) {
            //     intervals.erase(intervals.begin() + i);
            // }
            // event=0;
            
            if(intervals[i][1] >= intervals[i+1][0]) {
                intervals[i+1][0] = intervals[i][0];
                intervals.erase(intervals.begin() + i);
            }
        }
        return intervals;
    }
};