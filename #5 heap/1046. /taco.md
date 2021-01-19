```javascript
/**
 * @param {number[]} stones
 * @return {number}
 */
var lastStoneWeight = function (stones) {
  // heap에 insert 해서 bubble up 시켜주고
  // 만약 stones에 length가 0 이면,
  let heap = [];

  let bubbleUp = () => {
    let currentIndex = heap.length - 1;

    while (currentIndex > 0) {
      let current = heap[currentIndex];
      let parentIndex = Math.floor((currentIndex - 1) / 2);
      let parent = heap[parentIndex];

      if (parent >= current) break;
      heap[currentIndex] = parent;
      heap[parentIndex] = current;
      currentIndex = parentIndex;
    }
  };
  while (stones.length) {
    heap.push(stones.shift());
    bubbleUp();
    console.log(heap);
  }

  let extractMaxValue = () => {
    while (true) {
      if (heap[0] > heap[1]) {
        sinkDown(0);
        const max = heap[0] - heap[1];
        heap[1] = max;
        heap.shift();
      } else if (heap[0] == heap[1] && heap.length > 2) {
        sinkDown(0);
        heap.shift();
        heap.shift();
      }

      if (heap.length == 1 || (heap.length == 2 && heap[0] === heap[1])) {
        break;
      }
    }
  };
  let sinkDown = (index) => {
    let left = 2 * index + 1;
    let right = 2 * index + 2;
    let largest = index;
    const length = heap.length;

    if (left <= length && heap[left] > heap[largest]) {
      largest = left;
    }
    if (right <= length && heap[right] > heap[largest]) {
      largest = right;
    }

    if (largest !== index) {
      [heap[index], heap[largest]] = [heap[largest], heap[index]];

      sinkDown(largest);
    }
    // console.log(heap)
  };

  extractMaxValue();

  return heap.length === 1 ? heap[0] : 0;
};
```
