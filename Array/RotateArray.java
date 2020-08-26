class Solution {
    public void rotate(int[] nums, int k) {
        int[] forCopy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) 
            forCopy[(i + k) % nums.length] = nums[i];
        
        for (int i = 0; i < nums.length; i++)
            nums[i] = forCopy[i];
    }
}
