/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function (nums1, nums2) {
  const intersection = [];

  const small = nums1.length < nums2.length ? nums1 : nums2;
  const big = small === nums1 ? nums2 : nums1;

  small.sort((a, b) => a - b);
  big.sort((a, b) => a - b);

  // 각각의 배열에 포인터 생성
  let i = 0;
  let j = 0;
  while (i < small.length) {
    // intersection 찾으면 push 하고 포인터 모두 이동
    if (small[i] === big[j]) {
      intersection.push(small[i]);
      i++;
      j++;
      continue;
    }
    // intersection 아닐 경우 크기 비교해 작은 쪽의 포인터만 이동
    small[i] > big[j] ? j++ : i++;
  }

  return intersection;
};
