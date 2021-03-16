언어: typescript
1. 첫번째로 배열을 받아서 reverse 후 concat으로 붙히는데 런타임 에러가 떴다..

2. 문자열로 바꿔서 재귀를 해봤다
```typescript
function kthGrammar(N: number, K: number): number {
    const symbol = makeSymbol(N, "0");

    return +symbol.charAt(K - 1);
};

function makeSymbol(N: number, data: string): string {
    while (N-- > 0) {
        const data2 = data.split("").map(el => el === "0" ? "1" : "0").join("");
        data = data.concat(data2);
    }
    return data;
}
```
이 또한 런타임 에러... ㅜㅜ (막막)

3. 어짜피 2의 제곱만큼 움직이니까 2의 제곱만큼 나눈 카운트를 몇번했는지 계산했다.
```typescript
function kthGrammar(N: number, K: number): number {

    let minus = Math.pow(2, N);
    let count = 0;
    while (K !== 1) {
        while (K - minus < 1) {
            minus = Math.pow(2, N--);
        }
        K = K - minus;
        count++;
    }

    return count % 2 === 0 ? 0 : 1;
};
```
최대로 2의 제곱만큼 빼면 보수가 나오지 않을까 싶어서 시도해본 방법
1이 0이니까 만약 count가 짝수가되면 0이고 홀수가 된다면 1이 될것이다 라고 생각하고 해봤는데 성공했다.
골아파 죽는줄 알았다 ㅜㅜ