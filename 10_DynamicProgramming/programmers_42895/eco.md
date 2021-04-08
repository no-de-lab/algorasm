Link : https://programmers.co.kr/learn/courses/30/lessons/42895/

Language : JavaScript

Time Complexity : O(N^4)

Space Complexity : O(N)


```javascript

function solution(N, number) {
    const dp = new Array(9).fill(0).map(() => new Set());

    for (let i = 1; i < 9; i++) {
        dp[i].add('1'.repeat(i) * N); // 5, 55, 555, 5555 넣어줌

        for (let j = 1; j < i; j++) {
            for (const arg1 of dp[j]){
                for (const arg2 of dp[i - j]) {
                    dp[i].add(arg1 + arg2);
                    dp[i].add(arg1 - arg2);
                    dp[i].add(arg1 * arg2);
                    dp[i].add(arg1 / arg2);
                }
            }
        }
        if (dp[i].has(number)) return i;
    }
    return -1;
}

console.log(solution(5, 12));
```
