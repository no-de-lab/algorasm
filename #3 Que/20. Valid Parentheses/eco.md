언어 : TypeScript

```typescript
function isValid(s: string): boolean {
    const stackA = s.split('');
    const stackB = [];
    const map = new Map();
    map.set('{', '}');
    map.set('[', ']');
    map.set('(', ')');

    
    while (stackA.length) {
        const current = stackA.pop();
        
        if (map.get(stackA[stackA.length - 1]) === current) {
            stackA.pop();
            continue;
        }
        
        if (stackB.length && map.get(current) === stackB[stackB.length - 1]) {
            stackB.pop();
            continue;
        }
        
        stackB.push(current);
    }
    
    return stackB.length === 0;
};
```
