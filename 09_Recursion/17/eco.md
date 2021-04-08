Link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Language : JavaScript

Time Complexity : O(N^N)

Space Complexity : O(N^N)


```javascript
const map = {
    2: ['a', 'b', 'c'],
    3: ['d', 'e', 'f'],
    4: ['g', 'h', 'i'],
    5: ['j', 'k', 'l'],
    6: ['m', 'n', 'o'],
    7: ['p', 'q', 'r', 's'],
    8: ['t', 'u', 'v'],
    9: ['w', 'x', 'y', 'z']
}

/**
 * @param {string} digits
 * @return {string[] | void}
 */
const letterCombinations = function(
    digits,
    combinations = [],
    currentIndex = 0,
    currentCombination = ""
) {
    if (digits.length > 0) {
        if (digits.length === currentIndex) {
            combinations.push(currentCombination);
            return;
        }
        const digit = digits[currentIndex];
        const alphabets = map[digit];

        for (let i = 0; i < alphabets.length; i++) {
            const newCombination = `${currentCombination}${alphabets[i]}`
            letterCombinations(digits, combinations, currentIndex + 1, newCombination);
        }
    }

    return combinations;
};
```
