class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        if (nums.isEmpty())
                return false

        val map:MutableMap<Int, Int> = mutableMapOf()
        for (num in nums) {
            if (map.containsKey(num)) 
                return true
            else
                map[num] = 1
        }
        return false
    }
}