Language : Java

```.java
class Solution {
    public int calculate(String s) {
        s += "+";
        char[] operator = new char[s.length()/2+1];
        int[] operand = new int[s.length()/2+1];
        int operatorPtr = 1;
        int operandPtr = 1;
        int curValue = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char _a = s.charAt(i);
            if(Character.isDigit(_a))
                curValue = curValue * 10 + (_a - '0');
            if(_a < 48 && _a != ' '){
                if(operator[operandPtr-1] == '*'){
                    operand[operandPtr-1] *= curValue;
                    operator[operatorPtr-1] = _a;
                } else if(operator[operandPtr-1] == '/'){
                    operand[operandPtr-1] /= curValue;
                    operator[operatorPtr-1] = _a;
                } else {
                    operand[operandPtr++] = curValue;
                    operator[operatorPtr++] = _a;
                    count++;
                }
                curValue = 0;
            }
            
        }
        for(int i=1; i<count; i++){
            if(operator[i] == '+')
                operand[i+1] += operand[i];
            else
                operand[i+1] = operand[i]-operand[i+1];
        }
        return operand[count];
    }
}
```
