function isValidSudoku(board: string[][]): boolean {
  // 배열 요소들의 값 : boolean 형태로 저장
  interface RepeatFlag {
    [value: string]: boolean;
  }
  // 중첩 객체
  interface Memo {
    [index: number]: RepeatFlag;
  }

  let rowMemo: Memo = {};
  let columnMemo: Memo = {};
  let subBoxMemo: RepeatFlag = {}; // 9개 부분 박스 메모 Hash Map

  let i: number = 0; // 세로
  let j: number = 0; // 가로
  let jMax: number = 2; // 가로의 현재 최대값

  while (i < 9 && j < 9) {
    // cannot read ... of undefined Error 방지
    rowMemo[i] = rowMemo[i] ?? {}; // Null 병합 연산자 (Nullish coalescing operator)

    while (j <= jMax) {
      // cannot read ... of undefined Error 방지
      columnMemo[j] = columnMemo[j] ?? {};

      // 각 Hash Map 에 key 로 써줄 값 저장
      const currentValue: string = board[i][j];

      if (currentValue !== ".") {
        // 중복 감지 => return false
        if (
          rowMemo[i][currentValue] ||
          columnMemo[j][currentValue] ||
          subBoxMemo[currentValue]
        )
          return false;

        // 새 Memo
        rowMemo[i][currentValue] = true;
        columnMemo[j][currentValue] = true;
        subBoxMemo[currentValue] = true;
      }

      // 부분 Box 초기화
      if (j === jMax && (i + 1) % 3 === 0) subBoxMemo = {};

      j++;
    }
    i++;

    if (i === 9) {
      jMax += 3;
      i = 0;
    }

    j = jMax - 2;
  }

  return true;
}
