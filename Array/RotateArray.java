/**
 * 런타임 1ms / 메모리 42.1MB
 * 임시배열로 넘길 인자들을 저장해두고 뒤부터 차례대로 이동 시킨 후에 임시배열에 있던 인자들을 다시 할당해줬어요!
 */

class Solution1 {
    public void rotate(int[] nums, int k) {
        
		// 배열의 크기가 3이고, 5번을 돌린다면 3번을 돌리면 원상태가 되므로, 2번만(나머지) 돌리면 되므로 k를 다시 초기화 해주면 됌
        k = k % nums.length;
        int[] temp = new int[nums.length];

        for (int i = 0; i < k; i++) {
            temp[i] = nums[nums.length - k + i];
        }

        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i-k];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}