Link : https://leetcode.com/problems/median-of-two-sorted-arrays/

Language : JavaScript


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
