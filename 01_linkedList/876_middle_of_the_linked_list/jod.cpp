// see: https://leetcode.com/problems/middle-of-the-linked-list/submissions/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
using namespace std;

class Solution {
public:
    int count;
    ListNode* middleNode(ListNode* head) {
        count=0;
        // 노드 개수를 체크하기 위한 노드
        ListNode* ptr = head;
        while(ptr->next != NULL) {
            count++; // 노드가 몇개인지 체크
            cout<<ptr->val<<"  "<<count<<endl;   
            ptr = ptr->next;
        }
        
        // 노드 개수가 홀수이면 한개 더 증가시킴
        if(count%2 == 1) count++;
        
        // 중간 노드까지 이동
        for(int i=0; i<count/2; i++) {
            head = head->next;
        }
        return head;
    }
};
