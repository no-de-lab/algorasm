언어: Java\n
시간복잡도: O(n)\n
공간복잡도: O(n)

```.java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int front = 0;
        int rear = nums.length - 1;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[rear] >= nums[front]*(-1)){
                result[i] = nums[rear]*nums[rear];
                rear--;
            } else {
                result[i] = nums[front]*nums[front];
                front++;
            }
        }
        return result;
    }
}
```
