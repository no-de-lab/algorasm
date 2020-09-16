class Solution {
    public int[] plusOne(int[] digits) {
        int[] newdigits;
        int idx = digits.length-1;
        while(true){
            if(digits[idx] != 9){
                digits[idx]++;
                break;
            } else {
                digits[idx--]=0;
                if(idx==-1){
                    newdigits = new int[digits.length+1];
                    for(int i=0;i<digits.length;i++)
                        newdigits[i+1] = digits[i];
                    newdigits[0] = 1;
                    return newdigits;
                }
            }
            
        }
        return digits;
    }
}