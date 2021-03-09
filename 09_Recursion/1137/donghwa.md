언어: 자바


```.java
class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        int[] Tb = new int[n+1];
        Tb[0] = 0;
        Tb[1] = 1;
        Tb[2] = 1;
        for(int i=3; i<=n; i++)
            Tb[i] = Tb[i-1]+Tb[i-2]+Tb[i-3];
        return Tb[n];
    }
}
```
