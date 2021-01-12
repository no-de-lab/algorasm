```.java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        for(int i=0;i<c.length; i++){
            // "(" : 40, ")" : 41, "[" : 91, "]" : 93, "{" : 123, "}" : 125
            if(c[i] == 40 || c[i] == 91 || c[i] == 123)
                stack.push(c[i]);
            else{
                if(stack.isEmpty()) return false;
                char _c = stack.pop();
                if(!((_c == 40 && c[i] == 41) || (_c == 91 && c[i] == 93) || (_c == 123 && c[i] == 125)))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
```
