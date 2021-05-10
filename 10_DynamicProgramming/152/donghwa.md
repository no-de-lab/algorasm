언어: 자바


```java
class Solution {
    public int maxProduct(int[] nums) {
        int result = -11;
        int len = nums.length;
        int[] max = new int[len*2];
        boolean check = false;
        max[0] = max[len] = nums[0];
        for(int i=0; i<len-1; i++){
            if(nums[i] == 0){
                max[i+1] = nums[i+1];
                max[len+i+1] = nums[i+1];
                check = false;
                continue;
            }
            if(nums[i]<0 && check==false){
                max[i+1] = max[i]*nums[i+1];
                max[len+i+1] = nums[i+1];
                check = true;
            } else {
                max[i+1] = max[i]*nums[i+1];
                max[len+i+1] = max[len+i]*nums[i+1];
            }
        }
        for(int i=0; i<max.length; i++){
            if(max[i] > result)
                result = max[i];
        }
        return result;
    }
}
```
