...java
class Solution {
    int[] _s;
    int[] _e;
    int[] _p;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        _s = new int[len];
        _e = new int[len];
        _p = new int[len];
        mergeSort(0, len-1, startTime, endTime, profit);
        int[] maxProfit = new int[endTime[len-1]+1];
        int mpCnt = 1;
        int etCnt = 0;
        maxProfit[0] = 0;
        while(mpCnt <= endTime[len-1] && etCnt <= len-1){
            if(mpCnt < endTime[etCnt]){
                maxProfit[mpCnt] = maxProfit[mpCnt] > maxProfit[mpCnt-1] ? maxProfit[mpCnt] : maxProfit[mpCnt-1];
                mpCnt++;
            }
            else{
                int now = maxProfit[startTime[etCnt]] + profit[etCnt];
                if(maxProfit[mpCnt] > maxProfit[mpCnt-1])
                    maxProfit[mpCnt] = maxProfit[mpCnt] > now ? maxProfit[mpCnt] : now;
                else
                    maxProfit[mpCnt] = maxProfit[mpCnt-1] > now ? maxProfit[mpCnt-1] : now;
                etCnt++;
            }
        }
        System.out.println();
        return maxProfit[endTime[len-1]];
    }
    
    public void mergeSort(int start, int end, int[] A, int[] B, int[] C){
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(start, mid, A, B, C);
            mergeSort(mid+1, end, A, B, C);
            
            int p = start;
            int q = mid + 1;
            int idx = p;
            
            while(p<=mid || q<=end){
                if(q>end || (p<=mid && B[p]<B[q])){
                    _s[idx] = A[p];
                    _e[idx] = B[p];
                    _p[idx] = C[p];
                    idx++;
                    p++;
                } else {
                    _s[idx] = A[q];
                    _e[idx] = B[q];
                    _p[idx] = C[q];
                    idx++;
                    q++;
                }
            }
            
            for(int i=start; i<=end; i++){
                A[i] = _s[i];
                B[i] = _e[i];
                C[i] = _p[i];
            }
        }
    }
}
...
