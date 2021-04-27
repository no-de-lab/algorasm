Link : https://leetcode.com/problems/word-break/

Language : JavaScript

```javascript
/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
        if (s.length === 1) return s;

        const dp = {};
        let longestPalindrome = s[0];

        for (let i = 0; i < s.length; i++) {
            const currentChar = s[i];
            dp[i] = [currentChar];

            for (let j = 0; j < i; j++) {
                const currentArray = dp[j];
                currentArray.push(currentChar);

                if (currentArray[0] === currentChar && isArrayPalindrome(currentArray)) {
                    longestPalindrome = longestPalindrome.length > currentArray.length ? longestPalindrome : currentArray.join('');
                }
            }
        }

        return longestPalindrome;
    };


const isArrayPalindrome = (array) => {
    let left = 0;
    let right = array.length - 1;

    while (left < right) {
        if (array[left] !== array[right]) {
            return false;
        }
        left++;
        right--;
    }

    return true;
}
```
