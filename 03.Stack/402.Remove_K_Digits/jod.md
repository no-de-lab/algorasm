```cpp
class Solution {
public:
string removeKdigits(string num, int k) {
        int digits = num.length() - k; // 자릿수 계산
        char[] stk = new char[num.length()]; // 스택 생성
        int top = 0;

        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && stk[top-1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            stk[top++] = c;
        }

        // 0이 아닌 첫 위치를 찾는다.
        int idx = 0;
        while (idx < digits && stk[idx] == '0') idx++;
        return idx == digits? "0": new String(stk, idx, digits - idx);
    }

};
```
