언어: TypeScript

```javascript
function isNumeric(data : string) : boolean {
    return !isNaN(Number(data));
}

function calculate(s: string): number {
    const args: any[] = [];
    let splits: string[] = s.split("");
    splits = splits.filter(el => el !== ' ');
    let num = '';
    splits.map((el, index) => {
        if (isNumeric(el)) {
            num += el;

            if (index === splits.length - 1) {
                args.push(+num);
            }
        } else {
            args.push(+num);
            args.push(el);
            num = '';
        }
    });

    const stack: number[] = [];
    stack.push(args[0]);
    args.map((el, index) => {
        switch (el) {
            case '+':
                stack.push(args[index + 1]);
                break;
            case '-':
                stack.push(-args[index + 1]);
                break;
            case '*':
            case '/':
                const value = stack?.pop();
                if (value) {
                    if (el === '*') {
                        stack.push(value * args[index + 1]);
                    } else {
                        const devide = '' + value / args[index + 1];
                        stack.push(parseInt(devide));
                    }
                }
                break;
        }
    });

    let sum = 0;
    while (stack.length) {
        const value = stack.pop();
        if (value) {
            sum += value;
        }
    }


   return sum;
};
```
