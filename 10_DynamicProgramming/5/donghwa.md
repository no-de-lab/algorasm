

```java
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int maxlen = 0;
        for(int i=0; i<len; i++){
            if(maxlen>=(i+1)*2 || maxlen>=(len-i)*2)
                break;
            int j=0;
            while(i-j>=0 && i+1+j<len && s.charAt(i-j) == s.charAt(i+1+j)){
                j++;
            }
            if(maxlen < 2*j){
                left = i-j+1;
                right = i+j;
                maxlen = 2*j;
            }
            j=1;
            while(i-j>=0 && i+j<len && s.charAt(i-j) == s.charAt(i+j)){
                j++;
            }
            if(maxlen < 2*(j-1)+1){
                left = i-j+1;
                right = i+j-1;
                maxlen = 2*(j-1)+1;
            }
        }
        return s.substring(left, right+1);
    }
}
```
