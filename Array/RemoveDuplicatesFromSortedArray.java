class Solution {
    public int singleNumber(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int value = map.get(num);
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 0);
            }
        }

        for (int key: map.keySet()) {
            if (map.get(key) == 0) {
                return key;
            }
        }
        return 0;
    }
}
