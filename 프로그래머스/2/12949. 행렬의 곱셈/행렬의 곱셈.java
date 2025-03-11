class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        // 결과 행렬의 행 개수
        int newRow = arr1.length;
        // 결과 행렬의 열 개수
        int newCol = arr2[0].length;
        int[][] answer = new int[newRow][newCol];
        
        for (int row1 = 0; row1 < arr1.length; row1++) {
            for (int col2 = 0; col2 < arr2[0].length; col2++) {
                int newVal = 0;
                for (int col1 = 0; col1 < arr1[0].length; col1++) {
                    newVal += arr1[row1][col1] * arr2[col1][col2];
                }
                answer[row1][col2] = newVal;
            }
        }
        
        return answer;
    }
}