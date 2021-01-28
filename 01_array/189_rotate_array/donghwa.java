class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        for(int i=0;i<len/2;i++){
        int temp = nums[i];
        nums[i] = nums[len-1-i];
        nums[len-1-i] = temp;
        }
        for(int i=0;i<k/2;i++){
            int temp = nums[i];
            nums[i] = nums[k-1-i];
            nums[k-1-i] = temp;
        }
        for(int i=k;i<(k+len)/2;i++){
            int temp = nums[i];
            nums[i] = nums[k+len-1-i];
            nums[k+len-1-i] = temp;         
        }
    }
}
