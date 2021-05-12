Language : Typescript

1. 일반 `sort` 함수를 사용했는데 통과해서 당황했어요 ㄷㄷ<br/>
그래도 원하는 답이 이게 아닌거 같은데 방법을 못 찾아서 정답보고 풀어봤어요 ㅜ
```typescript
function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
    const combined = nums1.concat(nums2).sort((a,b) => a > b ? 1 : -1);

    const len = combined.length;
    if (len % 2 === 0) {
        return (combined[len / 2 - 1] + combined[len / 2]) / 2;
    }
    return combined[Math.floor(len / 2)];
}
```

2. 정답을 보고 푼 답입니다. 커서를 늘려가면서 더하면 되는군요 ㅜㅜ
```typescript
function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
  let len = nums1.length + nums2.length;
  let index1 = 0;
  let index2 = 0;
  let curr: number | undefined;
  let last: number | undefined;

  while (index1 + index2 <= len / 2) {
    if (curr !== undefined) {
      last = curr;
    }

    let first = nums1[index1];
    let second = nums2[index2];

    if (first === undefined) {
      curr = second;
      index2++;
      continue;
    }

    if (second === undefined) {
      curr = first;
      index1++;
      continue;
    }

    if (first < second) {
      curr = first;
      index1++;
      continue;
    }

    curr = second;
    index2++;
  }

  if (last !== undefined && curr !== undefined) {
    return len % 2 === 0 ? (last + curr) / 2 : curr;
  }

  if (curr !== undefined) {
    return curr;
  }

  return 0;
}
```