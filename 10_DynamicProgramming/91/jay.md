Language : Typescript

1. 런타임 에러(메모리)

문제가 말하는대로 문자별로 배열을 만들어서 각 경우별로 dp에 경우의 수를 더해줬는데 메모리 아웃이 떴습니다.
   아무래도 forEach를 개선해야 될 것 같아요.
```typescript
interface stringObject {
    [key: string]: string;
}

const decodeMapper: stringObject = {
    "1": "A",
    "2": "B",
    "3": "C",
    "4": "D",
    "5": "E",
    "6": "F",
    "7": "G",
    "8": "H",
    "9": "I",
    "10": "J",
    "11": "K",
    "12": "L",
    "13": "M",
    "14": "N",
    "15": "O",
    "16": "P",
    "17": "Q",
    "18": "R",
    "19": "S",
    "20": "T",
    "21": "U",
    "22": "V",
    "23": "W",
    "24": "X",
    "25": "Y",
    "26": "Z"
};

function numDecodings(s: string): number {
    if (s.charAt(0) === "0") {
        return 0;
    }

    if (s.length === 1) {
        return 1;
    }

    const dp = new Array(s.length);

    for (let i = 0; i < dp.length; i++) {
        dp[i] = [];
    }

    const input = s.split("");
    dp[0].push(decodeMapper[input[0]]);
    if (decodeMapper[input[1]]) {
        dp[1].push(decodeMapper[input[1]]);
    }

    if (decodeMapper[input[0] + input[1]]) {
        dp[1].push(decodeMapper[input[0] + input[1]]);
    }

    for (let i = 2; i < dp.length; i++) {
        const current = input[i];
        const prev = input[i - 1];

        const combinedWord = decodeMapper[prev + current];
        if (combinedWord) {
            dp[i - 2].forEach((words: string) => {
                dp[i].push(words + combinedWord);
            });
        }

        const currentWord = decodeMapper[current];

        if (currentWord) {
            dp[i - 1].forEach((words: string) => {
                dp[i].push(words + currentWord);
            });
        }
    }

    return dp[s.length - 1].length;
}
```

2. 성공!
   
   Set으로 변경하고 어짜피 forEach가 각 경우의 수를 돌려주는거니까 count를 더해주기만 하면 될 것 같아서 dp[i-1]과 dp[i-2]를 각 조건에 맞으면 dp[i]에 더해줬습니당
```typescript
const decodeSet = new Set([
  "1",
  // 2 ~ 25
  "26"
]);
function numDecodings(s: string): number {
  if (s.charAt(0) === "0") {
    return 0;
  }

  if (s.length === 1) {
    return 1;
  }

  const dp = new Array(s.length + 1).fill(0);

  const input = s.split("");
  dp[0] = 1;

  if (decodeSet.has(input[1])) {
    dp[1] = 1;
  }

  for (let i = 2; i <= dp.length; i++) {
    const current = input[i - 1];
    const prev = input[i - 2];

    if (decodeSet.has(prev + current)) {
      dp[i] += dp[i - 2];
    }

    if (decodeSet.has(current)) {
      dp[i] += dp[i - 1];
    }
  }

  return dp[s.length];
}
```
