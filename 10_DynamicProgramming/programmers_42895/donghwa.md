언어: 자바


```.java
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        int[][] numSet = new int[9][3000];
        boolean[] check = new boolean[32001];
        // 1개
        if(number == N) return 1;
        numSet[1][0] = N;
        check[N] = true;
        // 2개
        if(number == N/N) return 2;
        numSet[2][0] = N/N;
        check[N/N] = true;
        if(number == N+N) return 2;
        numSet[2][1] = N+N;
        check[N+N] = true;
        if(number == N*N) return 2;
        numSet[2][2] = N*N;
        check[N*N] = true;
        if(number == N*10+N) return 2;
        numSet[2][3] = N*10+N;
        check[N*10+N] = true;
        // n개(count)
        for(int count = 3; count < 9; count++){
            for(int i = 1; i <= count/2; i++){
                int j = count - i;
                int a = 0;
                int innerCount = 0;
                while(numSet[i][a] != 0){
                    int b = 0;
                    int temp = 0;
                    while(numSet[j][b] != 0){
                        // 더하기
                        temp = numSet[i][a] + numSet[j][b];
                        if(temp == number) return count;
                        if(temp <= 32000 && temp > 0){
                            if(check[temp] == false){
                                numSet[count][innerCount] = temp;
                                innerCount++;
                                check[temp] = true;
                            }
                        }
                        // 빼기
                        temp = numSet[i][a] > numSet[j][b] ? numSet[i][a] - numSet[j][b] : numSet[j][b] - numSet[i][a];
                        if(temp == number) return count;
                        if(temp <= 32000 && temp > 0){
                            if(check[temp] == false){
                                numSet[count][innerCount] = temp;
                                innerCount++;
                                check[temp] = true;
                            }
                        }
                        // 곱하기
                        temp = numSet[i][a] * numSet[j][b];
                        if(temp == number) return count;
                        if(temp <= 32000 && temp > 0){
                            if(check[temp] == false){
                                numSet[count][innerCount] = temp;
                                innerCount++;
                                check[temp] = true;
                            }
                        }
                        // 나누기
                        temp = numSet[i][a] > numSet[j][b] ? numSet[i][a] / numSet[j][b] : numSet[j][b] / numSet[i][a];
                        if(temp == number) return count;
                        if(temp <= 32000 && temp > 0){
                            if(check[temp] == false){
                                numSet[count][innerCount] = temp;
                                innerCount++;
                                check[temp] = true;
                            }
                        }
                        // 붙이기
                        temp = numSet[i][a]*10 + numSet[j][b];
                        if(temp == number) return count;
                        if(temp <= 32000 && temp > 0){
                            if(check[temp] == false){
                                numSet[count][innerCount] = temp;
                                innerCount++;
                                check[temp] = true;
                            }
                        }
                        temp = numSet[j][b]*10 + numSet[i][a];
                        if(temp == number) return count;
                        if(temp <= 32000 && temp > 0){
                            if(check[temp] == false){
                                numSet[count][innerCount] = temp;
                                check[temp] = true;
                            }
                        }
                        b++;
                    }
                    a++;
                }
            }
        }
        return -1;
    }
}
```
