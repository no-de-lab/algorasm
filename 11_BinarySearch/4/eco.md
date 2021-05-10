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
    
    let i = 0;
    let j = 0;
    while (i < nums1.length || j < nums2.length) {
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
    
    if (merged.length % 2 === 1) return merged[Math.floor(merged.length / 2)];
    
    return (merged[merged.length / 2] + merged[merged.length / 2 - 1]) / 2;
    
};
```
