언어: Java
```.java
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] check = new int[n*n];
        int count = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int result = matrix[0][0];
        pq.offer(new Pair(0, result));
        while(!pq.isEmpty()){
            Pair _p = pq.poll();
            count++;
            if(count == k)
                return _p.value;
            if(_p.idx/n < n-1){
                if(check[_p.idx+n] == 0){
                    pq.offer(new Pair(_p.idx+n, matrix[(_p.idx+n)/n][(_p.idx+n)%n]));
                    check[_p.idx+n] = 1;
                }
            }
            if(_p.idx%n < n-1){
                if(check[_p.idx+1] == 0){
                    pq.offer(new Pair(_p.idx+1,matrix[(_p.idx+1)/n][(_p.idx+1)%n]));
                    check[_p.idx+1] = 1;
                }
            }                  
        }
        return result;
    }
}

class Pair implements Comparable<Pair> {
    int idx;
    int value;
    
    public Pair(int i, int v){
        this.idx = i;
        this.value = v;
    }
    
    @Override
    public int compareTo(Pair target){
        return this.value >= target.value? 1:-1;
    }
}
```
