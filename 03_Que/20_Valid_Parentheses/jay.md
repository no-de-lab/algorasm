언어: TypeScript

```javascript
function isValid(s: string): boolean {
    const open = ["{", "[", "("];
    const close = ["}", "]", ")"];
    const parentheses = s.split("");
    const list: string[] = [];

    for (let i =0; i < parentheses.length; i++) {
        list.push(parentheses[i]);
    }

    while (list.length !== 0) {
        for (let i = 0; i < list.length; i++) {
            let index = -1;
            open.map((bracket, idx) => {
                if (bracket === list[i]) {
                    index = idx;
                }
            });

            if (index === -1) {

                if (i === list.length - 1) {
                    return false;
                }
                continue;
            }

            const closeBracket = close[index];
            if (list[i+1] === closeBracket) {
                list.splice(i, 2);
                break;
            }

            if (i === list.length - 1) {
                return false;
            }
        }
    }

    return true;
};
```
