class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int a = 0;
        for(int i=0;i<len;i++){
            if(nums[i] == 0){
                a++;
            } else {
                nums[i-a] = nums[i];
            }
        }
        for(int i=0;i<a;i++){
            nums[len-i-1] = 0;
        }
    }
}