언어: 타입스크립트


```typescript
function uniquePaths(m: number, n: number): number {
  const board = [];

  for (let i = 0; i < m; i++) {
    const boardLine = new Array(n);
    board.push(boardLine);
  }
  for (let i = 0; i < m; i++) {
    board[i][0] = 1;
  }

  for (let i = 1; i < n; i++) {
    board[0][i] = 1;
  }

  // 아래로 내려가면서
  for (let i = 1; i < m; i++) {
    // 오른쪽으로 더해감
    for (let j = 1; j < n; j++) {
      board[i][j] = board[i - 1][j] + board[i][j - 1];
    }
  }
  
  return board[m - 1][n - 1];
}
```
