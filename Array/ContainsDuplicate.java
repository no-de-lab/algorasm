class Solution {
    public boolean containsDuplicate(int[] nums) {
       if(nums.length == 1) return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, 0);
        }
        
        return false;
    }
}
