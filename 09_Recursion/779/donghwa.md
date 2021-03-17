언어: 자바


```.java
class Solution {
    public int kthGrammar(int N, int K) {
        int prevK = (K+1)/2;
        if(N == 1) return 0;
        if(K%2 == 0){ // K가 짝수일 경우
            return (kthGrammar(N-1, prevK)+1)%2;
        } else { // K가 홀수일 경우
            return kthGrammar(N-1, prevK);
        }
    }
}
```
