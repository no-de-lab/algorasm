언어: 자바

```.java
class Solution {
    List<String> list = new LinkedList<>();
    String[][] numSet = {{},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return list;
        combining(0, "", digits);
        return list;
    }
    public void combining(int idx, String letter, String digits){
        if(idx>=digits.length()){
            list.add(letter);
            return;
        }
        int num = (int)digits.charAt(idx)-48;
        for(int i=0; i<numSet[num].length; i++){
            combining(idx+1, letter+numSet[num][i], digits);
        }
    }
}
```
