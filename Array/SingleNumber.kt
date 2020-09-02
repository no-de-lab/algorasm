class Solution {
    fun singleNumber(nums: IntArray): Int {
        val map:LinkedHashMap<Int, Int> = linkedMapOf()

        for (num in nums) {
            if (map.containsKey(num))
                map[num] = map.getValue(num) + 1
            else
                map[num] = 1
        }

        for (key in map.keys) {
            if (map.getValue(key) == 1)
                return key
        }
        return -1
    }
}