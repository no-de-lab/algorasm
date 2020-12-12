// see : https://leetcode.com/problems/rotate-array/

/** 내가 푼 닶 O(n^2)
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        for(int i=0; i<k; i++) {
            int temp = nums.back(); // 마지막 원소 값 받아둠
            for(int j=nums.size()-1; j>0; j--) {
                cout<<j<<endl;
                // 한칸씩 뒤로 미룸
                nums[j] = nums[j-1];   
            }
            // 첫번째 노드에 마지막 노드의 값 삽입
            nums[0] = temp;
        }
        return;
    }
};
*/


// 해답 : O(n)
// 설명해 주실분 ㅠㅠ
void rotate(vector<int>& nums, int k) {
    int l = nums.size();
    k %= l;
    if (k==0)
        return;
    reverse(nums, 0, l-k-1);
    reverse(nums, l-k, l-1);
    reverse(nums, 0, l-1);
}

void reverse(vector<int>& nums, int l, int r) {
    while (l<r) {
        int tmp = nums[l];
        nums[l++] = nums[r];
        nums[r--] = tmp;
    }
}