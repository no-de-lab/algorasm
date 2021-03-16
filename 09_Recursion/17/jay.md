언어: typescript

재귀적으로 숫자에 해당하는 문자열을 넣고 새로운 배열을 만들어서 문자열을 결합시켰다.
```typescript
const map = new Map();
map.set("2", ["a", "b", "c"]);
map.set("3", ["d", "e", "f"]);
map.set("4", ["g", "h", "i"]);
map.set("5", ["j", "k", "l"]);
map.set("6", ["m", "n", "o"]);
map.set("7", ["p", "q", "r", "s"]);
map.set("8", ["t", "u", "v"]);
map.set("9", ["w", "x", "y", "z"]);


function letterCombinations(digits: string): string[] {
    if (!digits) {
        return [];
    }

    return combineLetters(digits, []);
};

function combineLetters(digits: string, letters: string[]): string[] {
    if (!digits) {
        return letters;
    }

    if (!letters.length) {
        return combineLetters(digits.slice(1), map.get(digits.charAt(0)));
    }

    const newLetters: string[] = [];
    const addLetter: string[] = map.get(digits.charAt(0));
    letters.forEach(
        letter => addLetter.forEach(
            addLetter => {
            newLetters.push(letter + addLetter);
    }));

    return combineLetters(digits.slice(1), newLetters);
}
```
성공했습니다 ^-^