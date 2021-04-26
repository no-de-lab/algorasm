언어: 자바


```java
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = -100000;
        for(int i=0; i<nums.length; i++){
            if(max < nums[i]) max = nums[i];
            if(sum + nums[i] <= 0){
                sum = 0;
                continue;
            } else {
                sum += nums[i];
                if(sum > max) max = sum;
            }
        }
        return max;
    }
}
```
