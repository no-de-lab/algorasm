class Solution {
    public int removeDuplicates(int[] nums) {
        int flag = 0;
        for (int i = 1; i < nums.length; i++) 
            if (nums[flag] != nums[i]) 
                nums[++flag] = nums[i];
        return flag+1;
    }
}