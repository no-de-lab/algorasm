```javascript
const big = 111111;
function solution(N, number) {
    let answer = describe(N, number, 0, 0);
    if(answer == big){
        answer = -1
    }
    return answer;
}

function describe(N, number, count, res){
    if(count > 8) return INF
    if(number == res) return count;
    
    let next = 0;
    let num = big;
    
    for(let i = 1; i<=8;i++){
        
        next = (next * 10) + N
        
        num = Math.min(num, describe(N, number, count + i, res + next))
        num = Math.min(num, describe(N, number, count + i, res - next))
        num = Math.min(num, describe(N, number, count + i, res / next))
        num = Math.min(num, describe(N, number, count + i, res * next))
    }
    
    return num;
}
```