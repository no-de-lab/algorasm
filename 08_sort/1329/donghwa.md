언어: Java

시간복잡도: O(n^2)

```.java
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int v_len = mat.length;
        int h_len = mat[0].length;
        int[][] newMat;
        // 가로가 더 길다면
        if(v_len < h_len){
            newMat = new int[h_len][v_len];
            // 가로를 짧게하기
            int[][] tempMat = new int[h_len][v_len];
            for(int i=0; i<h_len; i++)
                for(int j=0; j<v_len; j++)
                    tempMat[i][j] = mat[j][i];
            
            // 우선순위 조정하기
            for(int i=0; i<v_len; i++)
                for(int j=0; j<v_len; j++)
                    if(i<j) tempMat[i][j] *= 100;    
            
            // 일직선으로 만들기
            for(int i=0; i<h_len; i++)
                for(int j=0; j<v_len; j++)
                    newMat[i][j] = tempMat[(i+j)%h_len][j];
            
            // 정렬하기
            for(int i=0; i<h_len; i++)
                Arrays.sort(newMat[i]);
            
            // 대각선으로 만들기
            for(int i=0; i<h_len; i++)
                for(int j=0; j<v_len; j++)
                    tempMat[i][j] = newMat[(h_len+i-j)%h_len][j];
            
            // 우선순위 원상복구
            for(int i=0; i<v_len; i++)
                for(int j=0; j<v_len; j++)
                    if(i<j) tempMat[i][j] /= 100;
            
            // 다시 가로를 길게하기
            for(int i=0; i<v_len; i++)
                for(int j=0; j<h_len; j++)
                    mat[i][j] = tempMat[j][i];
        } else { // 세로가 더 길다면
            newMat = new int[v_len][h_len];
            // 우선순위 조정하기
            for(int i=0; i<h_len; i++)
                for(int j=0; j<h_len; j++)
                    if(i<j) mat[i][j] *= 100;
            
            // 일직선으로 만들기
            for(int i=0; i<v_len; i++)
                for(int j=0; j<h_len; j++)
                    newMat[i][j] = mat[(i+j)%v_len][j];
            
            // 정렬하기
            for(int i=0; i<v_len; i++)
                Arrays.sort(newMat[i]);
            
            // 대각선으로 만들기
            for(int i=0; i<v_len; i++)
                for(int j=0; j<h_len; j++)
                    mat[i][j] = newMat[(v_len+i-j)%v_len][j];
            
            // 우선순위 원상복구
            for(int i=0; i<h_len; i++)
                for(int j=0; j<h_len; j++)
                    if(i<j) mat[i][j] /= 100;
        }
        return mat;
    }
}
```
