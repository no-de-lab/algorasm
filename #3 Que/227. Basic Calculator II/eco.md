언어 : TypeScript

```typescript
function calculate(s: string): number {
    s = s.trim();
    const stack :Array<string> = [];
    let currentNumber :string = "";
    let operation :string = "";

    for (let i = 0; i < s.length; i++) {
        if (s[i] === " ") continue;

        // s[i] 가 숫자 일 때
        if (!isNaN(parseInt(s[i]))) {
            currentNumber += s[i];
        }

        // s[i] 가 연산자 또는 마지막 수일 때
        if (i === s.length - 1 || isNaN(parseInt(s[i]))) {
            // 1. 이전 연산자에 따라 계산
            if (operation === "*") {
                const multiplied = parseInt(stack.pop() as string) * parseInt(currentNumber);
                stack.push(multiplied.toString());
            }
            if (operation === "/") {
                // @ts-ignore
                const divided = Math.trunc(parseInt(stack.pop() as string) / parseInt(currentNumber));
                stack.push(divided.toString());
            }
            if (operation === "+" || operation === "-" || !operation) {
                stack.push(operation + currentNumber);
            }
            // 2. 새연산자 저장 및 현재 숫자 초기화
            operation = s[i];
            currentNumber = "";
        }
    }

    return stack.reduce((acc, c) => {
        return parseInt(c) + acc;
    }, 0);
}

// console.log(calculate('3+2*2'));
console.log(calculate(' 3/2 '));
```
