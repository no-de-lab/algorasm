Link : https://leetcode.com/problems/median-of-two-sorted-arrays/

Language : JavaScript


최초 버전 Timecomplex : O(n + m)

nums1 과 nums2 를 모두 끝까지 traverse 하여 위와 같은 효율이 나왔다.

```javascript
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    const merged = [];
    
    // merged 에 두 배열의 요소들을 순서대로 push 해준다.
    let i = 0;
    let j = 0;
    while (i < nums1.length || j < nums2.length) {
       let cur;
       
        // 둘 중 길이가 초과된 array 가 있으면 아직 남은 array 의 요소들을 merged 에 push 하고 continue        
        if (nums1[i] === undefined || nums2[j] === undefined) {
            merged.push(nums1[i] === undefined ? nums2[j++] : nums1[i++]);
            continue;
        }
        
       // 더 적은 요소를 merged 에 push 
        if (nums1[i] <= nums2[j]) {
            cur = nums1[i];
            i++;
        } else {
            cur = nums2[j];
            j++;
        }
        
        merged.push(cur);
    }
   
    // merged 의 길이가 짝수일 경우 : 중간 값 두개의 평균을 return 
    if (merged.length % 2 === 1) return merged[Math.floor(merged.length / 2)];

    // merged 의 길이가 홀수일 경우 : 중간 값 return 
    return (merged[merged.length / 2] + merged[merged.length / 2 - 1]) / 2;
    
};
```

수정 버전 Timecomplex : O(log(n + m))

merged 를 `(nums1.length + nums2.length) / 2` (절반) 만큼만 traverse 하면 훨씬 효율적으로 median 을 구할 수 있다.

```javascript
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    const merged = [];
    const sumLength = nums1.length + nums2.length;
    const midLength = sumLength / 2;
    
    let i = 0;
    let j = 0;
    // midLength (중간 길이) 만큼만 사용한다. 
    while (merged.length <= midLength) {
       let cur;
        
        if (nums1[i] === undefined || nums2[j] === undefined) {
            merged.push(nums1[i] === undefined ? nums2[j++] : nums1[i++]);
            continue;
        }
        
        
        if (nums1[i] <= nums2[j]) {
            cur = nums1[i];
            i++;
        } else {
            cur = nums2[j];
            j++;
        }
        
        merged.push(cur);
    }
    
    // nums1 과 nums2 의 길이의 합이 짝수일 경우 => merged 의 마지막 수가 median 임
    if (sumLength % 2 === 1) return merged[merged.length - 1];
    
    // 홀수일 경우 => merged 의 마지막 수와 그 앞의 수의 중간값이 median 임
    return (merged[merged.length - 1] + merged[merged.length - 2]) / 2;
    
};
```
